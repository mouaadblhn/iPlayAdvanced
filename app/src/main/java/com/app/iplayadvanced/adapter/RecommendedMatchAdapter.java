package com.app.iplayadvanced.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.iplayadvanced.R;
import com.app.iplayadvanced.model.Match;

import java.util.ArrayList;

public class RecommendedMatchAdapter extends RecyclerView.Adapter<RecommendedMatchAdapter.ViewHolder> {

    Context context;
    ArrayList<Match>recommendedMatches;

    public RecommendedMatchAdapter(Context context, ArrayList<Match> obj) {
        this.context = context;
        this.recommendedMatches = obj;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardImg;
        private TextView matchName;
        private TextView matchLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardImg = itemView.findViewById(R.id.card_img);
            this.matchName = itemView.findViewById(R.id.match_name);
            this.matchLocation = itemView.findViewById(R.id.match_location);
        }
    }

    @NonNull
    @Override
    public RecommendedMatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_matches_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedMatchAdapter.ViewHolder holder, int position) {
        holder.cardImg.setImageResource(recommendedMatches.get(position).getImg());
        holder.matchName.setText(recommendedMatches.get(position).getName());
        holder.matchLocation.setText(recommendedMatches.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return recommendedMatches.size();
    }

}
