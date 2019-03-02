package com.kakadiya.shopify.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProductsList implements Serializable {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyHTML() {
        return bodyHTML;
    }

    public void setBodyHTML(String bodyHTML) {
        this.bodyHTML = bodyHTML;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public void setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPublishedScope() {
        return publishedScope;
    }

    public void setPublishedScope(String publishedScope) {
        this.publishedScope = publishedScope;
    }

    public String getAdminGraphqlApiID() {
        return adminGraphqlApiID;
    }

    public void setAdminGraphqlApiID(String adminGraphqlApiID) {
        this.adminGraphqlApiID = adminGraphqlApiID;
    }

    public List<VariantsList> getVariantsList() {
        return variantsList;
    }

    public void setVariantsList(List<VariantsList> variantsList) {
        this.variantsList = variantsList;
    }

    public List<ImagesList> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<ImagesList> imagesList) {
        this.imagesList = imagesList;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("body_html")
    private String bodyHTML;

    @SerializedName("vendor")
    private String vendor;

    @SerializedName("product_type")
    private String productType;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("handle")
    private String handle;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("published_at")
    private String publishedAt;

    @SerializedName("template_suffix")
    private String templateSuffix;

    @SerializedName("tags")
    private String tags;

    @SerializedName("published_scope")
    private String publishedScope;

    @SerializedName("admin_graphql_api_id")
    private String adminGraphqlApiID;

    @SerializedName("variants")
    private List<VariantsList> variantsList;

    @SerializedName("images")
    private List<ImagesList> imagesList;

    @SerializedName("image")
    private Image image;
}
