package com.example.safeguide1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EvacCenterAdapter extends RecyclerView.Adapter<EvacCenterAdapter.EvacCenterViewHolder> {
    private List<txtItems_evaccenter> txtItems_evaccenters;
    private Context context;
    private OnTextClickListener onTextClickListener;

    public EvacCenterAdapter(List<txtItems_evaccenter> txtItems_evaccenters, Context context) {
        this.txtItems_evaccenters = txtItems_evaccenters;
        this.context = context;
    }

    public interface OnTextClickListener {
        void onTextClick(txtItems_evaccenter item);
    }

    public void setOnTextClickListener(OnTextClickListener listener) {
        this.onTextClickListener = listener;
    }

    public static class EvacCenterViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public EvacCenterViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtevaccenter);
        }

        public void bind(txtItems_evaccenter item) {
            textView.setText(item.getText());
        }
    }

    @NonNull
    @Override
    public EvacCenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercenter, parent, false);
        return new EvacCenterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EvacCenterViewHolder holder, int position) {
        txtItems_evaccenter item = txtItems_evaccenters.get(position);
        holder.bind(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTextClickListener != null) {
                    onTextClickListener.onTextClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return txtItems_evaccenters.size();
    }
}
