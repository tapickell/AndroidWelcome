package me.toddpickell.welcomedroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity {
	
	Button punch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		punch = (Button) findViewById(R.id.button1);
		punch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// display scan view for punch
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_welcome, menu);
		return true;
	}

}
