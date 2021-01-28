package yummy.one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Models.FeaturedRestaurantModel;
import yummy.one.R;

public class FeatureRestaurantAdapter extends RecyclerView.Adapter<FeatureRestaurantAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<FeaturedRestaurantModel> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFeatureRestaurant;
        TextView txtFeatureRestaurant;

        MyViewHolder(View view) {
            super(view);

            imgFeatureRestaurant = view.findViewById(R.id.imgFeatureRestaurant);

            txtFeatureRestaurant = view.findViewById(R.id.txtFeatureRestaurant);
        }
    }

    public FeatureRestaurantAdapter(Context mContext, ArrayList<FeaturedRestaurantModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_restaurant_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeaturedRestaurantModel featuredRestaurantModel = arrayList.get(position);

        holder.imgFeatureRestaurant.setImageResource(featuredRestaurantModel.getFeaturedRestaurantImage());
        holder.txtFeatureRestaurant.setText(featuredRestaurantModel.getFeatureRestaurantName());

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