package com.example.healthcare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAlllBtn;
    private  RecyclerView horizontalRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_detail);
        horizontalLayoutViewAlllBtn = view.findViewById(R.id.horizontal_scroll_layout_button);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.apple,
                "Apple Cider", "New Product", "RM 107.00"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.abc,
                "Nature Bounty Anxiety", "New Product", "RM 107.00"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.mango,
                "African Mango Seed", "New Product", "RM 107.00"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.c,
                "Acai Lip Balm", "New Product", "RM 107.00"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.f,
                "Bilberry & Lutein", "New Product", "RM 107.00"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bio,
                "Bio Turmeric 3000", "New Product", "RM 107.00"));

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.h,
                "Delicious Gummy Omega 3", "New Product", "RM 107.00"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAlllbtn = view.findViewById(R.id.grid_product_layout_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));


        return view;
    }
}
