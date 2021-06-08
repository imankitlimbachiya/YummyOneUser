package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.app.yummyone.R;

public class VloginsiteAndEarningActivity extends AppCompatActivity {
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vloginsite_and_earning);
        Log.e("Activity","VloginsiteAndEarningActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

    }

    public void ViewInitialization() {
        //viewPager = findViewById(R.id.viewPager_order);

    }

    public void ViewOnClick() {

    }
}