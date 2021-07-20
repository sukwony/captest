package io.phloxcorp.eldo.qa2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

public class NicepayActivity extends AppCompatActivity {

    private WebView mWebView = null;
    private String mPostData = "";

    String encoded(String key, String value) {
        try {
            return "&" + key + "=" + URLEncoder.encode(value, "EUC-KR");
        } catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nicepay);

        mWebView = findViewById(R.id.web_view);
        mWebView.setWebViewClient((new WebViewClient()));
        mWebView.getSettings().setJavaScriptEnabled(true);

        String postData = "Charset=utf-8" + encoded("PayMethod", "VBANK")
                + encoded("MID", "nictest00m")
                + encoded("ReturnURL", "http://whipped-api.phloxcorp.io:1080/nicepay")
                + encoded("GoodsName", "끌라삐엘 콜라겐 아쿠아 크림")
                + encoded("Amt", "38400")
                + encoded("Moid", "27111524-04962003")
                + encoded("EdiDate", "20210719194343")
                + encoded("SignData", "0d0ac6b22b53539347028fa764c07e798f60b6e6ecc216992c8dcc5324fb07eb")
                + encoded("ReqReserved", "http://localhost/asdf");

        mWebView.postUrl("https://web.nicepay.co.kr/v3/v3Payment.jsp", postData.getBytes());
    }
}