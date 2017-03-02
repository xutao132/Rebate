package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhxy.redate.R;

/**
 * Created by Administrator on 2017/3/1.
 */

public class NetworkFragment extends Fragment{
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
        initdate();
        return view;
    }
    private void initdate() {
        findview();
        
    }
    private void findview() {
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
