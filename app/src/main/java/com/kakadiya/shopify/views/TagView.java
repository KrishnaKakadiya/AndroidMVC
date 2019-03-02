package com.kakadiya.shopify.views;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kakadiya.shopify.R;
import com.kakadiya.shopify.SHOPIFYApplication;
import com.kakadiya.shopify.adapter.TagListViewAdapter;
import com.kakadiya.shopify.constant.Constant;
import com.kakadiya.shopify.models.ProductsList;
import com.kakadiya.shopify.models.ShopifyResponse;
import com.kakadiya.shopify.presenter.TagPresenter;
import com.kakadiya.shopify.presenter.TagViewListener;
import com.kakadiya.shopify.restfuls.RestApi;

import java.util.ArrayList;
import java.util.List;

public class TagView extends AppCompatActivity implements TagViewListener{

    ProgressDialog progressDialog;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        listView = (ListView)findViewById(R.id.tag_list_view);

        shopifyApplication = SHOPIFYApplication.getApplication(this);
        restApi = shopifyApplication.getRestApi();
        tagPresenter = new TagPresenter(this,this, restApi);

        showProgress();
        tagPresenter.getData();
    }
    private TagPresenter tagPresenter;
    private SHOPIFYApplication shopifyApplication;
    private RestApi restApi;

    private void showProgress() {
        progressDialog = new ProgressDialog(TagView.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void dismissProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void validateCredential(String message) {
        dismissProgressDialog();
        AlertDialog alertDialog = new AlertDialog.Builder(TagView.this,AlertDialog.THEME_HOLO_LIGHT).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setMessage(message);
        alertDialog.setButton(Constant.KEY_ALERT_OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();

    }

    @Override
    public void successTag(Object objectType) {

        final ShopifyResponse shopifyResponse = (ShopifyResponse) objectType;

        if(shopifyResponse != null) {

            final List<ProductsList> productsLists = shopifyResponse.getProductsList();
            int size = productsLists.size();
            final List<String> list = new ArrayList<String>();

            //Check unique Tags
            for(int i=0; i<size-1;i++)
            {
                boolean found = false;
                for(int j=i+1; !found && j < size ; j++)
                {
                    if(productsLists.get(i).getTags().matches(productsLists.get(j).getTags())){
                        found = true;
                    }
                }
                if(!found){
                    list.add(productsLists.get(i).getTags());
                }
            }

            dismissProgressDialog();

            listView.setAdapter(new TagListViewAdapter(this,this, list));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(TagView.this,ProductsView.class);
                    intent.putExtra(Constant.KEY_SHOPIFY_OBJECT, shopifyResponse);
                    intent.putExtra(Constant.KEY_TAG, list.get(position));
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public String getAccessToken() {
        return Constant.ACCESS_TOKEN;
    }

    @Override
    public String getPage() {
        return Constant.PAGE_NUMBER;
    }
}
