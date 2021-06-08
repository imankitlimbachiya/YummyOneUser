package com.app.yummyone.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.yummyone.R;

public class ChooseLocationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    Context mContext;
    RelativeLayout UseCurrentLocationLayout;
    TextView txtSelectManually;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);

        Log.e("Activity", "ChooseLocationActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();
    }

    public void ViewInitialization() {
        UseCurrentLocationLayout = findViewById(R.id.UseCurrentLocationLayout);
        imgBack = findViewById(R.id.imgBack);

        txtSelectManually = findViewById(R.id.txtSelectManually);
        txtSelectManually.setPaintFlags(txtSelectManually.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    public void ViewOnClick() {
        UseCurrentLocationLayout.setOnClickListener(this);
        txtSelectManually.setOnClickListener(this);
        imgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.UseCurrentLocationLayout:
                Intent isearch=new Intent(mContext,SearchAddressActivity.class);
                startActivity(isearch);
                break;
            case R.id.txtSelectManually:

                break;
            case R.id.imgBack:
                finish();
                break;
        }
    }
}