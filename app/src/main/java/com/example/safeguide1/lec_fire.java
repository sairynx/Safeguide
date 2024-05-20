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


public class lec_fire extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lec_fire, container,
                false);
        ImageSlider imageSlider = view.findViewById(R.id.imageslider6);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.step1fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step2fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step3fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step4fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step5fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step6fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step7fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step8fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step9fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step10fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step11fire, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step12fire, ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        return view;
    }
}