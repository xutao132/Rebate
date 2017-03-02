package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhxy.redate.R;

/**
 * Created by Administrator on 2017/3/2.
 * 吃玩住行
 */
public class EatPalyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eatplay_fragment,null);
        return view;
    }
}
