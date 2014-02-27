package com.example.mas_victoryleap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class RegistrationActivity extends Activity {
	private String Email;
	private String Password;
	private EditText emailField;
	private EditText passwordField;
	private EditText confirmedPasswordField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		emailField = (EditText) findViewById(R.id.et_email);
		passwordField = (EditText) findViewById(R.id.et_password);
		confirmedPasswordField = (EditText) findViewById(R.id.et_confirmPassword);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

}
