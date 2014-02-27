package com.example.mas_victoryleap;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class RegistrationActivity extends Activity {
	private String Email,Password,ConfirmedPassword;
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
		
		findViewById(R.id.b_register).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptRegister();
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

	public void attemptRegister(){
		

		
		
		
		Password = passwordField.getText().toString();
		ConfirmedPassword = confirmedPasswordField.getText().toString();
		Email = emailField.getText().toString();
		boolean cancel = false;
		View focusView = null;

		
		
		
		// Check for a valid password.
		if (TextUtils.isEmpty(Password)) {
			passwordField.setError(getString(R.string.error_field_required));
			focusView = passwordField;
			cancel = true;
		}
		if (TextUtils.isEmpty(ConfirmedPassword)){
			confirmedPasswordField.setError(getString(R.string.error_field_required));
			focusView = confirmedPasswordField;
			cancel = true;
			
		}
		else if(!Password.equals(ConfirmedPassword)){
			AlertDialog.Builder alert = new AlertDialog.Builder(RegistrationActivity.this);
			alert.setTitle("Error");
			alert.setMessage("Password does not match!");
			
			alert.setPositiveButton("OK",
					  new DialogInterface.OnClickListener() {
					    public void onClick(DialogInterface dialog,int id) {
						dialog.cancel(); } });
			alert.show();

		}
		
		else if (Password.length() < 4) {
			passwordField.setError(getString(R.string.error_invalid_password));
			focusView = passwordField;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(Email)) {
			emailField.setError(getString(R.string.error_field_required));
			focusView = emailField;
			cancel = true;
		} else if ((!Email.contains("@")) || (!Email.contains("."))) {
			emailField.setError(getString(R.string.error_invalid_email));
			focusView = emailField;
			cancel = true;
		}
		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		}else{
		
		LoginActivity.DUMMY_CREDENTIALS[0]=Email+":"+Password;
		 Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
         startActivity(intent);  
		
		}
		
	}
	
	
}
