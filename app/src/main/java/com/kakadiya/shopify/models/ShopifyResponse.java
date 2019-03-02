package com.kakadiya.shopify.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ShopifyResponse implements Serializable{

    public List<ProductsList> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductsList> productsList) {
        this.productsList = productsList;
    }

    @SerializedName("products")
    private List<ProductsList> productsList;
}
