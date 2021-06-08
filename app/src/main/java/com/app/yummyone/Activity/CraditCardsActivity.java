package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.yummyone.R;

public class CraditCardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cradit_cards);
        getSupportActionBar().hide();
    }
}