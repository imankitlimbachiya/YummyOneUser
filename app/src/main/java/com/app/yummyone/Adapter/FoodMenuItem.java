package com.app.yummyone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.yummyone.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class FoodMenuItem extends RecyclerView.Adapter<FoodMenuItem.ViewHolder> {
    private List<String> restaurantlist;

    public FoodMenuItem(List<String> restaurantlist) {
        this.restaurantlist = restaurantlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_menu_item, parent, false);
        return new ViewHolder(itemView);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = restaurantlist.get(position);
        try {
            if (position==restaurantlist.size()-1){
                holder.view_item.setVisibility(View.GONE);
            }else {
                holder.view_item.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){

        }

       // holder.txt_order_placed.setVisibility(View.GONE);
        //holder.rl_rating.setVisibility(View.VISIBLE);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return restaurantlist.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_item_name,item_price;
        ImageView img_item_image;
        View view_item;

        ViewHolder(View itemView) {
            super(itemView);
            txt_item_name = itemView.findViewById(R.id.txt_item_name);
            item_price = itemView.findViewById(R.id.item_price);
            view_item = itemView.findViewById(R.id.view_item);
            img_item_image = itemView.findViewById(R.id.img_item_image);

        }

    }



}

