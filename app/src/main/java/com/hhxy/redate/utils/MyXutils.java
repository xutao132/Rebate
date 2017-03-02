package com.hhxy.redate.utils;

import android.app.Application;

import org.xutils.x;


/**
 * Created by Administrator on 2017/3/1.
 */

public class MyXutils extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //x.Ext.init(this);//Xutils初始化
        x.Ext.init(this);
    }
}
