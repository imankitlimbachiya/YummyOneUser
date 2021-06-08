package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.yummyone.R;

public class SelectCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_back,img_restorant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        img_back=findViewById(R.id.img_back);
        img_restorant=findViewById(R.id.img_restorant);
        img_back.setOnClickListener(this);
        img_restorant.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_restorant:
                Intent isearch=new Intent(this,HomeMadeFoodActivity.class);
                startActivity(isearch);
                break;
        }
    }
}