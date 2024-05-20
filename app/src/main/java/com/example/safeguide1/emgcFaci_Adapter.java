package com.example.safeguide1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class emgcFaci_Adapter extends RecyclerView.Adapter<emgcFaci_Adapter.emgcFaci_ViewHolder> {
    private List<txtItems_facilities> txtItems_facilities;
    private Context context;
    private OnTextClickListener onTextClickListener;

    public emgcFaci_Adapter(List<txtItems_facilities> txtItems_facilities, Context context) {
        this.txtItems_facilities = txtItems_facilities;
        this.context = context;
    }

    public interface OnTextClickListener {
        void onTextClick(com.example.safeguide1.txtItems_facilities item);
    }

    public void setOnTextClickListener(OnTextClickListener listener) {
        this.onTextClickListener = listener;
    }

    public static class emgcFaci_ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public emgcFaci_ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtemgcfacicenter);
        }

        public void bind(txtItems_facilities item) {
            textView.setText(item.getText());
        }
    }

    @NonNull
    @Override
    public emgcFaci_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerfacilities, parent, false);
        return new emgcFaci_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull emgcFaci_ViewHolder holder, int position) {
        txtItems_facilities item = txtItems_facilities.get(position);
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
        return txtItems_facilities.size();
    }
}
