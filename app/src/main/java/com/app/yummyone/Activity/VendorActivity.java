package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.R;

public class VendorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_viewbag,txt_popular_items,txt_starters,txt_main_course;
    ImageView img_back,img_bag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        txt_viewbag=findViewById(R.id.txt_viewbag);
        txt_popular_items=findViewById(R.id.txt_popular_items);
        txt_starters=findViewById(R.id.txt_starters);
        txt_main_course=findViewById(R.id.txt_main_course);

        img_back=findViewById(R.id.img_back);
        img_bag=findViewById(R.id.img_bag);

        txt_viewbag.setOnClickListener(this);
        img_back.setOnClickListener(this);
        txt_popular_items.setOnClickListener(this);
        txt_starters.setOnClickListener(this);
        txt_main_course.setOnClickListener(this);
        img_bag.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_viewbag:
                Intent ivenderinfo=new Intent(this,VendorInformationActivity.class);
                startActivity(ivenderinfo);
                break;
            case R.id.img_bag:
                Intent ibag=new Intent(this,CartActivity.class);
                startActivity(ibag);
                break;
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_popular_items:
                txt_popular_items.getBackground().setColorFilter(getResources().getColor(R.color.Red), PorterDuff.Mode.SRC_ATOP);
                txt_starters.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                txt_main_course.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                txt_popular_items.setTextColor(getResources().getColor(R.color.white));
                txt_starters.setTextColor(getResources().getColor(R.color.black));
                txt_main_course.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.txt_starters:
                txt_popular_items.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey), PorterDuff.Mode.SRC_ATOP);
                txt_starters.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);
                txt_main_course.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);

                txt_popular_items.setTextColor(getResources().getColor(R.color.black));
                txt_starters.setTextColor(getResources().getColor(R.color.white));
                txt_main_course.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.txt_main_course:
                txt_popular_items.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey), PorterDuff.Mode.SRC_ATOP);
                txt_starters.getBackground().setColorFilter(getResources().getColor(R.color.VvDGrey),PorterDuff.Mode.SRC_ATOP);
                txt_main_course.getBackground().setColorFilter(getResources().getColor(R.color.Red),PorterDuff.Mode.SRC_ATOP);

                txt_popular_items.setTextColor(getResources().getColor(R.color.black));
                txt_starters.setTextColor(getResources().getColor(R.color.black));
                txt_main_course.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }
}