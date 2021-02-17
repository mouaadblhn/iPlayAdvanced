package com.app.iplayadvanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.iplayadvanced.adapter.NearestMatchesAdapter;
import com.app.iplayadvanced.adapter.RecommendedMatchAdapter;
import com.app.iplayadvanced.models.Match;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    protected ArrayList<Match> recommendedMatches, nearestMatches;
    private RecommendedMatchAdapter adapter;
    private NearestMatchesAdapter adapterNearest;
    public RecyclerView rv1,rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

    }
}