package yummy.one.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import yummy.one.R;

public class ChooseLocationActivity extends AppCompatActivity implements View.OnClickListener {

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

        txtSelectManually = findViewById(R.id.txtSelectManually);
        txtSelectManually.setPaintFlags(txtSelectManually.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    public void ViewOnClick() {
        UseCurrentLocationLayout.setOnClickListener(this);
        txtSelectManually.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.UseCurrentLocationLayout:

                break;
            case R.id.txtSelectManually:
                Intent SearchAddress = new Intent(mContext, SearchAddressActivity.class);
                startActivity(SearchAddress);
                break;
        }
    }
}