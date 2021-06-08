package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.yummyone.Adapter.CouponAdapter;
import com.app.yummyone.Adapter.FeaturedRestaurantsAdapter;
import com.app.yummyone.Adapter.FeaturesVlogsAdapter;
import com.app.yummyone.Adapter.TopRestaurantAdapter;
import com.app.yummyone.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_home,img_search,img_profile,img_bag,img_vlog;
    TextView txt_delivery,txt_pickup,txt_dine;
    CircleImageView img_userimage;
    RecyclerView rvtorestaurant,rvfeaturedvlogs,rvcoupon,rvfeaturedrestaurants;
    LinearLayout ll_homemade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        inint();

    }

    private void inint() {
        img_home=findViewById(R.id.img_home);
        img_search=findViewById(R.id.img_search);
        img_profile=findViewById(R.id.img_profile);
        img_bag=findViewById(R.id.img_bag);
        img_vlog=findViewById(R.id.img_vlog);

        ll_homemade=findViewById(R.id.ll_homemade);

        txt_delivery=findViewById(R.id.txt_delivery);
        txt_pickup=findViewById(R.id.txt_pickup);
        txt_dine=findViewById(R.id.txt_dine);
        img_userimage=findViewById(R.id.img_userimage);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        rvtorestaurant=findViewById(R.id.rvtorestaurant);
        rvfeaturedvlogs=findViewById(R.id.rvfeaturedvlogs);
        rvcoupon=findViewById(R.id.rvcoupon);
        rvfeaturedrestaurants=findViewById(R.id.rvfeaturedrestaurants);


        TopRestaurantAdapter  topRestaurantAdapter = new TopRestaurantAdapter(animalNames);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true);
        rvtorestaurant.setLayoutManager(mLayoutManager);
        rvtorestaurant.setAdapter(topRestaurantAdapter);

        FeaturesVlogsAdapter featuredvlogsAdapter = new FeaturesVlogsAdapter(animalNames);
        RecyclerView.LayoutManager featuredvlogsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true);
        rvfeaturedvlogs.setLayoutManager(featuredvlogsLayoutManager);
        rvfeaturedvlogs.setAdapter(featuredvlogsAdapter);

        CouponAdapter couponAdapter = new CouponAdapter(animalNames);
        RecyclerView.LayoutManager couponLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true);
        rvcoupon.setLayoutManager(couponLayoutManager);
        rvcoupon.setAdapter(couponAdapter);

        FeaturedRestaurantsAdapter frAdapter = new FeaturedRestaurantsAdapter(animalNames);
        RecyclerView.LayoutManager frLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        rvfeaturedrestaurants.setLayoutManager(frLayoutManager);
        rvfeaturedrestaurants.setAdapter(frAdapter);

        img_home.setOnClickListener(this);
        img_search.setOnClickListener(this);
        txt_delivery.setOnClickListener(this);
        txt_pickup.setOnClickListener(this);
        txt_dine.setOnClickListener(this);
        img_userimage.setOnClickListener(this);
        img_profile.setOnClickListener(this);
        img_bag.setOnClickListener(this);
        img_vlog.setOnClickListener(this);
        ll_homemade.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_home:
                Intent ihome=new Intent(this,VendorActivity.class);
                startActivity(ihome);
                break;
            case R.id.ll_homemade:
                Intent iorder=new Intent(this,OrderProcessActivity.class);
                startActivity(iorder);
                break;
            case R.id.img_userimage:
                Intent ipublicprofile=new Intent(this,PublicProfileActivity.class);
                startActivity(ipublicprofile);
                break;
            case R.id.img_bag:
                Intent searchintent=new Intent(this,SearchActivity.class);
                startActivity(searchintent);
                break;
            case R.id.img_profile:
                Intent iprofile=new Intent(this,ProfileActivity.class);
                startActivity(iprofile);
                break;
            case R.id.img_search:
                Intent isearch=new Intent(this,SelectCategoryActivity.class);//UploadVlogActivity
                startActivity(isearch);
                break;
            case R.id.img_vlog:
                Intent ivlog=new Intent(this,UploadVlogActivity.class);
                startActivity(ivlog);
                break;
            case R.id.txt_delivery:
                txt_delivery.setBackgroundResource(R.drawable.bg_round);
                txt_pickup.setBackgroundResource(0);
                txt_dine.setBackgroundResource(0);

                txt_delivery.getBackground().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
               // txt_pickup.getBackground().setColorFilter(getResources().getColor(R.color.white),PorterDuff.Mode.SRC_ATOP);
               // txt_dine.getBackground().setColorFilter(getResources().getColor(R.color.white),PorterDuff.Mode.SRC_ATOP);

                txt_delivery.setTextColor(getResources().getColor(R.color.white));
                txt_pickup.setTextColor(getResources().getColor(R.color.black));
                txt_dine.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.txt_pickup:

                txt_delivery.setBackgroundResource(0);
                txt_pickup.setBackgroundResource(R.drawable.bg_round);
                txt_dine.setBackgroundResource(0);

               // txt_delivery.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                txt_pickup.getBackground().setColorFilter(getResources().getColor(R.color.black),PorterDuff.Mode.SRC_ATOP);
                //txt_dine.getBackground().setColorFilter(getResources().getColor(R.color.white),PorterDuff.Mode.SRC_ATOP);

                txt_delivery.setTextColor(getResources().getColor(R.color.black));
                txt_pickup.setTextColor(getResources().getColor(R.color.white));
                txt_dine.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.txt_dine:
                txt_delivery.setBackgroundResource(0);
                txt_pickup.setBackgroundResource(0);
                txt_dine.setBackgroundResource(R.drawable.bg_round);

               // txt_delivery.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
               // txt_pickup.getBackground().setColorFilter(getResources().getColor(R.color.white),PorterDuff.Mode.SRC_ATOP);
                txt_dine.getBackground().setColorFilter(getResources().getColor(R.color.black),PorterDuff.Mode.SRC_ATOP);

                txt_delivery.setTextColor(getResources().getColor(R.color.black));
                txt_pickup.setTextColor(getResources().getColor(R.color.black));
                txt_dine.setTextColor(getResources().getColor(R.color.white));

                break;
        }
    }
}