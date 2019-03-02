package com.kakadiya.shopify.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.kakadiya.shopify.R;
import com.kakadiya.shopify.adapter.ProductListViewAdapter;
import com.kakadiya.shopify.adapter.TagListViewAdapter;
import com.kakadiya.shopify.constant.Constant;
import com.kakadiya.shopify.models.ProductsList;
import com.kakadiya.shopify.models.ShopifyResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductsView extends AppCompatActivity {

    ListView listView;
    TextView tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.product_list_view);
        tag = (TextView) findViewById(R.id.tag_txt);

        ShopifyResponse shopifyResponse = (ShopifyResponse) getIntent().getSerializableExtra(Constant.KEY_SHOPIFY_OBJECT);
        String tagName = getIntent().getStringExtra(Constant.KEY_TAG);

        tag.setText("Tag : "+tagName);

        final List<ProductsList> productsLists = shopifyResponse.getProductsList();
        int productsListsSize = productsLists.size();

        final List<String> productNameList = new ArrayList<String>();
        final List<String> totalInventoryList = new ArrayList<String>();
        final List<String> productImageList = new ArrayList<String>();

        //Get list of Products which contains the same Tag value
        for(int i=0; i<productsListsSize;i++)
        {
            if(productsLists.get(i).getTags().matches(tagName)){

                int inventoryCount = 0;
                int variantListSize = productsLists.get(i).getVariantsList().size();

                for(int j =0; j<variantListSize; j++){
                    inventoryCount = inventoryCount + productsLists.get(i).getVariantsList().get(j).getInventoryQuantity();
                }

                productNameList.add(productsLists.get(i).getTitle());
                totalInventoryList.add(String.valueOf(inventoryCount));
                productImageList.add(productsLists.get(i).getImage().getSrc());
            }
        }

        listView.setAdapter(new ProductListViewAdapter(this,this, productNameList, totalInventoryList, productImageList));
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
