package com.example.safeguide1;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class EvacCenterViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ImageView imageView;

    public EvacCenterViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.txtevaccenter);
        imageView = itemView.findViewById(R.id.evacmap_imageview);
    }

    public void bind(txtItems_facilities item) {
        textView.setText(item.getText());
        imageView.setImageResource(item.getImageResourceId());
    }
}
