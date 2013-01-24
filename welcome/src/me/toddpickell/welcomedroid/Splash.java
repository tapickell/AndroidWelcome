package me.toddpickell.welcomedroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// load splash screen 
		setContentView(R.layout.splash);
		// new thread
		Thread timer = new Thread() {
			public void run() {
				try {
					//try this
					sleep(500);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				} finally {
					Intent openStartScreen = new Intent("me.toddpickell.welcomedroid.STARTINGPOINT");
					startActivity(openStartScreen);
					
				}
			}
		};
		
		timer.start();
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// kill splash screen
		finish();
	}
	

}
