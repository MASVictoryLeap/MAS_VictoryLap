package com.example.mas_victoryleap;

import com.example.mas_victoryleap.LoginActivity.UserLoginTask;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends Activity {
	private String LastName,FirstName, Email,Password,ConfirmedPassword;
	
	//UI references
	private EditText firstNameField, lastNameField, emailField, passwordField, confirmedPasswordField;
	private RegisterTask mAuthTask = null;
	private TextView mRegisterStatusMessageView;
	private View mRegisterStatusView;
	private View mRegisterFormView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		firstNameField=(EditText)findViewById(R.id.et_firstName);
		lastNameField=(EditText)findViewById(R.id.et_lastName);
		emailField = (EditText) findViewById(R.id.et_email);
		passwordField = (EditText) findViewById(R.id.et_password);
		confirmedPasswordField = (EditText) findViewById(R.id.et_confirmPassword);
		
		mRegisterFormView = findViewById(R.id.register_form);
		mRegisterStatusView = findViewById(R.id.register_status);
		mRegisterStatusMessageView = (TextView) findViewById(R.id.register_status_message);
		
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
		//getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

	public void attemptRegister(){
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		firstNameField.setError(null);
		lastNameField.setError(null);
		emailField.setError(null);
		passwordField.setError(null);
		confirmedPasswordField.setError(null);
		
		FirstName = firstNameField.getText().toString();
		LastName = lastNameField.getText().toString();
		Password = passwordField.getText().toString();
		ConfirmedPassword = confirmedPasswordField.getText().toString();
		Email = emailField.getText().toString();
		boolean cancel = false;
		View focusView = null;

		

		
		
		// Check for a valid password.
		if (TextUtils.isEmpty(ConfirmedPassword)){
			confirmedPasswordField.setError(getString(R.string.error_field_required));
			focusView = confirmedPasswordField;
			cancel = true;
		}
		if (TextUtils.isEmpty(Password)) {
			passwordField.setError(getString(R.string.error_field_required));
			focusView = passwordField;
			cancel = true;
		}
		else if (Password.length() < 4) {
			passwordField.setError(getString(R.string.error_invalid_password));
			focusView = passwordField;
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
			focusView = passwordField;
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
		
		//check for a valid name
		if (TextUtils.isEmpty(LastName)) {
			lastNameField.setError(getString(R.string.error_field_required));
			focusView = lastNameField;
			cancel = true;
		}
		if (TextUtils.isEmpty(FirstName)) {
			firstNameField.setError(getString(R.string.error_field_required));
			focusView = firstNameField;
			cancel = true;
		}
		
		
		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		}else{
		
		//Do something when all fields are valid
			mRegisterStatusMessageView.setText(R.string.register_progress_signing_in);
			showProgress(true);
			mAuthTask = new RegisterTask();
			mAuthTask.execute((Void) null);
			
	//	LoginActivity.DUMMY_CREDENTIALS[0]=Email+":"+Password;
		// Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
         //startActivity(intent);  
		
		}
		
	}
	
	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mRegisterStatusView.setVisibility(View.VISIBLE);
			mRegisterStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mRegisterStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});
			
			mRegisterFormView.setVisibility(View.VISIBLE);
			mRegisterFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mRegisterFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mRegisterStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}
	
	
	
	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class RegisterTask extends AsyncTask<Void, Void, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				return false;
			}

			// TODO: register the new account here. if success, return true else return false

			//DEFAULT RETURN, change it when you implement account registration
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			showProgress(false);

			
			//transit to mainActivity if account is valid, else displays invalid account alert and clears the fields
			if (success) {
				 Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
	             startActivity(intent);
				
			} else {
				AlertDialog.Builder alert = new AlertDialog.Builder(RegistrationActivity.this);
				alert.setTitle(getString(R.string.promp_error));
				alert.setMessage(getString(R.string.error_invalid_account));
				alert.setPositiveButton("OK",
						  new DialogInterface.OnClickListener() {
						    public void onClick(DialogInterface dialog,int id) {
							dialog.cancel(); } });
				alert.show();
				firstNameField.setText(null); 
				lastNameField.setText(null);
				passwordField.setText(null);
				emailField.setText(null);
				confirmedPasswordField.setText(null);
				
				
				
				
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
	
	
}
