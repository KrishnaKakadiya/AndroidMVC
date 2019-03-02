package com.kakadiya.shopify.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kakadiya.shopify.R;
import com.kakadiya.shopify.models.Image;
import com.kakadiya.shopify.models.VariantsList;
import com.kakadiya.shopify.views.ProductsView;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductListViewAdapter extends ArrayAdapter<String> {
    private List<String> mProductNameList, mTotalInventoryList, mProductImageList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ProductsView mProductsView;

    public ProductListViewAdapter(Context context, ProductsView productsView, List<String> productNameList, List<String> totalInventoryList, List<String> productImageList) {
        super(context, R.layout.activity_custom_product_list_view, productNameList);
        if(productNameList!= null) {
            this.mProductNameList = productNameList;
        }
        if(totalInventoryList!= null) {
            this.mTotalInventoryList = totalInventoryList;
        }
        if(productImageList!= null) {
            this.mProductImageList = productImageList;
        }
        if(context!=null) {
            this.mLayoutInflater = LayoutInflater.from(context);
            this.mContext = context;
        }
        if(productsView!=null) {
            this.mProductsView = productsView;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ProductListViewAdapter.ViewHolder holder = null;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.activity_custom_product_list_view, parent, false);

            holder = new ProductListViewAdapter.ViewHolder();
            holder.mProductName = (TextView) view.findViewById(R.id.txt_product_name);
            holder.mTotalInventory = (TextView) view.findViewById(R.id.txt_total_inventory);
            holder.mProductImage = (CircleImageView) view.findViewById(R.id.product_image);
            view.setTag(holder);
        } else {
            holder = (ProductListViewAdapter.ViewHolder) view.getTag();
        }

        if(mProductNameList!=null && mTotalInventoryList!=null && mProductImageList!=null) {
            holder.mProductName.setText(mProductNameList.get(position));
            holder.mTotalInventory.setText(String.valueOf(mTotalInventoryList.get(position)));
            //set image
            String profilePicture = mProductImageList.get(position);
            Picasso.with(mLayoutInflater.getContext())
                    .load(TextUtils.isEmpty(profilePicture) ? null : profilePicture)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                    .fit()
                    .into(holder.mProductImage);
        }

        return view;
    }

    static class ViewHolder {
        private TextView mProductName, mTotalInventory;
        private CircleImageView mProductImage;
    }
}