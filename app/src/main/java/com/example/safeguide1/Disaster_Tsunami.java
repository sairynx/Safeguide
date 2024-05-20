package com.example.safeguide1;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class Disaster_Tsunami extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disaster__tsunami, container,
                false);

    CardView cardView6tsu = view.findViewById(R.id.card6tsu);

        cardView6tsu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            DisasterFragment fragment = new DisasterFragment();

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Replace the current fragment with the new fragment
            transaction.replace(R.id.fragment_container, new lec_tsunami());
            transaction.addToBackStack(null);
            transaction.commit();
        }
});

        CardView cardView5tsu = view.findViewById(R.id.card5tsu);
        cardView5tsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_tsunami());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        CardView cardView4tsu = view.findViewById(R.id.card4tsu);
        cardView4tsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_tsunami());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        CardView cardView3tsu = view.findViewById(R.id.card3tsu);
        cardView3tsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_tsunami());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    return view;
    }
}