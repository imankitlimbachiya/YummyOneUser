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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import yummy.one.AppConstants.ConstantFunction;
import yummy.one.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    EditText edtFullName, edtEmailAddress;
    TextView txtMobileNumber, txtContinue, txtContinueWith;
    CircleImageView imgApple, imgTwitter, imgFacebook, imgAppleBottom, imgTwitterBottom, imgFacebookBottom;

    String PhoneNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Log.e("Activity", "SignUpActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        GetIntentData();
    }

    public void ViewInitialization() {
        edtFullName = findViewById(R.id.edtFullName);
        edtEmailAddress = findViewById(R.id.edtEmailAddress);

        txtMobileNumber = findViewById(R.id.txtMobileNumber);
        txtContinue = findViewById(R.id.txtContinue);
        txtContinueWith = findViewById(R.id.txtContinueWith);

        imgApple = findViewById(R.id.imgApple);
        imgTwitter = findViewById(R.id.imgTwitter);
        imgFacebook = findViewById(R.id.imgFacebook);
        imgAppleBottom = findViewById(R.id.imgAppleBottom);
        imgTwitterBottom = findViewById(R.id.imgTwitterBottom);
        imgFacebookBottom = findViewById(R.id.imgFacebookBottom);
    }

    public void ViewOnClick() {
        txtContinue.setOnClickListener(this);
        imgApple.setOnClickListener(this);
        imgTwitter.setOnClickListener(this);
        imgFacebook.setOnClickListener(this);
        imgAppleBottom.setOnClickListener(this);
        imgTwitterBottom.setOnClickListener(this);
        imgFacebookBottom.setOnClickListener(this);
    }

    public void GetIntentData() {
        PhoneNumber = getIntent().getStringExtra("PhoneNumber");

        ViewSetText(PhoneNumber);
    }

    public void ViewSetText(String PhoneNumber) {
        txtMobileNumber.setText(PhoneNumber);
    }

    public void WhenKeyboardOpen() {
        imgApple.setVisibility(View.VISIBLE);
        imgTwitter.setVisibility(View.VISIBLE);
        imgFacebook.setVisibility(View.VISIBLE);
        txtContinueWith.setVisibility(View.GONE);
        imgAppleBottom.setVisibility(View.GONE);
        imgTwitterBottom.setVisibility(View.GONE);
        imgFacebookBottom.setVisibility(View.GONE);
    }

    public void WhenKeyboardClose() {
        imgApple.setVisibility(View.GONE);
        imgTwitter.setVisibility(View.GONE);
        imgFacebook.setVisibility(View.GONE);
        txtContinueWith.setVisibility(View.VISIBLE);
        imgAppleBottom.setVisibility(View.VISIBLE);
        imgTwitterBottom.setVisibility(View.VISIBLE);
        imgFacebookBottom.setVisibility(View.VISIBLE);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtContinue:
                String Name = edtFullName.getText().toString().trim();
                String Email = edtEmailAddress.getText().toString().trim();
                if (Name.equals("")) {
                    Toast.makeText(mContext, "Please Enter Your Name", Toast.LENGTH_LONG).show();
                } else if (Email.equals("")) {
                    Toast.makeText(mContext, "Please Enter Your Email", Toast.LENGTH_LONG).show();
                } else if (!ConstantFunction.isValidEmail(Email)) {
                    Toast.makeText(mContext, "Please Enter Your Valid Email", Toast.LENGTH_SHORT).show();
                } else {
                    Intent Otp = new Intent(mContext, OtpActivity.class);
                    Otp.putExtra("Name", Name);
                    Otp.putExtra("Email", Email);
                    Otp.putExtra("PhoneNumber", PhoneNumber);
                    startActivity(Otp);
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        edtFullName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                // Log.e("onFocusChange ", "" + hasFocus);
                if (hasFocus) {
                    //got focus
                    WhenKeyboardOpen();
                } else {
                    //lost focus
                    WhenKeyboardClose();
                }
            }
        });

        EditTextListener(edtEmailAddress);
    }

    public void EditTextListener(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                // Log.e("afterTextChanged ","" + editable);
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Log.e("beforeTextChanged ","" + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Log.e("onTextChanged ","" + charSequence);
                String Value = editText.getText().toString().trim();
                if (!ConstantFunction.isValidEmail(Value)) {
                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.uncheck, 0);
                } else {
                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                }
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                // Log.e("onFocusChange ", "" + hasFocus);
                if (hasFocus) {
                    //got focus
                    WhenKeyboardOpen();
                } else {
                    //lost focus
                    WhenKeyboardClose();
                }
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    WhenKeyboardClose();
                    return true;
                }
                return false;
            }
        });
    }
}