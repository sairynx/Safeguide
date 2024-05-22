package com.example.safeguide1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class lec_terrorism extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lec_terrorism, container,
                false);
        ImageSlider imageSlider = view.findViewById(R.id.imageslider7);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.step1terrorism, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step2terrorism, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step3terrorism, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step4terrorism, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step5terrorism, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step1bombthreat, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step2bombthreat, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step3bombthreat, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step4bombthreat, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return view;
    }
}