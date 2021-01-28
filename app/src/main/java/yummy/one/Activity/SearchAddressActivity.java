package yummy.one.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;
import yummy.one.R;

public class SearchAddressActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    ImageView imgBack, imgTurnOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);

        Log.e("Activity", "SearchAddressActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        GetIntentData();
    }

    public void ViewInitialization() {
        imgBack = findViewById(R.id.imgBack);
        imgTurnOn = findViewById(R.id.imgTurnOn);
    }

    public void ViewOnClick() {
        imgBack.setOnClickListener(this);
        imgTurnOn.setOnClickListener(this);
    }

    public void GetIntentData() {

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgTurnOn:
                Intent intent = new Intent(mContext, AddAddressActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}