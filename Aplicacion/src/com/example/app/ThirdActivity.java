/**
 * 
 */
package com.example.app;
/*
 *
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_activity);
		
		EditText text2 = (EditText)findViewById(R.id.editText2);
		EditText text3 = (EditText)findViewById(R.id.editText3);
		EditText text4 = (EditText)findViewById(R.id.editText4);
		EditText text5 = (EditText)findViewById(R.id.editText5);
		EditText text6 = (EditText)findViewById(R.id.editText6);
		EditText text7 = (EditText)findViewById(R.id.editText7);
		ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton1);
		
		text2.setText("90");
		text3.setText("60");
		text4.setText("100");
		text5.setText("100");
		text6.setText("100");
		text7.setText("100");
	
		imageButton.setOnClickListener(new View.OnClickListener() {

		      @Override
		      public void onClick(View view) {
		    	  Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
			      startActivity(intent);
		      }

		 });
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	
}
