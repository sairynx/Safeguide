package com.example.safeguide1;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_disaster, container, false);

        CardView cardView2 = view.findViewById(R.id.card3);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_stormsurge1(), "Disaster_Stormsurge");
            }
        });

        CardView cardView3 = view.findViewById(R.id.card4);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_fire(), "Disaster_Fire");
            }
        });

        CardView cardView4 = view.findViewById(R.id.card5);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_earthquake(), "Disaster_Earthquake");
            }
        });

        CardView cardView5 = view.findViewById(R.id.card6);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_tsunami(), "Disaster_Tsunami");
            }
        });

        CardView cardView6 = view.findViewById(R.id.card7);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_tropicalstorm(), "Disastertropicalstorm");
            }
        });

        CardView cardView7 = view.findViewById(R.id.card8);
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_thunderstorm(), "Disaster_Thunderstorm");
            }
        });

        CardView cardView8 = view.findViewById(R.id.card9);
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new lec_terrorism(), "Disaster_Terrorism");
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();


    }
}
