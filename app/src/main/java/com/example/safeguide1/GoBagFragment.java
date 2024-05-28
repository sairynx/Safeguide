package com.example.safeguide1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class GoBagFragment extends Fragment {

    private RecyclerView recyclerViewMyBag;
    private Button btnAdd;
    private GoBagAdapter goBagAdapter;
    private ArrayList<String> goBagItems;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gobag, container, false);

        recyclerViewMyBag = view.findViewById(R.id.recyclerViewMyBag);
        btnAdd = view.findViewById(R.id.btnAdd);

        databaseHelper = new DatabaseHelper(getContext());
        goBagItems = databaseHelper.getAllItems();
        goBagAdapter = new GoBagAdapter(goBagItems, databaseHelper);
        recyclerViewMyBag.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMyBag.setAdapter(goBagAdapter);

        btnAdd.setOnClickListener(v -> showAddItemDialog());
        return view;
    }

    private void showAddItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Custom Item");

        final EditText input = new EditText(getContext());
        builder.setView(input);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String newItem = input.getText().toString();
            if (!newItem.isEmpty()) {
                databaseHelper.addItem(newItem);
                goBagItems.add(newItem);
                goBagAdapter.notifyItemInserted(goBagItems.size() - 1);
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
