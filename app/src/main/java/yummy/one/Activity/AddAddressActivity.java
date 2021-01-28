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

import androidx.appcompat.app.AppCompatActivity;

import yummy.one.R;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    ImageView imgBack;
    TextView txtSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        Log.e("Activity", "AddAddressActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        GetIntentData();
    }

    public void ViewInitialization() {
        imgBack = findViewById(R.id.imgBack);

        txtSave = findViewById(R.id.txtSave);
    }

    public void ViewOnClick() {
        imgBack.setOnClickListener(this);
        txtSave.setOnClickListener(this);
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
            case R.id.txtSave:
                Intent Home = new Intent(mContext, HomeActivity.class);
                startActivity(Home);
                finish();
                break;
        }
    }
}