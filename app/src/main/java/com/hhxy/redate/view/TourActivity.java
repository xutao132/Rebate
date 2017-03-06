package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;
/**
 * 旅行返利
 */
public class TourActivity extends AppCompatActivity {
     private WebView webview_tour;
    private TextView top_title;
    private Constants mConstants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        top_title = (TextView) findViewById(R.id.top_title);
        top_title.setText("旅行返利");
        webview_tour = (WebView) findViewById(R.id.webview_tour);
        webview_tour.loadUrl(mConstants.LvYouFanLiURL);
        webview_tour.getSettings().setJavaScriptEnabled(true);
    }
}
