package yummy.one.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Activity.RestaurantActivity;
import yummy.one.Models.CategoryModel;
import yummy.one.Models.ItemModel;
import yummy.one.R;

public class HorizontalCategoryAdapter extends RecyclerView.Adapter<HorizontalCategoryAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<CategoryModel> arrayList;
    int pos = 0;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtCategory;

        MyViewHolder(View view) {
            super(view);

            txtCategory = view.findViewById(R.id.txtCategory);
        }
    }

    public HorizontalCategoryAdapter(Context mContext, ArrayList<CategoryModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_category_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CategoryModel categoryModel = arrayList.get(position);

        holder.txtCategory.setText(categoryModel.getCategoryTitle());

        if (pos == position) {
            holder.txtCategory.getBackground().setColorFilter(Color.parseColor("#FF5656"), PorterDuff.Mode.SRC_ATOP);
            holder.txtCategory.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.txtCategory.getBackground().setColorFilter(Color.parseColor("#E5E5E5"), PorterDuff.Mode.SRC_ATOP);
            holder.txtCategory.setTextColor(Color.parseColor("#707070"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (position == pos) {
                    pos = -1;
                } else {
                    pos = position;
                }*/
                pos = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}