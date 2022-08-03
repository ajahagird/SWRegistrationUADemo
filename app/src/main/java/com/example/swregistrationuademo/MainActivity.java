package com.example.swregistrationuademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView.setWebContentsDebuggingEnabled(true);

        final WebView webView = findViewById(R.id.webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        final WebSettings settings = webView.getSettings();
        final String defaultUA = settings.getUserAgentString();
        settings.setUserAgentString(defaultUA + " MyApp/1.0.0");
        webView.loadUrl("https://incandescent-efficacious-woodwind.glitch.me/");
    }
}