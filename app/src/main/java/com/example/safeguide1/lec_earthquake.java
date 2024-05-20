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


public class lec_earthquake extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lec_earthquake, container, false);
        ImageSlider imageSlider = view.findViewById(R.id.imageslider4);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.step1earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step2earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step3earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step4earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step5earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step6earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step7earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step8earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step9earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step10earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step11earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step12earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step13earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step14earthquake, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.step15earthquake, ScaleTypes.FIT));



        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        return view;
    }
}