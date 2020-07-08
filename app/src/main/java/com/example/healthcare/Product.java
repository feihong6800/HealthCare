package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;

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

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager( new GridLayoutManager(this,getResources().getInteger(R.integer.grid_column_count)));
        mProductData = new ArrayList<>();
        mAdapter = new ProductsAdapter(this, mProductData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mProductData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(mRecyclerView);
    }
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int from = viewHolder.getAdapterPosition();
        int to = target.getAdapterPosition();
        Collections.swap(mProductData, from, to);
        mAdapter.notifyItemMoved(from, to);
        return true;
    }

    private void initializeData() {
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        TypedArray sportsResImage = getResources().obtainTypedArray(R.array.sports_images);

        mProductData.clear();

        for (int i = 0; i < sportsList.length; i++) {
            mProductData.add(new Products(sportsList[i], sportsInfo[i], sportsResImage.getResourceId(i, 0)));
        }

        sportsResImage.recycle();

        mAdapter.notifyDataSetChanged();
    }

    public void openProduct(MenuItem item) {
        Intent intent = new Intent(this, Product.class);
        startActivity(intent);
    }
}
