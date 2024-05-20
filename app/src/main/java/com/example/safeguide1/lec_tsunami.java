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


public class lec_tsunami extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lec_tsunami, container, false);
        ImageSlider imageSlider = view.findViewById(R.id.imageslider2);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.step1tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step2tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step3tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step4tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step5tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step6tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step7tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step8tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step9tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step10tsunami, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step11tsunami, ScaleTypes.FIT));



        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        return view;
    }
    }
