package me.toddpickell.welcomedroid;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity  {

	Button punch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		punch = (Button) findViewById(R.id.button1);
		punch.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// display scan view for punch
				AlertDialog alert = new AlertDialog.Builder(Welcome.this)
						.create();
				alert.setTitle("Hand Phone to Barista");
				alert.setMessage("Please hand your phone to your Giddy Goat Barista. They will add a punch to your card for you.");
				alert.setButton("Continue",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// goto scan view for scanning qr code for punch

							}
						});
				alert.setButton2("Cancel",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// do nothing here!

							}
						});
				alert.show();
			}
		});
	//add method to get twitter status

		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_welcome, menu);
        //add credits option to menu
        //  #### should we add social integration options to menu for cleaner ui?  ####

		return true;
	}
	

}

class getTwitterFeed extends AsyncTask<Object, Object, String> {

	@Override
	protected String doInBackground(Object... params) {
		try {
			//make url for twitter api
			URL url = new URL("https://api.twitter.com/1/statuses/user_timeline.xml?screen_name=giddygoatupdate&count=1");
			//make input stream reader
			Reader tweetReader = new InputStreamReader(url.openStream());
			//make json reader
			JsonReader tweetJSONReader = new JsonReader(tweetReader); 
			//get status
			String keyFromReader = tweetJSONReader.nextName();//get key for pair
			
			//check key for match with status
			if (keyFromReader.equals("status")) {
				//get the value for that key
				
			}
			
		} catch (MalformedURLException e) {
			Log.d("TwiterFeed", e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d("TwiterFeed", e.toString());
		}
		return null;
	}
	
}

