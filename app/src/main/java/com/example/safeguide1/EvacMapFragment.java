package com.example.safeguide1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EvacMapFragment extends Fragment implements MapAdapter.OnTextClickListener {
    private ImageView imageView;
    private ImageView imageView1;

    private  ImageView imageView2;
    private TextView textView;
    private RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evac_map, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclermap);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        imageView1 = view.findViewById(R.id.back_map);
        relativeLayout = view.findViewById(R.id.popuprelative);
        TextView clickableTextView = view.findViewById(R.id.evacmapimage);


        List<textItems> textItems = createTextItems();
        MapAdapter mapAdapter = new MapAdapter(textItems, requireContext());
        mapAdapter.setOnTextClickListener(this);
        recyclerView.setAdapter(mapAdapter);

        imageView = view.findViewById(R.id.map_gif);
        imageView2 = view.findViewById(R.id.mapholder);
        clickableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hide the GIF image
                imageView.setVisibility(View.GONE);

                // Show another image or perform any action when the clickable text is clicked
                imageView2.setImageResource(R.drawable.map_stage);
                imageView2.setVisibility(View.VISIBLE);// Example of showing another image
                imageView.setVisibility(View.GONE);
                imageView1.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private List<textItems> createTextItems() {
        List<textItems> textItems = new ArrayList<>();
        textItems.add(new textItems("Text 1", R.drawable.anime));
        textItems.add(new textItems("Text 2", R.drawable.anime));
        textItems.add(new textItems("Text 3", R.drawable.anime));
        // Add more items as needed
        return textItems;
    }

    @Override
    public void onTextClick(textItems item) {
        int imageResourceId = item.getImageResourceId();

        // Show the ImageView and back button
        imageView.setImageResource(imageResourceId);
        imageView2.setVisibility(View.GONE);
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