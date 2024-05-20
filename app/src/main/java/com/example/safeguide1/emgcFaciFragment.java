package com.example.safeguide1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.shape.RelativeCornerSize;

import java.util.ArrayList;
import java.util.List;

public class emgcFaciFragment extends Fragment implements emgcFaci_Adapter.OnTextClickListener {
    private RecyclerView recyclerView;
    private emgcFaci_Adapter emgcFaci_Adapter;
    private ImageView imageView;

    private ImageView imageView1;

    private RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emgc_faci, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerfacilitymapcenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        imageView1 = view.findViewById(R.id.back_evacmap);
        relativeLayout = view.findViewById(R.id.popuprelative2);

        // Create and set adapter
        List<txtItems_facilities> txtItems_facilities = createTextItems();
        emgcFaci_Adapter = new emgcFaci_Adapter(txtItems_facilities, requireContext());
        emgcFaci_Adapter.setOnTextClickListener(this);
        recyclerView.setAdapter(emgcFaci_Adapter);

        // Initialize ImageView
        imageView = view.findViewById(R.id.emgcfacimap_imageview);

        return view;
    }

    private List<txtItems_facilities> createTextItems() {
        List<txtItems_facilities> txtItems_facilities = new ArrayList<>();
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));
        txtItems_facilities.add(new txtItems_facilities("Facilities", R.drawable.map_stage));





        // Add more items as needed
        return txtItems_facilities;
    }

    @Override
    public void onTextClick(txtItems_facilities item) {
        // Handle the text item click event
        int imageResourceId = item.getImageResourceId();

        // Show the ImageView and back button
        imageView.setImageResource(imageResourceId);
        imageView.setVisibility(View.VISIBLE);
        imageView1.setVisibility(View.VISIBLE);
        relativeLayout.setVisibility(View.VISIBLE);

        // Set click listener for the back button
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hide the ImageView and back button
                imageView.setVisibility(View.GONE);
                imageView1.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.GONE);
            }
        });
    }
}
