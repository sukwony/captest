package io.phloxcorp.eldo.qa2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NicepayActivity extends AppCompatActivity {

    private WebView mWebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nicepay);

        mWebView = findViewById(R.id.web_view);
        mWebView.setWebViewClient((new WebViewClient()));
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.daum.net");
    }
}