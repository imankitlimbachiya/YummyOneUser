package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.Adapter.ChefsAdapter;
import com.app.yummyone.Adapter.DishesAdapter;
import com.app.yummyone.Adapter.RestaurantsAdapter;
import com.app.yummyone.Adapter.TopRestaurantAdapter;
import com.app.yummyone.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rv_dishes,rv_restaurant,rv_chef;
    ImageView img_back;
    TextView  tv_all,tv_restaurant,tv_homemade,tv_fastfood,txt_dishes,txt_restaurant,txt_chef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        rv_dishes=findViewById(R.id.rv_dishes);
        rv_restaurant=findViewById(R.id.rv_restaurant);
        rv_chef=findViewById(R.id.rv_chef);

        img_back=findViewById(R.id.img_back);

        txt_dishes=findViewById(R.id.txt_dishes);
        txt_restaurant=findViewById(R.id.txt_restaurant);
        txt_chef=findViewById(R.id.txt_chef);

        tv_all=findViewById(R.id.tv_all);
        tv_restaurant=findViewById(R.id.tv_restaurant);
        tv_homemade=findViewById(R.id.tv_homemade);
        tv_fastfood=findViewById(R.id.tv_fastfood);

        img_back.setOnClickListener(this);
        tv_all.setOnClickListener(this);
        tv_restaurant.setOnClickListener(this);
        tv_homemade.setOnClickListener(this);
        tv_fastfood.setOnClickListener(this);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        DishesAdapter dishesAdapter = new DishesAdapter(animalNames);
        RecyclerView.LayoutManager dishLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        rv_dishes.setLayoutManager(dishLayoutManager);
        rv_dishes.setAdapter(dishesAdapter);

        RestaurantsAdapter restaurantsAdapter = new RestaurantsAdapter(animalNames);
        RecyclerView.LayoutManager restaurantLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        rv_restaurant.setLayoutManager(restaurantLayoutManager);
        rv_restaurant.setAdapter(restaurantsAdapter);

        ChefsAdapter chefsAdapter = new ChefsAdapter(animalNames);
        RecyclerView.LayoutManager chefsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        rv_chef.setLayoutManager(chefsLayoutManager);
        rv_chef.setAdapter(chefsAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_all:
                tv_all.getBackground().setColorFilter(getResources().getColor(R.color.Red), PorterDuff.Mode.SRC_ATOP);
                tv_restaurant.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                tv_homemade.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                tv_fastfood.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                tv_all.setTextColor(getResources().getColor(R.color.white));
                tv_restaurant.setTextColor(getResources().getColor(R.color.black));
                tv_homemade.setTextColor(getResources().getColor(R.color.black));
                tv_fastfood.setTextColor(getResources().getColor(R.color.black));

                txt_restaurant.setVisibility(View.VISIBLE);
                txt_chef.setVisibility(View.VISIBLE);
                txt_dishes.setVisibility(View.VISIBLE);

                rv_restaurant.setVisibility(View.VISIBLE);
                rv_chef.setVisibility(View.VISIBLE);
                rv_dishes.setVisibility(View.VISIBLE);

                break;
            case R.id.tv_restaurant:
                tv_all.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey), PorterDuff.Mode.SRC_ATOP);
                tv_restaurant.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);
                tv_homemade.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                tv_fastfood.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                tv_all.setTextColor(getResources().getColor(R.color.black));
                tv_restaurant.setTextColor(getResources().getColor(R.color.white));
                tv_homemade.setTextColor(getResources().getColor(R.color.black));
                tv_fastfood.setTextColor(getResources().getColor(R.color.black));

                txt_restaurant.setVisibility(View.VISIBLE);
                txt_chef.setVisibility(View.GONE);
                txt_dishes.setVisibility(View.VISIBLE);

                rv_restaurant.setVisibility(View.VISIBLE);
                rv_chef.setVisibility(View.GONE);
                rv_dishes.setVisibility(View.VISIBLE);

                break;
            case R.id.tv_homemade:
                tv_all.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey), PorterDuff.Mode.SRC_ATOP);
                tv_restaurant.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                tv_homemade.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);
                tv_fastfood.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                tv_all.setTextColor(getResources().getColor(R.color.black));
                tv_restaurant.setTextColor(getResources().getColor(R.color.black));
                tv_homemade.setTextColor(getResources().getColor(R.color.white));
                tv_fastfood.setTextColor(getResources().getColor(R.color.black));

                txt_restaurant.setVisibility(View.GONE);
                txt_chef.setVisibility(View.VISIBLE);
                txt_dishes.setVisibility(View.VISIBLE);

                rv_restaurant.setVisibility(View.GONE);
                rv_chef.setVisibility(View.VISIBLE);
                rv_dishes.setVisibility(View.VISIBLE);


                break;
            case R.id.tv_fastfood:
                tv_all.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey), PorterDuff.Mode.SRC_ATOP);
                tv_restaurant.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                tv_homemade.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                tv_fastfood.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);

                tv_all.setTextColor(getResources().getColor(R.color.black));
                tv_restaurant.setTextColor(getResources().getColor(R.color.black));
                tv_homemade.setTextColor(getResources().getColor(R.color.black));
                tv_fastfood.setTextColor(getResources().getColor(R.color.white));

                txt_restaurant.setVisibility(View.VISIBLE);
                txt_chef.setVisibility(View.VISIBLE);
                txt_dishes.setVisibility(View.VISIBLE);

                rv_restaurant.setVisibility(View.VISIBLE);
                rv_chef.setVisibility(View.VISIBLE);
                rv_dishes.setVisibility(View.VISIBLE);

                break;

        }
    }
}