package com.kakadiya.shopify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kakadiya.shopify.R;
import com.kakadiya.shopify.models.ProductsList;
import com.kakadiya.shopify.views.TagView;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TagListViewAdapter extends ArrayAdapter<String> {
    private List<String> mProductsList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private TagView mTagView;

    public TagListViewAdapter(Context context, TagView tagView, List<String> productsList) {
        super(context, R.layout.activity_custom_tag_list_view, productsList);
        if(productsList!= null) {
            this.mProductsList = productsList;
        }
        if(context!=null) {
            this.mLayoutInflater = LayoutInflater.from(context);
            this.mContext = context;
        }
        if(tagView!=null) {
            this.mTagView = tagView;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.activity_custom_tag_list_view, parent, false);

            holder = new ViewHolder();
            holder.mTagName = (TextView) view.findViewById(R.id.txt_tag_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if(mProductsList!=null) {
            holder.mTagName.setText(mProductsList.get(position));
        }
        return view;
    }

    static class ViewHolder {
        private TextView mTagName;
    }
}