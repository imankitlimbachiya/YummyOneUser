package yummy.one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Models.OfferModel;
import yummy.one.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<OfferModel> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgOffer;

        MyViewHolder(View view) {
            super(view);

            imgOffer = view.findViewById(R.id.imgOffer);
        }
    }

    public OfferAdapter(Context mContext, ArrayList<OfferModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OfferModel offerModel = arrayList.get(position);

        holder.imgOffer.setImageResource(offerModel.getOfferImage());

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