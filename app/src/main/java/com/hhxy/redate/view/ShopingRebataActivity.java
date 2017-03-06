package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;
/**
 * 商城返利
        */
public class ShopingRebataActivity extends AppCompatActivity {
    private WebView webview_group;
    private TextView top_title;
    private Constants mConstants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        
        top_title = (TextView) findViewById(R.id.top_title);
        top_title.setText("商城返利");
        webview_group = (WebView) findViewById(R.id.webview_group);
        webview_group.loadUrl(mConstants.ShangChengFanLiURL);
        webview_group.getSettings().setJavaScriptEnabled(true);
    }
}
