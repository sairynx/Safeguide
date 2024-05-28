package com.example.safeguide1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutUsFragment extends Fragment {
//committtttt
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        TextView versionTextView = view.findViewById(R.id.versionTextView);
        String versionName = BuildConfig.VERSION_NAME;
        versionTextView.setText("Version: " + versionName);
        return view;
    }
}