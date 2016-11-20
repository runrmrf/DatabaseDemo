package com.mancng.databasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        WebView webView = (WebView) findViewById(R.id.webViewHttp);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        webView.loadData("<html><body><h1>Hi there!</h1><p>How are you?</p></body></html>", "text/html", "UTF-8");

    }
}
