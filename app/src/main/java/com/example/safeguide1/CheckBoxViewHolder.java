package com.example.safeguide1;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckBoxViewHolder extends RecyclerView.ViewHolder {

    public CheckBox checkBox;
    public TextView textView;


    public CheckBoxViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.item_checkbox);
        textView = itemView.findViewById(R.id.item_checkbox);
    }
}
