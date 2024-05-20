package com.example.safeguide1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class botnav_manual extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manual_botnav, container,
                false);

        CardView videosample = view.findViewById(R.id.videosample);
        CardView videosample1 = view.findViewById(R.id.videosample1); // Assuming you have another CardView for manualvids1
        CardView videosample2 = view.findViewById(R.id.videosample2); // Assuming you have another CardView for manualvids2
        CardView videosample3 = view.findViewById(R.id.videosample3); // Assuming you have another CardView for manualvids3
        CardView videosample4 = view.findViewById(R.id.videosample4); // Assuming you have another CardView for manualvids4
        CardView videosample5 = view.findViewById(R.id.videosample5); // Assuming you have another CardView for manualvids5
        CardView videosample7 = view.findViewById(R.id.videosample7);
        CardView videosample8 = view.findViewById(R.id.videosample8);
        CardView videosample9 = view.findViewById(R.id.videosample9);
        CardView videosample10 = view.findViewById(R.id.videosample10);
        CardView videosample11 = view.findViewById(R.id.videosample11);
        CardView videosample12 = view.findViewById(R.id.videosample12);
        CardView videosample13 = view.findViewById(R.id.videosample13);
        CardView videosample14 = view.findViewById(R.id.videosample14);
        CardView videosample15 = view.findViewById(R.id.videosample15);

        videosample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample
                replaceFragment(new manualvids());
            }
        });

        videosample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample1 (manualvids1)
                replaceFragment(new manualvids1());
            }
        });

        videosample2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample2 (manualvids2)
                replaceFragment(new manualvids2());
            }
        });
        videosample3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample3 (manualvids3)
                replaceFragment(new manualvids3());
            }
        });
        videosample4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample4 (manualvids4)
                replaceFragment(new manualvids4());
            }
        });
        videosample5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample5 (manualvids5)
                replaceFragment(new manualvids5());
            }
        });
        videosample7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample7 (manualvids7)
                replaceFragment(new manualvids7());
            }
        });
        videosample8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample8 (manualvids8)
                replaceFragment(new manualvids8());
            }
        });
        videosample9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids9());
            }
        });
        videosample10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids10());
            }
        });
        videosample11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids11());
            }
        });
        videosample12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids12());
            }
        });
        videosample13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids13());
            }
        });
        videosample14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids14());
            }
        });

        videosample15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event for videosample9 (manualvids9)
                replaceFragment(new manualvids15());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
