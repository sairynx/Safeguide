package com.example.safeguide1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.SchoolmapViewHolder> {
    private final List<textItems> textItems;
    private final Context context;
    private OnTextClickListener onTextClickListener;

    public MapAdapter(List<textItems> textItems, Context context) {
        this.textItems = textItems;
        this.context = context;
    }

    public interface OnTextClickListener {
        void onTextClick(textItems item);
    }

    public void setOnTextClickListener(OnTextClickListener listener) {
        this.onTextClickListener = listener;
    }

    public static class SchoolmapViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public SchoolmapViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.Textviewmaprecycler);
        }

        public void bind(textItems item) {
            textView.setText(item.getText());
        }
    }

    @NonNull
    @Override
    public SchoolmapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclermap, parent, false);
        return new SchoolmapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolmapViewHolder holder, int position) {
        textItems item = textItems.get(position);
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
        return textItems.size();
    }
}