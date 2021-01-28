package yummy.one.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import yummy.one.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Log.e("Activity","HomeActivity");
    }
}