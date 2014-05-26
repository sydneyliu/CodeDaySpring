package com.example.springcodeday2014;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.springcodeday2014.ShakeDetector.OnShakeListener;

public class MainActivity extends ActionBarActivity implements OnClickListener  {
	Button eat;
	Button boyfriend;
	Button aiya;
	Button stupid;
	MediaPlayer eats;
	MediaPlayer boyfriends;
	MediaPlayer aiyas;
	MediaPlayer stupids;
	MediaPlayer laoshus;
	SensorManager mSensorManager;
	Sensor mAccelerometer;
	ShakeDetector mShakeDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		eat = (Button) findViewById(R.id.eat);
		boyfriend = (Button) findViewById(R.id.boyfriend);
		aiya = (Button) findViewById(R.id.aiya);
		stupid = (Button) findViewById(R.id.stupid);
		eats = MediaPlayer.create(this, R.raw.eat);
		boyfriends = MediaPlayer.create(MainActivity.this, R.raw.boyfriend);
		aiyas = MediaPlayer.create(MainActivity.this, R.raw.aiya);
		stupids = MediaPlayer.create(MainActivity.this, R.raw.stupid);
		laoshus = MediaPlayer.create(MainActivity.this, R.raw.laoshu);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mShakeDetector= new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				laoshus.start();
			}
		});
		
		eat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				eats.start();
			}
		}); 
		
		boyfriend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boyfriends.start();
			}
		});
		aiya.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				aiyas.start();
			}
		});
		stupid.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stupids.start();
			}
		});
		
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
	}
	@Override
	public void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(mShakeDetector);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
