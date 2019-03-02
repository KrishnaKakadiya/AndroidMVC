package com.kakadiya.shopify.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kakadiya.shopify.R;
import com.kakadiya.shopify.constant.Constant;

public class SplashView extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_view);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashView.this, TagView.class);
                startActivity(intent);
                finish();
            }
        }, Constant.SPLASH_TIMEOUT);
    }
}