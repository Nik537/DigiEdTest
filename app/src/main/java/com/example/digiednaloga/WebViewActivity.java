package com.example.digiednaloga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebViewActivity extends AppCompatActivity {
    public static WebView webView;
    //http://digied.si
    //http://digied.si/index.html%3Fpage_id=455.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        WebViewClient webClient = new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http://digied.si/index.html%3Fpage")) {

                    Toast.makeText(WebViewActivity.this, "Mushi mushi", Toast.LENGTH_SHORT).show();
                    return false;
                }

                return super.shouldOverrideUrlLoading(view, url);
            }
        };

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(webClient);

        webView.loadUrl("http://digied.si");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }


    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        } else{
            super.onBackPressed();
        }
    }




}

