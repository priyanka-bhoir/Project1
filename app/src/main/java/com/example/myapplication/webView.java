package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class webView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView myweb=findViewById(R.id.webView);
        Intent intent;
        intent=getIntent();
        String url=intent.getStringExtra("web");
        myweb.getSettings().setLoadsImagesAutomatically(true);
        myweb.getSettings().setJavaScriptEnabled(true);
        myweb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myweb.loadUrl(url);

    }
}