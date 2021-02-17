package com.app.iplayadvanced;

import android.app.Application;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.app.iplayadvanced.model.Match;

import java.util.ArrayList;

public class BaseApplication extends Application {
    private ArrayList<Match> recommendedMatches;
    private ArrayList<Match> nearestMatches;

    public BaseApplication () {
        this.recommendedMatches = new ArrayList<>();
        this.nearestMatches = new ArrayList<>();
    }

    public ArrayList<Match> getRecommendedMatches() {
        return this.recommendedMatches;
    }
    public ArrayList<Match> getNearestMatches() {
        return this.nearestMatches;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.recommendedMatches = initDataRecMatches();
        this.nearestMatches = initDataNearestMatches();
    }

    public ArrayList<Match> initDataRecMatches() {
        this.recommendedMatches.clear();
        Resources res = getResources();
        final String[] match_names = getResources().getStringArray(R.array.match_names);
        final String[] match_location = getResources().getStringArray(R.array.match_location);
        TypedArray match_imgs = getResources().obtainTypedArray(R.array.match_imgs);

        for(int i=0; i<match_names.length; i++) {
            recommendedMatches.add(new Match(match_names[i], match_location[i], match_imgs.getResourceId(i,0)));
        }
        return recommendedMatches;
    }

    public ArrayList<Match> initDataNearestMatches() {
        this.nearestMatches.clear();
        Resources res = getResources();
        final String[] match_names = getResources().getStringArray(R.array.match_names);
        final String[] match_location = getResources().getStringArray(R.array.match_location);
        TypedArray match_imgs = getResources().obtainTypedArray(R.array.match_imgs);
        final String[] match_distance = getResources().getStringArray(R.array.match_distance);
        for(int i=0; i<match_names.length; i++) {
            nearestMatches.add(new Match(match_names[i], match_location[i]+", "+match_distance[i], match_imgs.getResourceId(i,0)));
        }
        return nearestMatches;
    }

}
