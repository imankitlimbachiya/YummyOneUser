package yummy.one.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Activity.RestaurantActivity;
import yummy.one.Models.TopRestaurantModel;
import yummy.one.R;

public class TopRestaurantAdapter extends RecyclerView.Adapter<TopRestaurantAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<TopRestaurantModel> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgTopRestaurant;
        TextView txtTopRestaurant;

        MyViewHolder(View view) {
            super(view);

            imgTopRestaurant = view.findViewById(R.id.imgTopRestaurant);

            txtTopRestaurant = view.findViewById(R.id.txtTopRestaurant);
        }
    }

    public TopRestaurantAdapter(Context mContext, ArrayList<TopRestaurantModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_restaurant_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TopRestaurantModel topRestaurantModel = arrayList.get(position);

        holder.imgTopRestaurant.setImageResource(topRestaurantModel.getTopRestaurantImage());

        holder.txtTopRestaurant.setText(topRestaurantModel.getTopRestaurantTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Restaurant = new Intent(mContext, RestaurantActivity.class);
                mContext.startActivity(Restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}