package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;

/**
 * Created by Administrator on 2017/3/2.
 * 理财返利
 */

public class ManageMoneyFragment extends Fragment{
    private WebView webView;
    private TextView top_title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.managemoney_fragment,null);
        webView = (WebView) view.findViewById(R.id.webView);
        top_title = (TextView) view.findViewById(R.id.top_title);
        top_title.setText("理财返利");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(Constants.LiCaiFanLiURL);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        return view;
    }
}
