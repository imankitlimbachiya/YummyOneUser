package yummy.one.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;
import yummy.one.AppConstants.ConstantFunction;
import yummy.one.R;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    ImageView imgBack;
    OtpTextView txtOtpView;
    TextView txtContinue, txtResendCode;
    String Name = "", Email = "", PhoneNumber = "", Otp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        Log.e("Activity", "OtpActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        GetIntentData();
    }

    public void ViewInitialization() {
        imgBack = findViewById(R.id.imgBack);

        txtOtpView = findViewById(R.id.txtOtpView);
        txtOtpView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
                // fired when user types something in the OtpBox
                if (txtOtpView.getOTP().length() == 6) {
                    txtContinue.setEnabled(true);
                } else {
                    txtContinue.setEnabled(false);
                }
            }

            @Override
            public void onOTPComplete(String otp) {
                // fired when user has entered the OTP fully.
                Toast.makeText(mContext, "The OTP is " + otp,  Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, ChooseLocationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtContinue = findViewById(R.id.txtContinue);
        txtResendCode = findViewById(R.id.txtResendCode);
    }

    public void ViewOnClick() {
        imgBack.setOnClickListener(this);
        txtContinue.setOnClickListener(this);
        txtResendCode.setOnClickListener(this);
    }

    public void GetIntentData() {
        Name = getIntent().getStringExtra("Name");
        Email = getIntent().getStringExtra("Email");
        PhoneNumber = getIntent().getStringExtra("PhoneNumber");
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtContinue:
                Intent intent = new Intent(mContext, ChooseLocationActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.txtResendCode:

                break;
        }
    }
}