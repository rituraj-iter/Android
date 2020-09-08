package com.example.browser;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity2.MSG);
        String load_url = "https://" + url;
        webView = findViewById(R.id.webView);
        if (is_netAvailable()) {
            try {
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(load_url);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(this,"Internet Not Active",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean is_netAvailable(){
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo !=null && activeNetworkInfo.isConnected();
    }
}