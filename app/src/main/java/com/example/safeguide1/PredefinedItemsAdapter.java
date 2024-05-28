package com.example.safeguide1;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PredefinedItemsAdapter extends RecyclerView.Adapter<PredefinedItemsAdapter.PredefinedItemViewHolder> {
    private ArrayList<String> predefinedItems;
    private SparseBooleanArray checkedItems;
    private OnAddItemListener onAddItemListener;
    private DatabaseHelper databaseHelper;

    public SparseBooleanArray getCheckedItems() {
        return checkedItems;
    }

    public interface OnAddItemListener {
        void onAddItem(String item);
    }

    public PredefinedItemsAdapter(ArrayList<String> predefinedItems, OnAddItemListener onAddItemListener, DatabaseHelper databaseHelper) {
        this.predefinedItems = predefinedItems;

        this.databaseHelper = databaseHelper;

    }


    @NonNull
    @Override
    public PredefinedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_predefined, parent, false);
        return new PredefinedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PredefinedItemViewHolder holder, int position) {
        String item = predefinedItems.get(position);
        holder.textViewItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return predefinedItems.size();
    }

    public static class PredefinedItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;

        public PredefinedItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textViewItem);
        }
    }
}
