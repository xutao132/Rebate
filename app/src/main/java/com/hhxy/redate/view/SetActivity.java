package com.hhxy.redate.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hhxy.redate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/6.
 */

public class SetActivity extends AppCompatActivity{
    @BindView(R.id.my_top_title)
    TextView my_top_title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        ButterKnife.bind(this);
        my_top_title.setText("设置");
    }
}
