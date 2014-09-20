package com.example.drunktaxi;


import com.example.drunktaxi.MainActivity.MyLocationListener;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	TextView longitude;
	TextView latitude;
	SensorManager mSensorManager;
	public double lat;
	public double lng;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        longitude = (TextView) findViewById((R.id.longitude));
        latitude = (TextView) findViewById((R.id.latitude));

		
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); 
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, mlocListener);
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
    public class MyLocationListener implements LocationListener 
    {
    	private MainActivity mainActivity = this.mainActivity;
    	float results[] =  new float[1];
    	

    	/* When the location of the device changes
    	 * 
    	 * Updates the longitutde and latitude displays
    	 * Updates the current degree
    	 */
        public void onLocationChanged(Location loc) 
        {
           
        	lat = loc.getLatitude(); //sets the latitude text view
        	lng = loc.getLongitude(); //sets the longitude text view
            String lati = String.valueOf(lat);
            String longi = String.valueOf(lng);
            latitude.setText("Latitude: " + lati);
            longitude.setText("Longitude: " + longi);
         
           
        }
        	 
        
        public void distanceBetween() {
        	
        }
     
         public void onProviderDisabled(String provider) 
        {
            Toast.makeText( getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show();
        }
        
        public void onProviderEnabled(String provider) 
        {
          Toast.makeText( getApplicationContext(), "Gps Enabled",Toast.LENGTH_SHORT).show();
        }
        
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
        	
        }
    }
}
