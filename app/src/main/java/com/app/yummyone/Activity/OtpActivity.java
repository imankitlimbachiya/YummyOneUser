package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.yummyone.R;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgBack;
    Context mContext;
    ProgressBar progressBar;
    EditText edtOtpFirstNumber, edtOtpSecondNumber, edtOtpThirdNumber, edtOtpFourthNumber, edtOtpFifthNumber, edtOtpSixthNumber;
    EditText[] editTexts;
    TextView btnSubmit,btnSubmit_disable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();

        EditTextListener();
    }
    
    public void ViewInitialization(){
        progressBar = findViewById(R.id.progressBar);
        imgBack = findViewById(R.id.imgBack);

        edtOtpFirstNumber = findViewById(R.id.edtOtpFirstNumber);
        edtOtpSecondNumber = findViewById(R.id.edtOtpSecondNumber);
        edtOtpThirdNumber = findViewById(R.id.edtOtpThirdNumber);
        edtOtpFourthNumber = findViewById(R.id.edtOtpFourthNumber);
        edtOtpFifthNumber = findViewById(R.id.edtOtpFifthNumber);
        edtOtpSixthNumber = findViewById(R.id.edtOtpSixthNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit_disable = findViewById(R.id.btnSubmit_disable);
    }

    public void ViewOnClick() {
        // imgForward.setOnClickListener(this);
         btnSubmit.setOnClickListener(this);
        imgBack.setOnClickListener(this);

    }

    public void EditTextListener(){
        edtOtpFirstNumber.addTextChangedListener(new GenericTextWatcher(edtOtpFirstNumber,btnSubmit,btnSubmit_disable));
        edtOtpSecondNumber.addTextChangedListener(new GenericTextWatcher(edtOtpSecondNumber,btnSubmit,btnSubmit_disable));
        edtOtpThirdNumber.addTextChangedListener(new GenericTextWatcher(edtOtpThirdNumber,btnSubmit,btnSubmit_disable));
        edtOtpFourthNumber.addTextChangedListener(new GenericTextWatcher(edtOtpFourthNumber,btnSubmit,btnSubmit_disable));
        edtOtpFifthNumber.addTextChangedListener(new GenericTextWatcher(edtOtpFifthNumber,btnSubmit,btnSubmit_disable));
        edtOtpSixthNumber.addTextChangedListener(new GenericTextWatcher(edtOtpSixthNumber,btnSubmit,btnSubmit_disable));

        editTexts = new EditText[]{edtOtpFirstNumber, edtOtpSecondNumber, edtOtpThirdNumber, edtOtpFourthNumber,
                edtOtpFifthNumber, edtOtpSixthNumber};

        edtOtpFirstNumber.addTextChangedListener(new PinTextWatcher(0));
        edtOtpSecondNumber.addTextChangedListener(new PinTextWatcher(1));
        edtOtpThirdNumber.addTextChangedListener(new PinTextWatcher(2));
        edtOtpFourthNumber.addTextChangedListener(new PinTextWatcher(3));
        edtOtpFifthNumber.addTextChangedListener(new PinTextWatcher(4));
        edtOtpSixthNumber.addTextChangedListener(new PinTextWatcher(5));

        edtOtpFirstNumber.setOnKeyListener(new PinOnKeyListener(0));
        edtOtpSecondNumber.setOnKeyListener(new PinOnKeyListener(1));
        edtOtpThirdNumber.setOnKeyListener(new PinOnKeyListener(2));
        edtOtpFourthNumber.setOnKeyListener(new PinOnKeyListener(3));
        edtOtpFifthNumber.setOnKeyListener(new PinOnKeyListener(4));
        edtOtpSixthNumber.setOnKeyListener(new PinOnKeyListener(5));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:
                Intent iLocation=new Intent(mContext,ChooseLocationActivity.class);
                startActivity(iLocation);
                break;
            case R.id.imgBack:
              finish();
                break;
        }
    }

    public static class GenericTextWatcher implements TextWatcher {

        private final View view;
        TextView btnSubmit,btnSubmit_disable;

        private GenericTextWatcher(View view,TextView btnSubmit,TextView btnSubmit_disable ) {
            this.view = view;
            this.btnSubmit = btnSubmit;
            this.btnSubmit_disable = btnSubmit_disable;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            // TODO Auto-generated method stub
            String text = editable.toString();
            switch (view.getId()) {
                case R.id.edtOtpFirstNumber:
                    /*if (text.length() == 1) {
                        edtOtpSecondNumber.requestFocus();
                        // setRequestFocus(edtOtpSecondNumber);
                        // removeRequestFocus(edtOtpFirstNumber);
                    } else {
                        edtOtpFirstNumber.requestFocus();
                        setRequestFocus(edtOtpFirstNumber);
                    }*/
                    break;
                case R.id.edtOtpSecondNumber:
                    /*if (text.length() == 1) {
                        edtOtpThirdNumber.requestFocus();
                        setRequestFocus(edtOtpThirdNumber);
                        // removeRequestFocus(edtOtpSecondNumber);
                    } else if (text.length() == 0) {
                        edtOtpSecondNumber.requestFocus();
                        setRequestFocus(edtOtpSecondNumber);
                    }*/
                    break;
                case R.id.edtOtpThirdNumber:
                    /*if (text.length() == 1) {
                        edtOtpFourthNumber.requestFocus();
                        setRequestFocus(edtOtpFourthNumber);
                        // removeRequestFocus(edtOtpThirdNumber);
                    } else if (text.length() == 0) {
                        edtOtpThirdNumber.requestFocus();
                        setRequestFocus(edtOtpThirdNumber);
                    }*/
                    break;
                case R.id.edtOtpFourthNumber:
                    /*if (text.length() == 1) {
                        edtOtpFifthNumber.requestFocus();
                        setRequestFocus(edtOtpFifthNumber);
                        // removeRequestFocus(edtOtpFourthNumber);
                    } else if (text.length() == 0) {
                        edtOtpFourthNumber.requestFocus();
                        setRequestFocus(edtOtpFourthNumber);
                    }*/
                    break;
                case R.id.edtOtpFifthNumber:
                    /*if (text.length() == 1) {
                        edtOtpSixthNumber.requestFocus();
                        setRequestFocus(edtOtpSixthNumber);
                        // removeRequestFocus(edtOtpFifthNumber);
                    } else if (text.length() == 0) {
                        edtOtpFifthNumber.requestFocus();
                        setRequestFocus(edtOtpFifthNumber);
                    }*/
                    break;
                case R.id.edtOtpSixthNumber:
                    if (text.length() == 1) {

                        btnSubmit.setVisibility(View.VISIBLE);
                        btnSubmit_disable.setVisibility(View.GONE);
                        //hideSoftKeyboard(edtOtpSixthNumber);
                        // removeRequestFocus(edtOtpSixthNumber);
                    } else {
                        btnSubmit.setVisibility(View.GONE);
                        btnSubmit_disable.setVisibility(View.VISIBLE);
//                        edtOtpSixthNumber.requestFocus();
//                        setRequestFocus(edtOtpSixthNumber);
                    }
                    break;
            }
        }
    }

    public class PinTextWatcher implements TextWatcher {

        private final int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        PinTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            newTypedString = s.subSequence(start, start + count).toString().trim();
        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = newTypedString;

            /* Detect paste event and set first char */
            if (text.length() > 1)
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1)
                moveToNext();
            else if (text.length() == 0)
                moveToPrevious();
        }

        private void moveToNext() {
            if (!isLast)
                editTexts[currentIndex + 1].requestFocus();

            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                // editTexts[currentIndex - 1].requestFocus();
                editTexts[currentIndex].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    public class PinOnKeyListener implements View.OnKeyListener {

        private final int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }
    }
}