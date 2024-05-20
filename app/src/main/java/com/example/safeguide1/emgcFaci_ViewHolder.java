package com.example.safeguide1;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class emgcFaci_ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ImageView imageView;

    public emgcFaci_ViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.txtemgcfacicenter);
        imageView = itemView.findViewById(R.id.emgcfacimap_imageview);
    }

    public void bind(txtItems_facilities item) {
        textView.setText(item.getText());
        imageView.setImageResource(item.getImageResourceId());
    }
}
