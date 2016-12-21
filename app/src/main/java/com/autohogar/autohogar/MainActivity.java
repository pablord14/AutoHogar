package com.autohogar.autohogar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.wifi.WifiManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String paginaWeb = "http://192.168.0.106:8000/web/";
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //Conexion c = new Conexion();
        //c.start();

        webView = (WebView) this.findViewById(R.id.activity_main_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebView myWebView = (WebView) findViewById(R.id.activity_main_webview);
        myWebView.setWebViewClient(new WebViewClient());

        webView.loadUrl(getPaginaWeb());

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                //fetchTimelineAsync(0);

                    final Intent intent = getIntent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }



    public String getPaginaWeb() {return paginaWeb;}

    public void setPaginaWeb(String paginaWeb) {this.paginaWeb = paginaWeb;}
}
