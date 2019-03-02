package com.kakadiya.shopify.presenter;

public interface TagViewListener {
    void validateCredential(String message);
    void successTag(Object objectType);

    String getAccessToken();
    String getPage();

}
