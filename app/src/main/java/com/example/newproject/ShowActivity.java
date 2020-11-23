package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {
    private TextView tvName, tvPoroda, tvSity, tvAge;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvName = findViewById(R.id.tvName);
        tvPoroda = findViewById(R.id.tvPoroda);
        tvSity = findViewById(R.id.tvSity);
        tvAge = findViewById(R.id.tvAge);
    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvName.setText(i.getStringExtra(Constant.USER_NAME));
            tvPoroda.setText(i.getStringExtra(Constant.USER_PORODA));
            tvSity.setText(i.getStringExtra(Constant.USER_SITY));
            tvAge.setText(i.getStringExtra(Constant.USER_AGE));
        }
    }
}