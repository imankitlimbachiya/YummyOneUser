package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.yummyone.R;

public class SearchAddressActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    Context mContext;
    CircleImageView img_Back;
    LinearLayout ll_Current_Location;
    EditText edt_Enter_Location;
    ImageView img_Cancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);
        Log.e("Activity", "SearchAddressActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();
    }

    public void ViewInitialization() {
        img_Back = findViewById(R.id.img_Back);

        img_Cancle = findViewById(R.id.img_Cancle);
        edt_Enter_Location = findViewById(R.id.edt_Enter_Location);

        ll_Current_Location = findViewById(R.id.ll_Current_Location);

    }

    public void ViewOnClick() {
        img_Back.setOnClickListener(this);
        ll_Current_Location.setOnClickListener(this);
        img_Cancle.setOnClickListener(this);

        edt_Enter_Location.addTextChangedListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_Back:
                finish();
                break;
            case R.id.img_Cancle:
                edt_Enter_Location.getText().clear();
                break;
            case R.id.ll_Current_Location:
                Intent isearch=new Intent(mContext,AddAddressActivity.class);
                startActivity(isearch);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        if (text.length() >0) {
            img_Cancle.setVisibility(View.VISIBLE);
        } else {
            img_Cancle.setVisibility(View.GONE);
        }
    }
}