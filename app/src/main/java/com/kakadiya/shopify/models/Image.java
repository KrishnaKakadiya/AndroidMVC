package com.kakadiya.shopify.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image  implements Serializable {

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @SerializedName("id")
    private long id;

    @SerializedName("product_id")
    private long productID;

    @SerializedName("position")
    private int position;

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("src")
    private String src;
}
