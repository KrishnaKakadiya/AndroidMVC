package com.kakadiya.shopify.restfuls;

import com.kakadiya.shopify.models.ShopifyResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RestApi
{
    //Get Data
    @GET("/products.json")
    void phrData(@Query("page") String page, @Query("access_token") String accessToken, Callback<ShopifyResponse> callback);

}