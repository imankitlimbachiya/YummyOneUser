package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.yummyone.Adapter.FeaturedRestaurantsAdapter;
import com.app.yummyone.R;

import java.util.ArrayList;

public class HomeMadeFoodActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rv_fetured_store;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_made_food);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");


        rv_fetured_store=findViewById(R.id.rv_fetured_store);

        img_back=findViewById(R.id.img_back);

        img_back.setOnClickListener(this);

        FeaturedRestaurantsAdapter frAdapter = new FeaturedRestaurantsAdapter(animalNames);
        RecyclerView.LayoutManager frLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        rv_fetured_store.setLayoutManager(frLayoutManager);
        rv_fetured_store.setAdapter(frAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
        }
    }
}