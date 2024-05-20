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


public class Disastertropicalstorm extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_disastertropicalstorm, container, false);

        CardView cardView3tstorm = view.findViewById(R.id.card3tstorm);

        cardView3tstorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisasterFragment fragment = new DisasterFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new lec_tropicalstorm());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

}
