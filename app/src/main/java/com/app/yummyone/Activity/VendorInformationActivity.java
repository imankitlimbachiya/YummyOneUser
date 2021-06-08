package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.NestedScrollView;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.yummyone.R;

public class VendorInformationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_rating,txt_information,txt_menu;
    LinearLayout ll_populer;
    NestedScrollView ns_menu,ns_information,ns_rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_information);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        txt_rating=findViewById(R.id.txt_rating);
        txt_information=findViewById(R.id.txt_information);
        txt_menu=findViewById(R.id.txt_menu);
        ll_populer=findViewById(R.id.ll_populer);
        ns_menu=findViewById(R.id.ns_menu);
        ns_information=findViewById(R.id.ns_information);
        ns_rating=findViewById(R.id.ns_rating);
        txt_rating.setOnClickListener(this);
        txt_information.setOnClickListener(this);
        txt_menu.setOnClickListener(this);
        ll_populer.setVisibility(View.VISIBLE);
        ns_menu.setVisibility(View.VISIBLE);
        ns_information.setVisibility(View.GONE);
        ns_rating.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_rating:
                txt_rating.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);
                txt_information.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                txt_menu.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                txt_rating.setTextColor(getResources().getColor(R.color.white));
                txt_information.setTextColor(getResources().getColor(R.color.black));
                txt_menu.setTextColor(getResources().getColor(R.color.black));

                ll_populer.setVisibility(View.GONE);
                ns_menu.setVisibility(View.GONE);
                ns_information.setVisibility(View.GONE);
                ns_rating.setVisibility(View.VISIBLE);
                break;
            case R.id.txt_information:
                txt_information.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);
                txt_rating.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                txt_menu.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                txt_information.setTextColor(getResources().getColor(R.color.white));
                txt_rating.setTextColor(getResources().getColor(R.color.black));
                txt_menu.setTextColor(getResources().getColor(R.color.black));

                ll_populer.setVisibility(View.GONE);
                ns_menu.setVisibility(View.GONE);
                ns_rating.setVisibility(View.GONE);
                ns_information.setVisibility(View.VISIBLE);
                break;
            case R.id.txt_menu:
                txt_menu.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);
                txt_rating.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                txt_information.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                txt_menu.setTextColor(getResources().getColor(R.color.white));
                txt_information.setTextColor(getResources().getColor(R.color.black));
                txt_rating.setTextColor(getResources().getColor(R.color.black));

                ll_populer.setVisibility(View.VISIBLE);
                ns_menu.setVisibility(View.VISIBLE);
                ns_information.setVisibility(View.GONE);
                ns_rating.setVisibility(View.GONE);
                break;
        }
    }
}