package com.example.safeguide1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class PredefinedItemsFragment extends Fragment {

    private RecyclerView recyclerViewPredefinedItems;
    private PredefinedItemsAdapter predefinedItemsAdapter;
    private ArrayList<String> predefinedItems;
    private ArrayList<String> itemsToRemove = new ArrayList<>();
    private DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predefined_items, container, false);

        recyclerViewPredefinedItems = view.findViewById(R.id.recyclerViewDefaultItems);

        predefinedItems = new ArrayList<>();
        predefinedItems.add("Drinking Water");
        predefinedItems.add("Water Container");
        predefinedItems.add("Food");
        predefinedItems.add("Emergency Blanket");
        predefinedItems.add("Prescribed Medicines");
        predefinedItems.add("Glasses");
        predefinedItems.add("ID");
        predefinedItems.add("Family Contacts");
        predefinedItems.add("Clothes");
        predefinedItems.add("Gloves");
        predefinedItems.add("Face Mask");
        predefinedItems.add("Radio");
        predefinedItems.add("Flashlight");
        predefinedItems.add("Power bank");
        predefinedItems.add("Whistle");
        predefinedItems.add("Batteries");
        predefinedItems.add("Plastic Bags");
        predefinedItems.add("Toilet Papers");
        predefinedItems.add("Hand Sanitizer");
        predefinedItems.add("Dental Cleaning");
        predefinedItems.add("Disinfecting Wipes");
        predefinedItems.add("Sanitary Gloves");
        predefinedItems.add("Dressing/Bandages");
        predefinedItems.add("Petroleum Jelly");
        predefinedItems.add("Pain Reliever");
        predefinedItems.add("Antibiotic Ointment");
        predefinedItems.add("Anti-Diarrhea");
        predefinedItems.add("Tarp");
        predefinedItems.add("Rope");
        predefinedItems.add("Safety Pins");
        predefinedItems.add("Pocket Knife");
        predefinedItems.add("Duct Tape");
        predefinedItems.add("Lighter");
        predefinedItems.add("Cooking Tools/Fuel");

        db = new DatabaseHelper(getContext());

        predefinedItemsAdapter = new PredefinedItemsAdapter(predefinedItems, this::addItemToGoBag, db);
        recyclerViewPredefinedItems.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPredefinedItems.setAdapter(predefinedItemsAdapter);

        return view;
    }

    private void addItemToGoBag(String item) {
        itemsToRemove.add(item);
        if (getParentFragmentManager().getBackStackEntryCount() > 0) {
            getParentFragmentManager().popBackStack();
        }

        predefinedItemsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        removeCheckedItems();
    }

    private void removeCheckedItems() {
        for (String item : itemsToRemove) {
            predefinedItems.remove(item);
        }
        itemsToRemove.clear();

        predefinedItemsAdapter.notifyDataSetChanged();
    }

    public void addItemToPredefinedList(String item) {
        predefinedItems.add(item);
        predefinedItemsAdapter.notifyDataSetChanged();
    }
}
