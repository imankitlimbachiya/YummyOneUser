package yummy.one.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import yummy.one.Adapter.CategoryAdapter;
import yummy.one.Models.CategoryModel;
import yummy.one.Models.ItemModel;
import yummy.one.R;

public class RestaurantActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    TextView txtViewBag;
    RecyclerView ItemCategoryView;
    ArrayList<CategoryModel> itemCategoryList = new ArrayList<>();
    ArrayList<ItemModel> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Log.e("Activity", "RestaurantActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();
    }

    public void ViewInitialization() {
        txtViewBag = findViewById(R.id.txtViewBag);

        ItemCategoryView = findViewById(R.id.ItemCategoryView);

        AddItemCategory();
    }

    public void ViewOnClick() {
        txtViewBag.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtViewBag:
                ShowBottomSheetDialog();
                break;
        }
    }

    public void ShowBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.add_cart_dialog, null);
        final BottomSheetDialog dialog = new BottomSheetDialog(mContext);
        dialog.setContentView(view);
        dialog.findViewById(R.id.imgMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog.cancel();
            }
        });
        dialog.findViewById(R.id.imgPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog.cancel();
            }
        });
        dialog.findViewById(R.id.txtAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog.cancel();
            }
        });
        dialog.show();
    }

    public void AddItemCategory() {
        itemCategoryList.clear();

        CategoryModel categoryModel;

        categoryModel = new CategoryModel("Popular", "3");
        itemCategoryList.add(categoryModel);

        categoryModel = new CategoryModel("Starters", "3");
        itemCategoryList.add(categoryModel);

        categoryModel = new CategoryModel("Main Course", "6");
        itemCategoryList.add(categoryModel);

        categoryModel = new CategoryModel("Chef’s Special", "4");
        itemCategoryList.add(categoryModel);

        if (itemCategoryList.size() > 0) {
            ItemCategoryAdapter itemCategoryAdapter = new ItemCategoryAdapter(mContext, itemCategoryList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
            ItemCategoryView.setLayoutManager(mLayoutManager);
            ItemCategoryView.setItemAnimator(new DefaultItemAnimator());
            ItemCategoryView.setAdapter(itemCategoryAdapter);
            itemCategoryAdapter.notifyDataSetChanged();
        }
    }

    public class ItemCategoryAdapter extends RecyclerView.Adapter<ItemCategoryAdapter.MyViewHolder> {

        Context mContext;
        ArrayList<CategoryModel> arrayList;
        int pos = -1;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            RelativeLayout CategoryLayout;
            TextView txtItemCategory, txtItemCount;
            ImageView imgArrow;
            RecyclerView ItemView;

            MyViewHolder(View view) {
                super(view);

                CategoryLayout = view.findViewById(R.id.CategoryLayout);

                txtItemCategory = view.findViewById(R.id.txtItemCategory);
                txtItemCount = view.findViewById(R.id.txtItemCount);

                imgArrow = view.findViewById(R.id.imgArrow);

                ItemView = view.findViewById(R.id.ItemView);
            }
        }

        public ItemCategoryAdapter(Context mContext, ArrayList<CategoryModel> arrayList) {
            this.mContext = mContext;
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_adapter, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            CategoryModel categoryModel = arrayList.get(position);

            holder.txtItemCategory.setText(categoryModel.getCategoryTitle());
            holder.txtItemCount.setText(categoryModel.getCategoryItemCount());

            if (pos == position) {
                holder.CategoryLayout.setBackgroundResource(R.drawable.bg_corner_top_15dp);
                holder.imgArrow.setImageResource(R.drawable.top_arrow_grey);
                holder.ItemView.setVisibility(View.VISIBLE);

                itemList.clear();

                ItemModel itemModel;

                itemModel = new ItemModel("Spaghetti Bolognaise", "$ 15.00", R.drawable.item_one);
                itemList.add(itemModel);

                itemModel = new ItemModel("Club Sandwich", "$ 17.00", R.drawable.item_two);
                itemList.add(itemModel);

                itemModel = new ItemModel("Spaghetti", "$ 12.00", R.drawable.item_three);
                itemList.add(itemModel);

                ItemAdapter itemAdapter = new ItemAdapter(mContext, itemList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
                holder.ItemView.setLayoutManager(mLayoutManager);
                holder.ItemView.setItemAnimator(new DefaultItemAnimator());
                holder.ItemView.setAdapter(itemAdapter);
                itemAdapter.notifyDataSetChanged();
            } else {
                holder.CategoryLayout.setBackgroundResource(R.color.very_light_grey);
                holder.imgArrow.setImageResource(R.drawable.bottom_arrow_grey);
                holder.ItemView.setVisibility(View.GONE);
            }

            holder.CategoryLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == pos) {
                        pos = -1;
                    } else {
                        pos = position;
                    }
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    public static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

        Context mContext;
        ArrayList<ItemModel> arrayList;

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            TextView txtItemName, txtItemPrice;
            ImageView imgItem;

            MyViewHolder(View view) {
                super(view);

                txtItemName = view.findViewById(R.id.txtItemName);
                txtItemPrice = view.findViewById(R.id.txtItemPrice);

                imgItem = view.findViewById(R.id.imgItem);
            }
        }

        public ItemAdapter(Context mContext, ArrayList<ItemModel> arrayList) {
            this.mContext = mContext;
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final ItemModel itemModel = arrayList.get(position);

            holder.txtItemName.setText(itemModel.getItemTitle());
            holder.txtItemPrice.setText(itemModel.getItemPrice());
            holder.imgItem.setImageResource(itemModel.getItemImage());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }
}