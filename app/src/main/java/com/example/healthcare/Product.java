package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;

public class Product extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Products> mProductData;
    private ProductsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager( new GridLayoutManager(this,getResources().getInteger(R.integer.grid_column_count)));
        mProductData = new ArrayList<>();
        mAdapter = new ProductsAdapter(this, mProductData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();

    }
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int from = viewHolder.getAdapterPosition();
        int to = target.getAdapterPosition();
        Collections.swap(mProductData, from, to);
        mAdapter.notifyItemMoved(from, to);
        return true;
    }

    private void initializeData() {
        String[] productTitle = getResources().getStringArray(R.array.product_title);
        String[] productPrice = getResources().getStringArray(R.array.product_price);
        String[] productDetail  = getResources().getStringArray(R.array.product_detail);

        TypedArray productsResImage = getResources().obtainTypedArray(R.array.product_image);

        mProductData.clear();

        for (int i = 0; i < productTitle.length; i++) {
            mProductData.add(new Products(productTitle[i], productPrice[i], productDetail[i], productsResImage.getResourceId(i, 0)));
        }

        productsResImage.recycle();

        mAdapter.notifyDataSetChanged();
    }
}
