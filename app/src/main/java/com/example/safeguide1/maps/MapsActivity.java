package com.example.safeguide1.maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.safeguide1.R;

import es.situm.sdk.SitumSdk;
import es.situm.sdk.error.Error;
import es.situm.sdk.location.LocationListener;
import es.situm.sdk.location.LocationRequest;
import es.situm.sdk.location.LocationStatus;
import es.situm.sdk.model.location.Location;
import es.situm.sdk.wayfinding.MapView;
import es.situm.sdk.wayfinding.MapViewConfiguration;
import es.situm.sdk.wayfinding.MapViewController;

public class MapsActivity extends AppCompatActivity {
    private static final String TAG = MapsActivity.class.getSimpleName();
    private String USER = "appsafeguide@gmail.com";
    private String APIKEY = "f73fde38afb8b2e5d7176624f115fe488707db4fbebf9cc5df1babf6280962c3";
    // ... and the building you want visualize
    private String BUILDING_ID = "16289";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SitumSdk.init(this);
        SitumSdk.configuration().setApiKey(USER, APIKEY);

        LocationRequest locationRequest = new LocationRequest.Builder().build();
        SitumSdk.locationManager().requestLocationUpdates(locationRequest);
        SitumSdk.locationManager().addLocationListener(locationListener);
        MapView mapView = findViewById(R.id.exampleMapView);
        MapViewConfiguration configuration = new MapViewConfiguration.Builder()
                .setBuildingIdentifier(BUILDING_ID).build();

        mapView.load(configuration, new MapView.MapViewCallback() {
            @Override
            public void onLoad(@NonNull MapViewController mapViewController) {
            }

            @Override
            public void onError(@NonNull Error error) {
            }
        });


    }


    // These callbacks will receive positioning, status and error updates
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.d(TAG, "Location: " + location.toString());

        }

        @Override
        public void onStatusChanged(@NonNull LocationStatus locationStatus) {
            Log.d(TAG, "Status: " + locationStatus.toString());

        }

        @Override
        public void onError(@NonNull Error error) {
            Log.d(TAG, "Error: " + error.toString());

        }
    };
}