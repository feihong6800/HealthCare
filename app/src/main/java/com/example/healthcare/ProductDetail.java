package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductDetail extends AppCompatActivity {

    private TextView mTitleText;
    private TextView mInfoText;
    private ImageView ivSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mTitleText = (TextView)findViewById(R.id.titleDetail);
        mInfoText = (TextView)findViewById(R.id.subTitleDetail);
        ivSport = (ImageView)findViewById(R.id.iv_sportsDetail);

        Intent i = getIntent(); mTitleText.setText(getIntent().getStringExtra("title"));
        mInfoText.setText(getIntent().getStringExtra("info"));
        Glide.with(this) .load(getIntent().getIntExtra("image",0)) .into(ivSport);
    }
}
