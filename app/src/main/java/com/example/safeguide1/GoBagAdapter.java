package com.example.safeguide1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class GoBagAdapter extends RecyclerView.Adapter<GoBagAdapter.ViewHolder> {

    private ArrayList<String> goBagItems;
    private DatabaseHelper databaseHelper;

    public GoBagAdapter(ArrayList<String> goBagItems, DatabaseHelper databaseHelper) {
        this.goBagItems = goBagItems;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_predefined, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = goBagItems.get(position);
        holder.textViewItemName.setText(item);
        holder.deleteButton.setOnClickListener(v -> {
            // Handle delete button click here
            // For example, you can remove the item from the database
            databaseHelper.deleteItem(item);
            // Then remove the item from the list and notify the adapter
            goBagItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, goBagItems.size());
        });
    }

    @Override
    public int getItemCount() {
        return goBagItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemName;
        Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
