package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_back;
    TextView txt_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        img_back=findViewById(R.id.img_back);
        txt_next=findViewById(R.id.txt_next);
        img_back.setOnClickListener(this);
        txt_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_next:
                Intent ichooes=new Intent(this,ChooesAddressActivity.class);
                startActivity(ichooes);
                break;
        }
    }
}