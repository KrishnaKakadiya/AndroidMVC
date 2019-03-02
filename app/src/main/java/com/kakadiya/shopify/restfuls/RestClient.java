package com.kakadiya.shopify.restfuls;

import android.content.res.Resources;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;


public class RestClient {

    public RestClient(Resources resources)
    {
        setRetrofit(resources);
    }

    private static final String END_POINT = "https://shopicruit.myshopify.com/admin";
    private static final int TIME_OUT = 30000;

    private void setRetrofit(final Resources resources) {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint(END_POINT);
        builder.setLogLevel(RestAdapter.LogLevel.FULL);
        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
            }
        });
        RestAdapter restAdapter = builder.build();
        restApi = restAdapter.create(RestApi.class);
    }

    private RestApi restApi = null;

    public RestApi getRestAPI()
    {
        return restApi;
    }
}