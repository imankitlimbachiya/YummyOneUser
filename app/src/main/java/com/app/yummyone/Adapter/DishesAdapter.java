package com.app.yummyone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.yummyone.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {
    private List<String> restaurantlist;

    public DishesAdapter(List<String> restaurantlist) {
        this.restaurantlist = restaurantlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes, parent, false);
        return new ViewHolder(itemView);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = restaurantlist.get(position);
        holder.txt_order_placed.setVisibility(View.VISIBLE);
        holder.rl_rating.setVisibility(View.GONE);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return restaurantlist.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_order_placed;
        RelativeLayout rl_rating;

        ViewHolder(View itemView) {
            super(itemView);
            txt_order_placed = itemView.findViewById(R.id.txt_order_placed);
            rl_rating = itemView.findViewById(R.id.rl_rating);

        }

    }



}

