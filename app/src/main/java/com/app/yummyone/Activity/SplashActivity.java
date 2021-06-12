package com.app.yummyone.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.app.yummyone.R;

public class SplashActivity extends AppCompatActivity {

    Context mContext;
    int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mContext = this;

        getSupportActionBar().hide();
    }

    @Override
    protected void onResume() {
        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {
               // Intent intent = new Intent(mContext, MainActivity.class);
                Intent intent = new Intent(mContext, VendorActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
        super.onResume();
    }
}