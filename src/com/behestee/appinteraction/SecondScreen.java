package com.behestee.appinteraction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondScreen extends Activity {
	
	EditText inputName;
	EditText inputEmail;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_screen);
		
		// Declaring input fields
		inputName = (EditText) findViewById(R.id.inputName1);
		inputEmail = (EditText) findViewById(R.id.inputEmail1);
		
		// Geting extra data 
		Intent prevScreen = getIntent();
		String name = prevScreen.getExtras().get("name").toString();
		String email = prevScreen.getExtras().get("email").toString();
		
		//show in log 
		Log.e("MyLog", name + "." + email);
		
		// Setting value to input fields
		inputName.setText(name);
		inputEmail.setText(email);
		
		Button goToFirstScreen = (Button) findViewById(R.id.go_frst_scrn);
		goToFirstScreen.setOnClickListener(new View.OnClickListener() {
			 
	        public void onClick(View arg0) {
	        	
	        	inputName = (EditText) findViewById(R.id.inputName1);
	    		inputEmail = (EditText) findViewById(R.id.inputEmail1);
	            
	        	Intent firstScreen = getIntent();
//	        	firstScreen.putExtra("name", "AndroidHive.info");
	        	firstScreen.putExtra("name", inputName.getText().toString());  // this code if you have text field associated this var inputName
	        	 
//	        	firstScreen.putExtra("mail", "AndroidHive.info");
	        	firstScreen.putExtra("mail", inputEmail.getText().toString());  // this code if you have text field associated this var inputEmail
	        	 
	        	// Setting resultCode to RESULT_OK.
	        	// It can be RESULT_CANCELED or RESULT_OK
	        	setResult(RESULT_OK,firstScreen);
	        	 
	        	// now close the second screen
	        	finish();
	        }
	    });
		
	}

}
