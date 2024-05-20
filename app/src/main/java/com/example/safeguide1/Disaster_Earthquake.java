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


public class Disaster_Earthquake extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disaster__earthquake, container,
                false);


        CardView cardViewc8 = view.findViewById(R.id.c8);

        cardViewc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_earthquake());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        CardView cardViewc7 = view.findViewById(R.id.c7);

        cardViewc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_earthquake());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        CardView cardViewcard5 = view.findViewById(R.id.card5);

        cardViewcard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_earthquake());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

}