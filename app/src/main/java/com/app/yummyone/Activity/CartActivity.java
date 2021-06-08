package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.R;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_back;
    TextView txt_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        img_back=findViewById(R.id.img_back);
        txt_payment=findViewById(R.id.txt_payment);
        img_back.setOnClickListener(this);
        txt_payment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_payment:
                Intent ipayment=new Intent(this,PaymentActivity.class);
                startActivity(ipayment);
                break;
        }
    }
}