package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;

/**
 * 电影票
 */
public class CinemaTicketActivity extends AppCompatActivity {
    private WebView webview_voitme;
    private TextView top_title;
    private Constants mConstants; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voitme);
    
        top_title = (TextView) findViewById(R.id.top_title);
        top_title.setText("电影票");
        webview_voitme = (WebView) findViewById(R.id.webview_voitme);
        webview_voitme.loadUrl(mConstants.ZhiDeMai);
        webview_voitme.getSettings().setJavaScriptEnabled(true);
    }
}
