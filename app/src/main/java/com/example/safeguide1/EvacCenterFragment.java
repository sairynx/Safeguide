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

public class EvacCenterFragment extends Fragment implements EvacCenterAdapter.OnTextClickListener {
    private RecyclerView recyclerView;
    private EvacCenterAdapter evacCenterAdapter;
    private ImageView imageView;

    private ImageView imageView1;

    private RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evac_center, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclermapcenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        imageView1 = view.findViewById(R.id.back_evacmap);
        relativeLayout = view.findViewById(R.id.popuprelative1);

        // Create and set adapter
        List<txtItems_evaccenter> txtItems_evaccenters = createTextItems();
        evacCenterAdapter = new EvacCenterAdapter(txtItems_evaccenters, requireContext());
        evacCenterAdapter.setOnTextClickListener(this);
        recyclerView.setAdapter(evacCenterAdapter);

        // Initialize ImageView
        imageView = view.findViewById(R.id.evacmap_imageview);

        return view;
    }

    private List<txtItems_evaccenter> createTextItems() {
        List<txtItems_evaccenter> txtItems_evaccenter = new ArrayList<>();
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));
        txtItems_evaccenter.add(new txtItems_evaccenter("Test", R.drawable.map_stage));




        // Add more items as needed
        return txtItems_evaccenter;
    }

    @Override
    public void onTextClick(txtItems_evaccenter item) {
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
