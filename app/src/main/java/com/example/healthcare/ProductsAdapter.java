package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private ArrayList<Products> mProductData;
    private Context mContext;

    ProductsAdapter(Context context, ArrayList<Products> productsData) {
        this.mProductData = productsData;
        this.mContext = context;
    }

    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.product_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Products currentProduct = mProductData.get(position);
        Glide.with(mContext).load(currentProduct.getImageResource()).into(holder.mProductImage);
        holder.bindTo(currentProduct);
    }
    @Override
    public int getItemCount() {
        return mProductData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Products currentProduct = mProductData.get(getAdapterPosition());
            Intent i = new Intent(mContext,ProductDetail.class);
            i.putExtra("title",currentProduct.getTitle());
            i.putExtra("info",currentProduct.getInfo());
            i.putExtra("detail", currentProduct.getDetail());
            i.putExtra("image",currentProduct.getImageResource());
            mContext.startActivity(i);
        }

        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mProductImage;

        ViewHolder(View itemView) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mProductImage = (ImageView)itemView.findViewById(R.id.iv_sports);
            itemView.setOnClickListener(this);
        }

        void bindTo(Products currentProduct){
            mTitleText.setText(currentProduct.getTitle());
            mInfoText.setText(currentProduct.getInfo());
        }
    }
}