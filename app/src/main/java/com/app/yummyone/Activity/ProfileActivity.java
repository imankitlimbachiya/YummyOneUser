package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.Adapter.MyOrderAdapter;
import com.app.yummyone.Adapter.PublicProfileAdapter;
import com.app.yummyone.R;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener  {
    RecyclerView rv_profileimage;
    ImageView img_back;
    TextView txt_post,txt_my_orders;
    View view_post, view_myorders;
    ArrayList<String> animalNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");

        rv_profileimage=findViewById(R.id.rv_profileimage);
        img_back=findViewById(R.id.img_back);
        txt_post=findViewById(R.id.txt_post);
        txt_my_orders=findViewById(R.id.txt_my_orders);
        view_post=findViewById(R.id.view_post);
        view_myorders=findViewById(R.id.view_myorders);

        rv_profileimage.setLayoutManager(new GridLayoutManager(this, 3));
        PublicProfileAdapter publicProfileAdapter = new PublicProfileAdapter(animalNames);
        rv_profileimage.setAdapter(publicProfileAdapter);

        img_back.setOnClickListener(this);
        txt_post.setOnClickListener(this);
        txt_my_orders.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_post:
                txt_post.setTextColor(getResources().getColor(R.color.Red));
                txt_my_orders.setTextColor(getResources().getColor(R.color.Grey));

                view_post.setBackgroundColor(getResources().getColor(R.color.Red));
                view_myorders.setBackgroundColor(getResources().getColor(R.color.white));

                rv_profileimage.setLayoutManager(new GridLayoutManager(this, 3));
                PublicProfileAdapter publicProfileAdapter = new PublicProfileAdapter(animalNames);
                rv_profileimage.setAdapter(publicProfileAdapter);

                break;
            case R.id.txt_my_orders:
                txt_post.setTextColor(getResources().getColor(R.color.Grey));
                txt_my_orders.setTextColor(getResources().getColor(R.color.Red));

                view_post.setBackgroundColor(getResources().getColor(R.color.white));
                view_myorders.setBackgroundColor(getResources().getColor(R.color.Red));

                rv_profileimage.setLayoutManager(new LinearLayoutManager(this));
                MyOrderAdapter myOrderAdapter = new MyOrderAdapter(animalNames);
                rv_profileimage.setAdapter(myOrderAdapter);

                break;
        }
    }
}