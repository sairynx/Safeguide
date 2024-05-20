package com.example.safeguide1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class main_dash extends AppCompatActivity implements manualvids.OnManualVidsBackPressedListener {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    HomeFragment homeFragment = new HomeFragment();
    botnav_hotlines botnav_hotlines = new botnav_hotlines();
    botnav_manual botnav_manual = new botnav_manual();
    List<String> fragmentBackStack = new ArrayList<>();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dash);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.burger);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
            navigationView.setCheckedItem(R.id.home_botnav);
            setTitle("Home");
            bottomNavigationView.setSelectedItemId(R.id.home_botnav);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_disaster:
                        replaceFragment(new DisasterFragment(), "DisasterFragment");
                        setTitle("Prepare");
                        break;
                    case R.id.nav_go_bag:
                        replaceFragment(new GoBagFragment(), "GoBagFragment");
                        setTitle("Emergency Go Bag");
                        break;
                    case R.id.nav_univ_map:
                        replaceFragment(new EvacMapFragment(), "EvacMapFragment");
                        setTitle("Evacuation Map");
                        break;
                    case R.id.nav_info_about:
                        replaceFragment(new AboutUsFragment(), "AboutUsFragment");
                        setTitle("About Us");
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_botnav:
                        replaceFragment(homeFragment, "HomeFragment");
                        setTitle("Home");
                        return true;
                    case R.id.hotlines_botnav:
                        replaceFragment(botnav_hotlines, "HotlinesFragment");
                        setTitle("Hotlines");
                        return true;
                    case R.id.manual_botnav:
                        replaceFragment(botnav_manual, "ManualFragment");
                        setTitle("Manual");
                        return true;
                }
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();

        fragmentBackStack.add(tag);
        if (fragmentBackStack.size() > 3) {
            fragmentBackStack.remove(1);
        }
    }
//hahahahahahahahhaahahhsahsahsah
    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (currentFragment instanceof manualvids) {
            onManualVidsBackPressed();
        } else if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (fragmentBackStack.size() > 3) {
            fragmentBackStack.remove(fragmentBackStack.size() - 1);
            String previousFragmentTag = fragmentBackStack.get(fragmentBackStack.size() - 1);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, fragmentManager.findFragmentByTag(previousFragmentTag));
            transaction.commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onManualVidsBackPressed() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new botnav_manual())
                .commit();
    }

    public void updateBackStack(String tag) {
        fragmentBackStack.add(tag);
        if (fragmentBackStack.size() > 3) {
            fragmentBackStack.remove(0);
        }
    }
}
