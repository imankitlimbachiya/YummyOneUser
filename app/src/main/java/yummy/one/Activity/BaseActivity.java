package yummy.one.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import yummy.one.Fragment.Home;
import yummy.one.Fragment.Search;
import yummy.one.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    FrameLayout frameLayout;
    RelativeLayout mainBaseRelativeLayout;
    LinearLayout TabHomeLayout, TabSearchLayout;

    @Override
    public void setContentView(int layoutResID) {
        mainBaseRelativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        frameLayout = mainBaseRelativeLayout.findViewById(R.id.frameLayout);
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(mainBaseRelativeLayout);

        Log.e("Activity","BaseActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        loadFragment(new Home());
    }

    public void ViewInitialization() {
        frameLayout = findViewById(R.id.frameLayout);
        mainBaseRelativeLayout = findViewById(R.id.mainBaseRelativeLayout);

        TabHomeLayout = findViewById(R.id.TabHomeLayout);
        TabSearchLayout = findViewById(R.id.TabSearchLayout);
    }

    public void ViewOnClick() {
        TabHomeLayout.setOnClickListener(this);
        TabSearchLayout.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.TabHomeLayout:
                loadFragment(new Home());
                break;
            case R.id.TabSearchLayout:
                loadFragment(new Search());
                break;
        }

    }

    public boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    // .addToBackStack(null)
                    // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
            return true;
        }
        return false;
    }
}