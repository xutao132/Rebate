package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;

/**
 * 返利卡
 */
public class CardActivity extends AppCompatActivity {
   private WebView webview_card;
    private TextView top_title;
    private Constants mConstants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        top_title = (TextView) findViewById(R.id.top_title);
        top_title.setText("返利卡");
        webview_card = (WebView) findViewById(R.id.webview_card);
        webview_card.loadUrl(mConstants.XinYongKaFanLiURL);
        webview_card.getSettings().setJavaScriptEnabled(true);
    }
}
