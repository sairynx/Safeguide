package com.example.safeguide1;


import android.icu.text.CaseMap;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_homee, container, false);

        TextView greetingmessage = view.findViewById(R.id.greetingmessage);
        String greeting = getGreetingMessage();
        greetingmessage.setText(greeting);
        
        
        CardView cardView = view.findViewById(R.id.card1);

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                HomeFragment fragment = new HomeFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new DisasterFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        CardView cardView1 = view.findViewById(R.id.card2);

        cardView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                HomeFragment fragment = new HomeFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Replace the current fragment with the new fragment
                transaction.replace(R.id.fragment_container, new GoBagFragment());
                transaction.addToBackStack(null);
                transaction.commit();

            }

        });
        return view;
    }

    private String getGreetingMessage() {
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        if (hourOfDay >= 6 && hourOfDay < 12) {
            return "Good Morning!";
        } else if (hourOfDay >= 12 && hourOfDay < 18) {
            return "Good Afternoon!";
        } else  {
            return "Good Evening!";
        }

    }


}
