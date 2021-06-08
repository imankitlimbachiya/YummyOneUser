package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.Adapter.PublicProfileAdapter;
import com.app.yummyone.Adapter.TopRestaurantAdapter;
import com.app.yummyone.R;

import java.util.ArrayList;

public class PublicProfileActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rv_profileimage;
    ImageView img_back;
    TextView txt_follow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_profile);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        ArrayList<String> animalNames = new ArrayList<>();
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
        txt_follow=findViewById(R.id.txt_follow);

        rv_profileimage.setLayoutManager(new GridLayoutManager(this, 3));
        PublicProfileAdapter publicProfileAdapter = new PublicProfileAdapter(animalNames);
        rv_profileimage.setAdapter(publicProfileAdapter);

        img_back.setOnClickListener(this);
        txt_follow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_follow:
                Intent iblog=new Intent(getApplicationContext(),VloginsiteAndEarningActivity.class);
                startActivity(iblog);
                break;
        }
    }
}