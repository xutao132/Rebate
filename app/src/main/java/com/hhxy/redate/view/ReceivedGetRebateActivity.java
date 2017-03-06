package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/6.
 */

public class ReceivedGetRebateActivity extends AppCompatActivity{
    @BindView(R.id.my_webView)
    WebView webView;
    @BindView(R.id.my_top_title)
    TextView my_top_title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        ButterKnife.bind(this);
        my_top_title.setText("收入记录");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Constants.INFO_LEIJI_FANLI);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
    @OnClick(R.id.my_top_back)
    public void Back(View view){
        switch (view.getId()){
            case R.id.my_top_back:
                finish();
                break;
        }
    }
}
