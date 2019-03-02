package com.kakadiya.shopify.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VariantsList implements Serializable {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getInventoryPolicy() {
        return inventoryPolicy;
    }

    public void setInventoryPolicy(String inventoryPolicy) {
        this.inventoryPolicy = inventoryPolicy;
    }

    @SerializedName("id")
    private long id;

    @SerializedName("product_id")
    private long productID;

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private String price;

    @SerializedName("position")
    private int position;

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    @SerializedName("inventory_quantity")
    private int inventoryQuantity;

    @SerializedName("sku")
    private String sku;

    @SerializedName("inventory_policy")
    private String inventoryPolicy;
}
