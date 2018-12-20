package com.example.administrator.appctct.View.Main;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.appctct.R;


public class PDFActivity extends AppCompatActivity {

    WebView webView;
    String link = "https://www.antennahouse.com/XSLsample/pdf/sample-link_1.pdf";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        webView = findViewById(R.id.wvPDF);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setEnabled(false);
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+link);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,R.anim.hide_view_navigation);
    }
}
