package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductDetail extends AppCompatActivity {

    private TextView mTitleText;
    private TextView mInfoText;
    private TextView mDetail;
    private ImageView ivSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ProductDetail.this, Product.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        mTitleText = (TextView)findViewById(R.id.titleDetail);
        mInfoText = (TextView)findViewById(R.id.subTitleDetail);
        mDetail = (TextView)findViewById(R.id.infoDetail);
        ivSport = (ImageView)findViewById(R.id.iv_sportsDetail);

        Intent i = getIntent(); mTitleText.setText(getIntent().getStringExtra("title"));
        mInfoText.setText(getIntent().getStringExtra("info"));
        mDetail.setText(getIntent().getStringExtra("detail"));
        Glide.with(this) .load(getIntent().getIntExtra("image",0)) .into(ivSport);
    }
}
