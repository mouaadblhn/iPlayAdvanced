package com.app.iplayadvanced.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.iplayadvanced.BaseApplication;
import com.app.iplayadvanced.R;
import com.app.iplayadvanced.adapter.NearestMatchesAdapter;
import com.app.iplayadvanced.adapter.RecommendedMatchAdapter;
import com.app.iplayadvanced.model.Match;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView rv1,rv2;
    protected ArrayList<Match> recommendedMatches, nearestMatches;
    private RecommendedMatchAdapter adapter;
    private NearestMatchesAdapter adapterNearest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        rv1 = view.findViewById(R.id.horizontal_list);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(layoutManager);
        rv1.setItemAnimator(new DefaultItemAnimator());

        BaseApplication context = (BaseApplication) getContext().getApplicationContext();
        recommendedMatches = context.getRecommendedMatches();

        adapter = new RecommendedMatchAdapter(context,recommendedMatches);

        rv1.setAdapter(adapter);


        rv2 = view.findViewById(R.id.vertical_list);
        LinearLayoutManager layoutManager2= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(layoutManager2);
        rv2.setItemAnimator(new DefaultItemAnimator());

        nearestMatches = context.getNearestMatches();

        adapterNearest = new NearestMatchesAdapter(context,nearestMatches);

        rv2.setAdapter(adapterNearest);

        return view;
    }
}
