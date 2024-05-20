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


public class lec_thunderstorm extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lec_thunderstorm, container, false);
        ImageSlider imageSlider = view.findViewById(R.id.imageslider5);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.step1thunderstorm, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step2thunderstorm, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step3thunderstorm, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step4thunderstorm, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step5thunderstorm, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step6thunderstorm, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step7thunderstorm, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return view;
    }

}