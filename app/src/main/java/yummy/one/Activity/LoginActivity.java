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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    EditText edtPhoneNumber;
    TextView txtContinue, txtContinueWith;
    CircleImageView imgApple, imgTwitter, imgFacebook, imgAppleBottom, imgTwitterBottom, imgFacebookBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.e("Activity","LoginActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();
    }

    public void ViewInitialization() {
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);

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
                String PhoneNumber = edtPhoneNumber.getText().toString().trim();
                if (PhoneNumber.equals("")) {
                    Toast.makeText(mContext, "Please Enter Your PhoneNumber", Toast.LENGTH_LONG).show();
                } else if (!ConstantFunction.isValidMobile(PhoneNumber)) {
                    Toast.makeText(mContext, "Please Enter Your Valid PhoneNumber", Toast.LENGTH_LONG).show();
                } else {
                    Intent SignUp = new Intent(mContext, SignUpActivity.class);
                    SignUp.putExtra("PhoneNumber", PhoneNumber);
                    startActivity(SignUp);
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        edtPhoneNumber.addTextChangedListener(new TextWatcher() {

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
                if (charSequence.length() != 0) {
                    WhenKeyboardOpen();
                } else {
                    WhenKeyboardClose();
                }

                if (charSequence.toString().length() == 10) {
                    edtPhoneNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                } else {
                    edtPhoneNumber.setCompoundDrawables(null, null, null, null);
                }
            }
        });

        edtPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

        edtPhoneNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(edtPhoneNumber.getWindowToken(), 0);
                    WhenKeyboardClose();
                    return true;
                }
                return false;
            }
        });
    }
}