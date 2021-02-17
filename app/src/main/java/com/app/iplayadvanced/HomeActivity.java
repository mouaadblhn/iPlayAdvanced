package com.app.iplayadvanced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.app.iplayadvanced.adapter.NearestMatchesAdapter;
import com.app.iplayadvanced.adapter.RecommendedMatchAdapter;
import com.app.iplayadvanced.fragment.ChatFragment;
import com.app.iplayadvanced.fragment.HomeFragment;
import com.app.iplayadvanced.fragment.SettingsFragment;
import com.app.iplayadvanced.fragment.TeamFragment;
import com.app.iplayadvanced.model.Match;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    protected ArrayList<Match> recommendedMatches, nearestMatches;
    private RecommendedMatchAdapter adapter;
    private NearestMatchesAdapter adapterNearest;
    public RecyclerView rv1,rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_menu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        // Default start fragment.
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        /*
        rv1 = findViewById(R.id.horizontal_list);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(layoutManager);
        rv1.setItemAnimator(new DefaultItemAnimator());

        BaseApplication context = (BaseApplication) this.getApplicationContext();
        recommendedMatches = context.getRecommendedMatches();

        adapter = new RecommendedMatchAdapter(context,recommendedMatches);

        rv1.setAdapter(adapter);


        rv2 = findViewById(R.id.vertical_list);
        LinearLayoutManager layoutManager2= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(layoutManager2);
        rv2.setItemAnimator(new DefaultItemAnimator());

        nearestMatches = context.getNearestMatches();

        adapterNearest = new NearestMatchesAdapter(context,nearestMatches);

        rv2.setAdapter(adapterNearest);
*/
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.m_home : selectedFragment = new HomeFragment();
                            break;
                        case R.id.m_chat: selectedFragment = new ChatFragment();
                            break;
                        case R.id.m_team: selectedFragment = new TeamFragment();
                            break;
                        case R.id.m_settings: selectedFragment = new SettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };

}