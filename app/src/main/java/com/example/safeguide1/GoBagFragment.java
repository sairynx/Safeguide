package com.example.safeguide1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class GoBagFragment extends Fragment {

    private RecyclerView recyclerViewMyBag;
    private Button btnImport, btnAdd;
    private GoBagAdapter GoBagAdapter;
    private ArrayList<String> GoBagItems;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gobag, container, false);

        recyclerViewMyBag = view.findViewById(R.id.recyclerViewMyBag);
        btnImport = view.findViewById(R.id.btnImport);
        btnAdd = view.findViewById(R.id.btnAdd);

        databaseHelper = new DatabaseHelper(getContext());
        GoBagItems = databaseHelper.getAllItems();
        GoBagAdapter = new GoBagAdapter(GoBagItems, databaseHelper);
        recyclerViewMyBag.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMyBag.setAdapter(GoBagAdapter);

        btnImport.setOnClickListener(v -> openPredefinedItemsFragment());
        btnAdd.setOnClickListener(v -> showAddItemDialog());

        return view;
    }

    private void openPredefinedItemsFragment() {
        Fragment predefinedItemsFragment = new PredefinedItemsFragment();
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, predefinedItemsFragment)
                .addToBackStack(null)
                .commit();
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
                GoBagItems.add(newItem);
                GoBagAdapter.notifyItemInserted(GoBagItems.size() - 1);
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

}


