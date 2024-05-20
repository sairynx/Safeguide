package com.example.safeguide1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<CheckBoxViewHolder> {

    private List<String> mData;
    public MyAdapter(List<String> data){
        mData = data;
    }



    @NonNull
    @Override
    public CheckBoxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcviewdesign, parent, false);
        return new CheckBoxViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckBoxViewHolder holder, int position) {
        String item = mData.get(position);
        holder.textView.setText(item);
        holder.checkBox.setText(item);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
