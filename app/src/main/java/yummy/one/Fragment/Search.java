package yummy.one.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import yummy.one.Adapter.CategoryAdapter;
import yummy.one.Adapter.FeatureRestaurantAdapter;
import yummy.one.Adapter.FeaturedRestaurantAdapter;
import yummy.one.Adapter.FeaturedVlogAdapter;
import yummy.one.Adapter.HorizontalCategoryAdapter;
import yummy.one.Adapter.OfferAdapter;
import yummy.one.Adapter.SearchCategoryAdapter;
import yummy.one.Adapter.TopRestaurantAdapter;
import yummy.one.Models.CategoryModel;
import yummy.one.Models.FeaturedRestaurantModel;
import yummy.one.Models.FeaturedVlogModel;
import yummy.one.Models.OfferModel;
import yummy.one.Models.TopRestaurantModel;
import yummy.one.R;

public class Search extends Fragment implements View.OnClickListener {

    public Search() {
        // Required empty public constructor
    }

    Context mContext;
    ProgressBar progressBar;
    ImageView imgBack;
    EditText edtSearch;
    RecyclerView CategoryView, HorizontalCategoryView, DishesView;
    ArrayList<CategoryModel> categoryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search, container, false);

        Log.e("Fragment", "Home");

        mContext = getActivity();

        ViewInitialization(view);

        ViewOnClick();

        AddCategory();

        return view;
    }

    public void ViewInitialization(View view) {
        progressBar = view.findViewById(R.id.progressBar);

        imgBack = view.findViewById(R.id.imgBack);

        edtSearch = view.findViewById(R.id.edtSearch);

        CategoryView = view.findViewById(R.id.CategoryView);
        HorizontalCategoryView = view.findViewById(R.id.HorizontalCategoryView);
        DishesView = view.findViewById(R.id.DishesView);
    }

    public void ViewOnClick() {
        imgBack.setOnClickListener(this);

        /*edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/

        edtSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                // Log.e("onFocusChange ", "" + hasFocus);
                if (hasFocus) {
                    //got focus
                    CategoryView.setVisibility(View.GONE);
                    HorizontalCategoryView.setVisibility(View.VISIBLE);
                } else {
                    //lost focus
                    CategoryView.setVisibility(View.VISIBLE);
                    HorizontalCategoryView.setVisibility(View.GONE);
                }
            }
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);
                    CategoryView.setVisibility(View.VISIBLE);
                    HorizontalCategoryView.setVisibility(View.GONE);
                    return true;
                }
                return false;
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:

                break;
        }
    }

    public void AddCategory() {
        categoryList.clear();

        CategoryModel categoryModel;

        categoryModel = new CategoryModel("Restaurants", R.drawable.search_restaurant);
        categoryList.add(categoryModel);

        categoryModel = new CategoryModel("Homemade", R.drawable.search_homemade);
        categoryList.add(categoryModel);

        categoryModel = new CategoryModel("FastFood", R.drawable.search_fast_food);
        categoryList.add(categoryModel);

        categoryModel = new CategoryModel("Grocery", R.drawable.search_grocery_bg);
        categoryList.add(categoryModel);

        if (categoryList.size() > 0) {
            SearchCategoryAdapter searchCategoryAdapter = new SearchCategoryAdapter(mContext, categoryList);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2, RecyclerView.VERTICAL, false);
            CategoryView.setLayoutManager(mLayoutManager);
            CategoryView.setItemAnimator(new DefaultItemAnimator());
            CategoryView.setAdapter(searchCategoryAdapter);
            searchCategoryAdapter.notifyDataSetChanged();

            HorizontalCategoryAdapter horizontalCategoryAdapter = new HorizontalCategoryAdapter(mContext, categoryList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            HorizontalCategoryView.setLayoutManager(layoutManager);
            HorizontalCategoryView.setItemAnimator(new DefaultItemAnimator());
            HorizontalCategoryView.setAdapter(horizontalCategoryAdapter);
            horizontalCategoryAdapter.notifyDataSetChanged();
        }
    }
}