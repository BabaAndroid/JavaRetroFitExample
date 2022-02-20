package com.medgini.retrofitjavaex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.medgini.retrofitjavaex.R;
import com.medgini.retrofitjavaex.pojo.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    Context context;
    List<Hero> heroList;

    public HeroAdapter(Context context, List<Hero> heroList) {
        this.context = context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.heroview, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        holder.name.setText(heroList.get(position).getName());
        Glide.with(context).load(heroList.get(position).getImageurl()).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public static class HeroViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hero_img);
            name = itemView.findViewById(R.id.name);

        }
    }
}
