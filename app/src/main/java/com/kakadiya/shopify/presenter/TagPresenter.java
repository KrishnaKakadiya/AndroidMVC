package com.kakadiya.shopify.presenter;

import android.content.Context;

import com.kakadiya.shopify.R;
import com.kakadiya.shopify.SHOPIFYApplication;
import com.kakadiya.shopify.models.ShopifyResponse;
import com.kakadiya.shopify.restfuls.RestApi;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TagPresenter {
    private TagViewListener mTagViewListener;
    private Context mContext;
    private RestApi mRestApi;

    public TagPresenter(Context context, TagViewListener tagViewListener, RestApi restApi)
    {
        this.mContext = context;
        this.mTagViewListener = tagViewListener;
        this.mRestApi = restApi;
    }
    public void getData() {
        String pageNumber = mTagViewListener.getPage();
        if (pageNumber != null && pageNumber.trim().length() == 0) {
            mTagViewListener.validateCredential(mContext.getString(R.string.app_not_null_msg_page_number));
            return;
        }
        String accessToken = mTagViewListener.getAccessToken();
        if (accessToken != null && accessToken.trim().length() == 0) {
            mTagViewListener.validateCredential(mContext.getString(R.string.app_not_null_msg_token));
            return;
        }
        SHOPIFYApplication.printLogMessage(3, "Tags List Successful");

        mRestApi.phrData(pageNumber, accessToken, new Callback<ShopifyResponse>()
        {
            @Override
            public void success(ShopifyResponse shopifyResponse, Response response)
            {
                if(shopifyResponse != null) {
                    mTagViewListener.successTag(shopifyResponse);
                } else {
                    mTagViewListener.validateCredential(mContext.getString(R.string.problem_calling_api));
                }
            }
            @Override
            public void failure(RetrofitError error)
            {
                mTagViewListener.validateCredential("1 : "+error.getMessage());
            }
        });
    }
}
