package com.example.safeguide1;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class SchoolmapViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public SchoolmapViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.Textviewmaprecycler);
    }

    public void bind(textItems item) {
        textView.setText(item.getText());
    }
}