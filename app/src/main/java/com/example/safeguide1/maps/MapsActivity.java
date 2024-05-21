package com.example.safeguide1.maps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.safeguide1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import es.situm.sdk.SitumSdk;
import es.situm.sdk.directions.DirectionsRequest;
import es.situm.sdk.error.Error;
import es.situm.sdk.location.LocationListener;
import es.situm.sdk.location.LocationManager;
import es.situm.sdk.location.LocationRequest;
import es.situm.sdk.location.LocationStatus;
import es.situm.sdk.location.RouteAdjustment;
import es.situm.sdk.location.util.CoordinateConverter;
import es.situm.sdk.model.cartography.Poi;
import es.situm.sdk.model.cartography.Point;
import es.situm.sdk.model.directions.Route;
import es.situm.sdk.model.location.Coordinate;
import es.situm.sdk.model.navigation.NavigationProgress;
import es.situm.sdk.navigation.NavigationListener;
import es.situm.sdk.navigation.NavigationRequest;
import es.situm.sdk.utils.Handler;
import es.situm.sdk.wayfinding.MapView;
import es.situm.sdk.wayfinding.MapViewConfiguration;
import es.situm.sdk.wayfinding.MapViewController;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = MapsActivity.class.getSimpleName();
    private String USER = "appsafeguide@gmail.com";
    private String APIKEY = "f73fde38afb8b2e5d7176624f115fe488707db4fbebf9cc5df1babf6280962c3";

    private String BUILDING_ID = "16289";

    private GoogleMap map;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private es.situm.sdk.model.location.Location current;
    private static final int ACCESS_FINE_LOCATION_REQUEST_CODE = 3096;
    private static final int PERMISSION_REQUEST_CODE = 1000;
    private static final int REQUEST_BLUETOOTH_PERMISSIONS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            requestBluetoothPermissions();
        }else{
            checkPermissions();
        }

        SitumSdk.init(this);
        SitumSdk.configuration().setApiKey(USER, APIKEY);


        locationManager = SitumSdk.locationManager();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if(mapFragment != null){
            mapFragment.getMapAsync(this);
        }

        LocationRequest locationRequest = new LocationRequest.Builder().useWifi(true).
                buildingIdentifier(BUILDING_ID).build();
        SitumSdk.locationManager().requestLocationUpdates(locationRequest);
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

        setup();

    }


    private void setup(){
        FloatingActionButton button = findViewById(R.id.recenter_button);
        button.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));

        button.setOnClickListener(v -> {
            Log.d(MapsActivity.class.getSimpleName(), "button clicked");
            if(locationManager.isRunning()){
                stopLocation();
            }else {
                startLocation();
            }
        });

    }


    private void startLocation(){
        if(locationManager.isRunning()){
            return;
        }

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull es.situm.sdk.model.location.Location location) {
                current = location;

                map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(current.getCoordinate().getLatitude(), current.getCoordinate().getLongitude()), 16));
                Log.d(TAG, "Current location: " + current.getCoordinate().getLatitude() + ", " + current.getCoordinate().getLongitude());
            }

            @Override
            public void onStatusChanged(@NonNull LocationStatus locationStatus) {
                Log.d(TAG, "onStatusChanged(): " + locationStatus);
            }

            @Override
            public void onError(@NonNull Error error) {
                Log.e(TAG, "onError(): " + error.getMessage());
                Toast.makeText(MapsActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }

        };
        SitumSdk.locationManager().addLocationListener(locationListener);

        LocationRequest locationRequest = new LocationRequest.Builder()
                .buildingIdentifier(BUILDING_ID)
                .useWifi(true)
                .useGps(true)
                .useCompass(true)
                .useDeadReckoning(true)
                .build();

        locationManager.requestLocationUpdates(locationRequest, locationListener);
    }
    private void stopLocation(){
        if(locationListener!=null){
            if (!locationManager.isRunning()){
                return;
            }
            locationManager.removeUpdates(locationListener);
            current = null;
        }
    }
    @Override
    public void onResume(){
        checkPermissions();
        super.onResume();
    }
    @Override
    public void onDestroy(){
        stopLocation();
        super.onDestroy();
    }

    private void requestBluetoothPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[] {
                            Manifest.permission.BLUETOOTH_SCAN,
                            Manifest.permission.BLUETOOTH_CONNECT,
                            Manifest.permission.ACCESS_FINE_LOCATION // Include location permission if needed
                    },
                    REQUEST_BLUETOOTH_PERMISSIONS);
        }
    }
    private void requestPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT},
                    PERMISSION_REQUEST_CODE);
        }else {
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_REQUEST_CODE);
        }
    }
    private void checkPermissions() {
        boolean hasFineLocationPermission = ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        if(!hasFineLocationPermission){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {

                Snackbar.make(findViewById(android.R.id.content),
                                "Need location permission to enable service",
                                Snackbar.LENGTH_INDEFINITE)
                        .setAction("Open", view -> requestPermissions()).show();
            } else {
                requestPermissions();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                finishActivity(requestCode);

            }
        }
        if (requestCode == REQUEST_BLUETOOTH_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                finishActivity(requestCode);

            }
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
    }
}