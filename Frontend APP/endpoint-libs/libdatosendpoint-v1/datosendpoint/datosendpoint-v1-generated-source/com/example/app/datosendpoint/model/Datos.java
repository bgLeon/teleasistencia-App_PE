/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-26 at 02:25:17 UTC 
 * Modify at your own risk.
 */

package com.example.app.datosendpoint.model;

/**
 * Model definition for Datos.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the datosendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Datos extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("aceleracion_x")
  private java.lang.Double aceleracionX;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("aceleracion_y")
  private java.lang.Double aceleracionY;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("aceleracion_z")
  private java.lang.Double aceleracionZ;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean alarma;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double azucar;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean gas;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("giroscopio_x")
  private java.lang.Double giroscopioX;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("giroscopio_y")
  private java.lang.Double giroscopioY;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("giroscopio_z")
  private java.lang.Double giroscopioZ;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double latitud;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double longitud;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer pulso;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer telefono;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer temperatura;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double tension;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer tiempo;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAceleracionX() {
    return aceleracionX;
  }

  /**
   * @param aceleracionX aceleracionX or {@code null} for none
   */
  public Datos setAceleracionX(java.lang.Double aceleracionX) {
    this.aceleracionX = aceleracionX;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAceleracionY() {
    return aceleracionY;
  }

  /**
   * @param aceleracionY aceleracionY or {@code null} for none
   */
  public Datos setAceleracionY(java.lang.Double aceleracionY) {
    this.aceleracionY = aceleracionY;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAceleracionZ() {
    return aceleracionZ;
  }

  /**
   * @param aceleracionZ aceleracionZ or {@code null} for none
   */
  public Datos setAceleracionZ(java.lang.Double aceleracionZ) {
    this.aceleracionZ = aceleracionZ;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getAlarma() {
    return alarma;
  }

  /**
   * @param alarma alarma or {@code null} for none
   */
  public Datos setAlarma(java.lang.Boolean alarma) {
    this.alarma = alarma;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAzucar() {
    return azucar;
  }

  /**
   * @param azucar azucar or {@code null} for none
   */
  public Datos setAzucar(java.lang.Double azucar) {
    this.azucar = azucar;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getGas() {
    return gas;
  }

  /**
   * @param gas gas or {@code null} for none
   */
  public Datos setGas(java.lang.Boolean gas) {
    this.gas = gas;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getGiroscopioX() {
    return giroscopioX;
  }

  /**
   * @param giroscopioX giroscopioX or {@code null} for none
   */
  public Datos setGiroscopioX(java.lang.Double giroscopioX) {
    this.giroscopioX = giroscopioX;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getGiroscopioY() {
    return giroscopioY;
  }

  /**
   * @param giroscopioY giroscopioY or {@code null} for none
   */
  public Datos setGiroscopioY(java.lang.Double giroscopioY) {
    this.giroscopioY = giroscopioY;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getGiroscopioZ() {
    return giroscopioZ;
  }

  /**
   * @param giroscopioZ giroscopioZ or {@code null} for none
   */
  public Datos setGiroscopioZ(java.lang.Double giroscopioZ) {
    this.giroscopioZ = giroscopioZ;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Datos setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLatitud() {
    return latitud;
  }

  /**
   * @param latitud latitud or {@code null} for none
   */
  public Datos setLatitud(java.lang.Double latitud) {
    this.latitud = latitud;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLongitud() {
    return longitud;
  }

  /**
   * @param longitud longitud or {@code null} for none
   */
  public Datos setLongitud(java.lang.Double longitud) {
    this.longitud = longitud;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getPulso() {
    return pulso;
  }

  /**
   * @param pulso pulso or {@code null} for none
   */
  public Datos setPulso(java.lang.Integer pulso) {
    this.pulso = pulso;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getTelefono() {
    return telefono;
  }

  /**
   * @param telefono telefono or {@code null} for none
   */
  public Datos setTelefono(java.lang.Integer telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getTemperatura() {
    return temperatura;
  }

  /**
   * @param temperatura temperatura or {@code null} for none
   */
  public Datos setTemperatura(java.lang.Integer temperatura) {
    this.temperatura = temperatura;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getTension() {
    return tension;
  }

  /**
   * @param tension tension or {@code null} for none
   */
  public Datos setTension(java.lang.Double tension) {
    this.tension = tension;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getTiempo() {
    return tiempo;
  }

  /**
   * @param tiempo tiempo or {@code null} for none
   */
  public Datos setTiempo(java.lang.Integer tiempo) {
    this.tiempo = tiempo;
    return this;
  }

  @Override
  public Datos set(String fieldName, Object value) {
    return (Datos) super.set(fieldName, value);
  }

  @Override
  public Datos clone() {
    return (Datos) super.clone();
  }

}
