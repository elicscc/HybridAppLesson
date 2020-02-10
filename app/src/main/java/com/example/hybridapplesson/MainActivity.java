package com.example.hybridapplesson;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //private Button btn1;
    private WebView wv;
//    private View.OnClickListener btnonclickHandler = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(MainActivity.this, "测试一下", Toast.LENGTH_SHORT).show();
//        }
//    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK && wv.canGoBack()){
            wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //btn1=document.getElementById('btn1')
        //btn1 = findViewById(R.id.btn1);
        //btn1.setOnClickListener(btnonclickHandler);
        wv = (WebView) findViewById(R.id.wv);
        wvSetting();
        wvClientSetting();
        wv.loadUrl("https://ccstay.com");
    }

    private void wvClientSetting() {
        MWebViewClient mWebViewClient = new MWebViewClient(wv, getApplicationContext());
        wv.setWebViewClient(mWebViewClient);
        MWebChromeClient mWebChromeClient = new MWebChromeClient(getApplicationContext());
        wv.setWebChromeClient(mWebChromeClient);
    }

    private void wvSetting() {
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setAllowFileAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
    }
}
