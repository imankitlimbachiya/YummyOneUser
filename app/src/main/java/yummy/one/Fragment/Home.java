package yummy.one.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Activity.RestaurantActivity;
import yummy.one.Adapter.CategoryAdapter;
import yummy.one.Adapter.FeatureRestaurantAdapter;
import yummy.one.Adapter.FeaturedRestaurantAdapter;
import yummy.one.Adapter.FeaturedVlogAdapter;
import yummy.one.Adapter.OfferAdapter;
import yummy.one.Adapter.TopRestaurantAdapter;
import yummy.one.Models.CategoryModel;
import yummy.one.Models.FeaturedRestaurantModel;
import yummy.one.Models.FeaturedVlogModel;
import yummy.one.Models.OfferModel;
import yummy.one.Models.TopRestaurantModel;
import yummy.one.R;

public class Home extends Fragment implements View.OnClickListener {

    public Home() {
        // Required empty public constructor
    }

    Context mContext;
    ProgressBar progressBar;
    RecyclerView CategoryView, OfferView, TopRestaurantView, FeatureVlogView, FeaturedRestaurantView, FeaturedVlogView, FeatureRestaurantView;
    ArrayList<CategoryModel> categoryList = new ArrayList<>();
    ArrayList<OfferModel> offerList = new ArrayList<>();
    ArrayList<TopRestaurantModel> topRestaurantList = new ArrayList<>();
    ArrayList<FeaturedVlogModel> featureVlogList = new ArrayList<>();
    ArrayList<FeaturedRestaurantModel> featuredRestaurantList = new ArrayList<>();
    ArrayList<FeaturedRestaurantModel> featureRestaurantList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        Log.e("Fragment", "Home");

        mContext = getActivity();

        ViewInitialization(view);

        ViewOnClick();

        AddCategory();

        AddOffer();

        AddTopRestaurant();

        AddFeaturedVlog();

        AddFeaturedRestaurant();

        AddFeatureRestaurant();

        return view;
    }

    public void ViewInitialization(View view) {
        progressBar = view.findViewById(R.id.progressBar);

        CategoryView = view.findViewById(R.id.CategoryView);
        OfferView = view.findViewById(R.id.OfferView);
        TopRestaurantView = view.findViewById(R.id.TopRestaurantView);
        FeatureVlogView = view.findViewById(R.id.FeatureVlogView);
        FeaturedRestaurantView = view.findViewById(R.id.FeaturedRestaurantView);
        FeaturedVlogView = view.findViewById(R.id.FeaturedVlogView);
        FeatureRestaurantView = view.findViewById(R.id.FeatureRestaurantView);
    }

    public void ViewOnClick() {
        // btnApply.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /*case R.id.imgSearch:
                Intent SearchAroundYourLocation = new Intent(mContext, SearchAroundYourLocationActivity.class);
                startActivity(SearchAroundYourLocation);
                break;*/
        }
    }

    public void AddCategory() {
        categoryList.clear();

        CategoryModel categoryModel;

        categoryModel = new CategoryModel("Restaurants", R.drawable.restaurant);
        categoryList.add(categoryModel);

        categoryModel = new CategoryModel("Homemade", R.drawable.homemade);
        categoryList.add(categoryModel);

        categoryModel = new CategoryModel("FastFood", R.drawable.fast_food);
        categoryList.add(categoryModel);

        categoryModel = new CategoryModel("Grocery", R.drawable.grocery);
        categoryList.add(categoryModel);

        if (categoryList.size() > 0) {
            CategoryAdapter categoryAdapter = new CategoryAdapter(mContext, categoryList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            CategoryView.setLayoutManager(mLayoutManager);
            CategoryView.setItemAnimator(new DefaultItemAnimator());
            CategoryView.setAdapter(categoryAdapter);
            categoryAdapter.notifyDataSetChanged();
        }
    }

    public void AddOffer() {
        offerList.clear();

        OfferModel offerModel;

        offerModel = new OfferModel("30% + 20% OFF", R.drawable.offer_one);
        offerList.add(offerModel);

        offerModel = new OfferModel("50% OFF", R.drawable.offer_two);
        offerList.add(offerModel);

        offerModel = new OfferModel("30% + 20% OFF", R.drawable.offer_one);
        offerList.add(offerModel);

        offerModel = new OfferModel("50% OFF", R.drawable.offer_two);
        offerList.add(offerModel);

        if (offerList.size() > 0) {
            OfferAdapter offerAdapter = new OfferAdapter(mContext, offerList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            OfferView.setLayoutManager(mLayoutManager);
            OfferView.setItemAnimator(new DefaultItemAnimator());
            OfferView.setAdapter(offerAdapter);
            offerAdapter.notifyDataSetChanged();
        }
    }

    public void AddTopRestaurant() {
        topRestaurantList.clear();

        TopRestaurantModel topRestaurantModel;

        topRestaurantModel = new TopRestaurantModel("Awesome food", R.drawable.top_restaurant_one);
        topRestaurantList.add(topRestaurantModel);

        topRestaurantModel = new TopRestaurantModel("Exotica yummy", R.drawable.top_restaurant_two);
        topRestaurantList.add(topRestaurantModel);

        topRestaurantModel = new TopRestaurantModel("Awesome food", R.drawable.top_restaurant_one);
        topRestaurantList.add(topRestaurantModel);

        topRestaurantModel = new TopRestaurantModel("Exotica yummy", R.drawable.top_restaurant_two);
        topRestaurantList.add(topRestaurantModel);

        if (topRestaurantList.size() > 0) {
            TopRestaurantAdapter topRestaurantAdapter = new TopRestaurantAdapter(mContext, topRestaurantList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            TopRestaurantView.setLayoutManager(mLayoutManager);
            TopRestaurantView.setItemAnimator(new DefaultItemAnimator());
            TopRestaurantView.setAdapter(topRestaurantAdapter);
            topRestaurantAdapter.notifyDataSetChanged();
        }
    }

    public void AddFeaturedVlog() {
        featureVlogList.clear();

        FeaturedVlogModel featuredVlogModel;

        featuredVlogModel = new FeaturedVlogModel(R.drawable.featured_vlog_one);
        featureVlogList.add(featuredVlogModel);

        featuredVlogModel = new FeaturedVlogModel(R.drawable.featured_vlog_two);
        featureVlogList.add(featuredVlogModel);

        featuredVlogModel = new FeaturedVlogModel(R.drawable.featured_vlog_one);
        featureVlogList.add(featuredVlogModel);

        featuredVlogModel = new FeaturedVlogModel(R.drawable.featured_vlog_two);
        featureVlogList.add(featuredVlogModel);

        if (featureVlogList.size() > 0) {
            FeaturedVlogAdapter featuredVlogAdapter = new FeaturedVlogAdapter(mContext, featureVlogList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            FeatureVlogView.setLayoutManager(mLayoutManager);
            FeatureVlogView.setItemAnimator(new DefaultItemAnimator());
            FeatureVlogView.setAdapter(featuredVlogAdapter);
            featuredVlogAdapter.notifyDataSetChanged();


            FeaturedVlogAdapter vlogAdapter = new FeaturedVlogAdapter(mContext, featureVlogList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            FeaturedVlogView.setLayoutManager(layoutManager);
            FeaturedVlogView.setItemAnimator(new DefaultItemAnimator());
            FeaturedVlogView.setAdapter(vlogAdapter);
            vlogAdapter.notifyDataSetChanged();
        }
    }

    public void AddFeaturedRestaurant() {
        featuredRestaurantList.clear();

        FeaturedRestaurantModel featuredRestaurantModel;

        featuredRestaurantModel = new FeaturedRestaurantModel(R.drawable.featured_restaurant_one);
        featuredRestaurantList.add(featuredRestaurantModel);

        featuredRestaurantModel = new FeaturedRestaurantModel(R.drawable.featured_restaurant_two);
        featuredRestaurantList.add(featuredRestaurantModel);

        featuredRestaurantModel = new FeaturedRestaurantModel(R.drawable.featured_restaurant_three);
        featuredRestaurantList.add(featuredRestaurantModel);

        if (featuredRestaurantList.size() > 0) {
            FeaturedRestaurantAdapter featuredRestaurantAdapter = new FeaturedRestaurantAdapter(mContext, featuredRestaurantList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
            FeaturedRestaurantView.setLayoutManager(mLayoutManager);
            FeaturedRestaurantView.setItemAnimator(new DefaultItemAnimator());
            FeaturedRestaurantView.setAdapter(featuredRestaurantAdapter);
            featuredRestaurantAdapter.notifyDataSetChanged();
        }
    }

    public void AddFeatureRestaurant() {
        featureRestaurantList.clear();

        FeaturedRestaurantModel featuredRestaurantModel;

        featuredRestaurantModel = new FeaturedRestaurantModel(R.drawable.feature_restaurant_one, "Awesome Restaurants");
        featureRestaurantList.add(featuredRestaurantModel);

        featuredRestaurantModel = new FeaturedRestaurantModel(R.drawable.feature_restaurant_two, "Yummy Food");
        featureRestaurantList.add(featuredRestaurantModel);

        featuredRestaurantModel = new FeaturedRestaurantModel(R.drawable.feature_restaurant_three, "Delicious Food");
        featureRestaurantList.add(featuredRestaurantModel);

        if (featureRestaurantList.size() > 0) {
            FeatureRestaurantAdapter featureRestaurantAdapter = new FeatureRestaurantAdapter(mContext, featureRestaurantList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
            FeatureRestaurantView.setLayoutManager(mLayoutManager);
            FeatureRestaurantView.setItemAnimator(new DefaultItemAnimator());
            FeatureRestaurantView.setAdapter(featureRestaurantAdapter);
            featureRestaurantAdapter.notifyDataSetChanged();
        }
    }
}