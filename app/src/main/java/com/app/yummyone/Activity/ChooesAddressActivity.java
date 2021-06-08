package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yummyone.R;

public class ChooesAddressActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;
    ImageView img_back;
    TextView txt_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooes_address);
        getSupportActionBar().hide();
        inint();
    }

    private void inint() {
        img_back=findViewById(R.id.img_back);
        txt_done=findViewById(R.id.txt_done);
        img_back.setOnClickListener(this);
        txt_done.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.txt_done:
                Intent ipayment=new Intent(this,PaymentMethodActivity.class);
                startActivity(ipayment);
                break;
        }
    }
}