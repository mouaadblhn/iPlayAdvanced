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
import com.app.iplayadvanced.models.Match;

import java.util.ArrayList;

public class NearestMatchesAdapter extends RecyclerView.Adapter<NearestMatchesAdapter.ViewHolder> {
    Context context;
    ArrayList<Match> nearestMatches;

    public NearestMatchesAdapter(Context context, ArrayList<Match> obj) {
        this.context = context;
        this.nearestMatches = obj;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView cardImg;
        private TextView matchName;
        private TextView matchLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardImg = itemView.findViewById(R.id.nearest_img);
            this.matchName = itemView.findViewById(R.id.nearest_name);
            this.matchLocation = itemView.findViewById(R.id.nearest_location);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearest_matches_card,parent,false);
        return new NearestMatchesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardImg.setImageResource(nearestMatches.get(position).getImg());
        holder.matchName.setText(nearestMatches.get(position).getName());
        holder.matchLocation.setText(nearestMatches.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return nearestMatches.size();
    }

}
