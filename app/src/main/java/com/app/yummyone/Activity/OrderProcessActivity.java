package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.yummyone.R;

public class OrderProcessActivity extends AppCompatActivity {
    Context mContext;
    ViewPager viewPager;

   MyViewPagerAdapter myViewPagerAdapter;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_process);

        Log.e("Activity","OrderProcessActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        AddLayoutArray();

        SetPagerAdapter();
    }

    public void ViewInitialization() {
        viewPager = findViewById(R.id.viewPager_order);

    }

    public void ViewOnClick() {

    }

    public void SetPagerAdapter() {
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
       // viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    public void AddLayoutArray() {
        layouts = new int[]{
                R.layout.item_order_process_one,
                R.layout.item_order_process_two,
                R.layout.item_order_process_three,
                R.layout.item_order_process_four,
                R.layout.item_order_process_five,
                R.layout.item_order_process_six
        };
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            /*if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                txtNext.setText("Next");
            } else {
                // still pages are left
                txtNext.setText("Next");
            }*/
           // txtNext.setText("Next");
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    public class MyViewPagerAdapter extends PagerAdapter {

        LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}