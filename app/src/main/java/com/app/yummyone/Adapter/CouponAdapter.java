package com.app.yummyone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.yummyone.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.ViewHolder> {
    private List<String> restaurantlist;

    public CouponAdapter(List<String> restaurantlist) {
        this.restaurantlist = restaurantlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coupon, parent, false);
        return new ViewHolder(itemView);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = restaurantlist.get(position);
       // holder.myTextView.setText(item);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return restaurantlist.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            //myTextView = itemView.findViewById(R.id.tvAnimalName);

        }

    }



}

