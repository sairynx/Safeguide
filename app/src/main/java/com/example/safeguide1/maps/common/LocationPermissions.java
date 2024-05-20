package com.example.safeguide1.maps.common;

import android.Manifest;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


public class LocationPermissions {

    Callback callback;
    ActivityResultLauncher<String[]> requestPermissionLauncher;

    public LocationPermissions(AppCompatActivity context){
        requestPermissionLauncher =
                context.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), isGranted -> {
                    if(!isGranted.containsValue(false)){
                        callback.onPermissionsGranted();
                    }else{
                        callback.onSomePermissionDenied();
                    }
                });
    }
    public void request(Callback callback) {
        String[] permissions;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            permissions = new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT
            };
        } else {
            permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        }
        this.callback = callback;
        requestPermissionLauncher.launch(permissions);
    }
    public interface Callback {
        void onPermissionsGranted();

        void onSomePermissionDenied();
    }
}



