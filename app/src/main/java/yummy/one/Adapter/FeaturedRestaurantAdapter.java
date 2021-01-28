package yummy.one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Models.FeaturedRestaurantModel;
import yummy.one.R;

public class FeaturedRestaurantAdapter extends RecyclerView.Adapter<FeaturedRestaurantAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<FeaturedRestaurantModel> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFeaturedRestaurant;

        MyViewHolder(View view) {
            super(view);

            imgFeaturedRestaurant = view.findViewById(R.id.imgFeaturedRestaurant);
        }
    }

    public FeaturedRestaurantAdapter(Context mContext, ArrayList<FeaturedRestaurantModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_restaurant_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeaturedRestaurantModel featuredRestaurantModel = arrayList.get(position);

        holder.imgFeaturedRestaurant.setImageResource(featuredRestaurantModel.getFeaturedRestaurantImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}