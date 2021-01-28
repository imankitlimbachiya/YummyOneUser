package yummy.one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Models.FeaturedVlogModel;
import yummy.one.R;

public class FeaturedVlogAdapter extends RecyclerView.Adapter<FeaturedVlogAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<FeaturedVlogModel> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFeaturedVlog;

        MyViewHolder(View view) {
            super(view);

            imgFeaturedVlog = view.findViewById(R.id.imgFeaturedVlog);
        }
    }

    public FeaturedVlogAdapter(Context mContext, ArrayList<FeaturedVlogModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_vlog_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeaturedVlogModel featuredVlogModel = arrayList.get(position);

        holder.imgFeaturedVlog.setImageResource(featuredVlogModel.getFeaturedVlogImage());

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