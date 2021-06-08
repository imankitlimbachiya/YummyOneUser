package com.app.yummyone.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.yummyone.R;
import com.hbb20.CountryCodePicker;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    CircleImageView imgForward;
    EditText edtPhone;
    CountryCodePicker countryCodePicker;
    TextView txtSignIn, txtTermPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();
    }

    public void ViewInitialization() {
        imgForward = findViewById(R.id.imgForward);

        edtPhone = findViewById(R.id.edtPhone);

        countryCodePicker = findViewById(R.id.countryCodePicker);
//        countryCodePicker.getSelectedCountryCodeWithPlus();

        txtSignIn = findViewById(R.id.txtSignIn);
        txtTermPolicy = findViewById(R.id.txtTermPolicy);

        Spanned string = Html.fromHtml("By continuing, you agree to YummyOne’s<br><b>Terms of Service</b> and <b>Privacy Policy</b>");
        txtTermPolicy.setText(string);
    }

    public void ViewOnClick() {
        imgForward.setOnClickListener(this);
        txtSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgForward:
                finish();
                this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.txtSignIn:
                String Phone = edtPhone.getText().toString().trim();
                Intent SignUp = new Intent(mContext, SignUpActivity.class);
                SignUp.putExtra("Phone", Phone);
                startActivity(SignUp);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}