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

import yummy.one.Models.CategoryModel;
import yummy.one.R;

public class SearchCategoryAdapter extends RecyclerView.Adapter<SearchCategoryAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<CategoryModel> arrayList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCategory;
        TextView txtCategory;

        MyViewHolder(View view) {
            super(view);

            imgCategory = view.findViewById(R.id.imgCategory);

            txtCategory = view.findViewById(R.id.txtCategory);
        }
    }

    public SearchCategoryAdapter(Context mContext, ArrayList<CategoryModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_category_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CategoryModel categoryModel = arrayList.get(position);

        holder.imgCategory.setImageResource(categoryModel.getCategoryImage());

        holder.txtCategory.setText(categoryModel.getCategoryTitle());

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