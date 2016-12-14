package com.autohogar.autohogar;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String paginaWeb = "http://192.168.0.107:8000/web/";
    //private String paginaWeb = "http://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        webView = (WebView) this.findViewById(R.id.activity_main_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(paginaWeb);
        //webView.setWebViewClient(new WebViewClient());
        //webView.setWebViewClient(new MyAppWebViewClient());


    }

    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
