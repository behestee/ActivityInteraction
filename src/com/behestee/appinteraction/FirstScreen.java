package com.behestee.appinteraction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstScreen extends Activity {
	
	EditText inputName;
	EditText inputEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_screen);
		
		

		Button goToSecScreen = (Button) findViewById(R.id.go_to_sec_scrn);
		goToSecScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Starting a new Activity
				// startActivity(new Intent(getApplicationContext(), SecondScreen.class));
				
				inputName = (EditText) findViewById(R.id.inputName);
				inputEmail = (EditText) findViewById(R.id.inputEmail);

				Intent secondScreenIntent = new Intent(getApplicationContext(),
						SecondScreen.class);

				// adding data to the intent to send to second screen as well
//				secondScreenIntent.putExtra("name", "my name");
				// this code if you have text field associated this var inputName
				 secondScreenIntent.putExtra("name", inputName.getText().toString()); 

//				secondScreenIntent.putExtra("email", "my email");

				// this code if you have text field associated this var
				// inputEmail
				secondScreenIntent.putExtra("email", inputEmail.getText().toString());
				
				/*startActivity(secondScreenIntent );*/

				// enable this to get result from second screen
				// 2 is the which will be mention in result
				startActivityForResult(secondScreenIntent, 2);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_screen, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			// 2 is the same code that you send to the second screen when
			// startActivityForResult call..
			if (requestCode == 2) {
				//declaring inputs
				inputName = (EditText) findViewById(R.id.inputName);
				inputEmail = (EditText) findViewById(R.id.inputEmail);
				
				// Receiving the Data
				String name = data.getExtras().get("name").toString();
				String mail = data.getExtras().get("mail").toString();
				
				//sowing in log
				Log.e("MyLog", name + "." + mail);

				// Displaying Received data, assuming you have these two text
				 inputName.setText(name);
				 inputEmail.setText(mail);
			}
		}

	}

}
