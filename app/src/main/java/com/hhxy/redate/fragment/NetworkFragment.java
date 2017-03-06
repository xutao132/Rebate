package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.hhxy.redate.R;
import com.hhxy.redate.constant.Constants;

/**
 * Created by Administrator on 2017/3/1.
 * 全网商城
 */

public class NetworkFragment extends Fragment{
    private Constants mConstants;
    private WebView webview;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.network_itme,null);
        
        webview = (WebView) view.findViewById(R.id.webview_newwork);
        webview.loadUrl(mConstants.ShangChengFanLiURL);
        webview.getSettings().setJavaScriptEnabled(true);
        return view;
    }
   ///**当从Activity中解除Fragment的关联时
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
  //当从Activity中解除Fragment的关联时
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
