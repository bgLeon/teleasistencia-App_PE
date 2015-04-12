package com.example.app;

import com.example.app.PMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "datos", namespace = @ApiNamespace(ownerDomain = "example.com", ownerName = "example.com", packagePath = "app"))
public class DatosEndpoint {

	private long id = (long) 1;

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listDatos")
	public CollectionResponse<Datos> listDatos(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Datos> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Datos.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Datos>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();
			for (Datos obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Datos> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 *
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getDatos")
	public Datos getDatos(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Datos datos = null;
		try {
			datos = mgr.getObjectById(Datos.class, id);
		} finally {
			mgr.close();
		}
		return datos;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param datos
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertDatos")
	public Datos insertDatos(Datos datos) {

		datos.setId(id);

		id++;

		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsDatos(datos)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(datos);
		} finally {
			mgr.close();
		}
		ProcesadorEventos(datos);
		return datos;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param datos
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateDatos")
	public Datos updateDatos(Datos datos) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsDatos(datos)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(datos);
		} finally {
			mgr.close();
		}
		return datos;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeDatos")
	public void removeDatos(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Datos datos = mgr.getObjectById(Datos.class, id);
			mgr.deletePersistent(datos);
		} finally {
			mgr.close();
		}
	}

	/**
	 * Este método restablece el id interno al valor especificado Para no tener
	 * que volver a desplegar
	 */
	@ApiMethod(name = "setID")
	public void setId(@Named("id") Long id) {

		this.id = id;

	}

	private void ProcesadorEventos(Datos medidas) {
		System.out.println("Empezando el procesado");
		double tension = medidas.getTension();
		double aceleracionx = medidas.getAceleracion_x();
		double aceleraciony = medidas.getAceleracion_y();
		double aceleracionz = medidas.getAceleracion_z();
		double giroscopiox = medidas.getGiroscopio_x();
		double giroscopioy = medidas.getGiroscopio_y();
		double giroscopioz = medidas.getGiroscopio_z();
		double azucar = medidas.getAzucar();
		int pulso = medidas.getPulso();
		int temperatura = medidas.getTemperatura();
		int severity = 0;
		String name;
		int type;
		if (medidas.isAlarma()) {
			System.out.println("El paciente ha pulsado el botón de alarma");
			severity = 3;
			name = "DistressAlarm";
			type = 1;
			AlarmSender.sendAlarm(medidas, name, type, severity);
		}
		if (medidas.isGas()) {
			System.out
					.println("El paciente está en un lugar con demasiado gas");
			severity = 3;
			medidas.setAlarma(true);
			name = "Dangerous level of CO";
			type = 5;
			AlarmSender.sendAlarm(medidas, name, type, severity);

		}
		if (azucar < 60) {// en mg/dl
			System.out.println("El paciente tiene una bajada de azucar");
			if (severity < 1)
				severity = 1;
			medidas.setAlarma(true);
			name = "Low level of sugar";
			type = 7;
			AlarmSender.sendAlarm(medidas, name, type, severity);

		} else if (azucar > 110) {
			System.out.println("El paciente tiene una bajada de azucar");
			if (severity < 1)
				severity = 1;
			medidas.setAlarma(true);
			name = "High level of sugar";
			type = 8;
			AlarmSender.sendAlarm(medidas, name, type, severity);
		}
		if (temperatura > 42 && medidas.isGas()) {
			System.out.println("Fuego");
			severity = 3;
			medidas.setAlarma(true);
			name = "Fire";
			type = 8;
			AlarmSender.sendAlarm(medidas, name, type, severity);
		}
		if ((Math.abs(aceleraciony) > 20 || Math.abs(aceleracionx) > 20 || Math
				.abs(aceleracionz) > 20)
				&& (pulso < 60 || pulso > 140 || tension < 60)
				&& (Math.abs(giroscopiox) > 3 || Math.abs(giroscopioy) > 3 || Math
						.abs(giroscopioz) > 3)) {
			System.out.println("El paciente ha sufrido un desmayo");
			severity = 3;
			medidas.setAlarma(true);
			name = "Fall Down";
			type = 3;
			AlarmSender.sendAlarm(medidas, name, type, severity);

		}
		if (pulso < 45) {
			medidas.setAlarma(true);
			if (pulso == 0)
				severity = 3;
			if (severity < 2)
				severity = 2;
			System.out.println("El paciente está sufriendo un infarto");
			name = "Heart attack";
			type = 9;
			AlarmSender.sendAlarm(medidas, name, type, severity);

		} else if (pulso > 150) {
			System.out
					.println("Ritmo cárdiaco del paciente demasiado alto, puede causar un ataque");
			if (severity < 2)
				severity = 2;
			medidas.setAlarma(true);
			name = "High heart rate";
			type = 6;
			AlarmSender.sendAlarm(medidas, name, type, severity);
		}
		if (tension > 99) {// Importante, estoy con valores de presión
							// diastólica los valores de normal estan entre 60 y
							// 79
			if (severity < 2)
				severity = 2;
			System.out
			.println("El paciente tiene la presión excesivamente alta");
			medidas.setAlarma(true);
			name = "High blood pressure";
			type = 10;
			AlarmSender.sendAlarm(medidas, name, type, severity);
			
		} else if (tension < 40) {
			if (severity < 2)
				severity = 2;
			System.out
			.println("El paciente tiene una bajada de tensión se puede desmayar");
			medidas.setAlarma(true);
			name = "Low blood pressure";
			type = 11;
			AlarmSender.sendAlarm(medidas, name, type, severity);
		}
	}

	private boolean containsDatos(Datos datos) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Datos.class, datos.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
