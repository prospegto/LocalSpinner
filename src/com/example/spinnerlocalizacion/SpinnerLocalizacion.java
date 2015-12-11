package com.example.spinnerlocalizacion;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerLocalizacion extends Activity implements OnItemSelectedListener {
	
	Spinner spinnerLocalizacion;
	final String[] localizaciones = new String[] {"Sevilla","Jerez","Madrid","Londres"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_localizacion);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, localizaciones);
		spinnerLocalizacion = (Spinner)findViewById(R.id.spinner); 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerLocalizacion.setAdapter(adaptador);
		spinnerLocalizacion.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner_localizacion, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
			    Uri.parse("http://maps.google.com/maps?q="+localizaciones[arg2]));
			startActivity(intent);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
