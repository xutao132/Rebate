package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;

/**
 * 饿了吗
 */
public class TakeActivity extends AppCompatActivity {
    private WebView webview_take;
    private TextView top_title;
    private Constants mConstants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take);
        
        top_title = (TextView) findViewById(R.id.top_title);
        top_title.setText("饿了么");
        webview_take = (WebView) findViewById(R.id.webview_take);
        webview_take.loadUrl(mConstants.HaichuFang);
        webview_take.getSettings().setJavaScriptEnabled(true);
    }
}
