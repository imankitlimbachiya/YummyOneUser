package yummy.one.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import yummy.one.R;

public class SplashActivity extends AppCompatActivity {

    Context mContext;

    int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.e("Activity", "SplashActivity");

        mContext = this;

        getSupportActionBar().hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onResume() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, IntroActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
        super.onResume();
    }
}