package com.example.listactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class URLActivity extends AppCompatActivity {
    WebView webView;
    Button ok;
    EditText entry;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.url_demo);

        webView = (WebView) findViewById(R.id.webView);
        ok = findViewById(R.id.ok);
        entry = findViewById(R.id.entry);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = entry.getText().toString();

                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("http://www." + url);

                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
            }
        });
    }
}
