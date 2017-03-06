package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hhxy.redate.R;
import com.hhxy.redate.adapter.myFirstActivityAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 * 首页
 */
public class IndexFragment extends Fragment
        implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private List<ImageView> list;
    private LinearLayout layout;
    private Context context;
    private List<Integer> listpager;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (1 == msg.what) {
                // 获取当前viewpager展示页面的下标
                int curIndex = viewPager.getCurrentItem();// 0,1,2,3
                // 1,2,3,0
                int nextIndex = (curIndex + 1) % list.size();
                // 根据指定下标设置viewpager要展示的页面
                viewPager.setCurrentItem(nextIndex);
                handler.sendEmptyMessageDelayed(1, 6000);
            }
        }

        ;
    };

    private LinearLayout showCase;
    private ImageView SelectImagisGonreOrNot;
    private boolean flag = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.index_fragment, null);
        layout = (LinearLayout) view.findViewById(R.id.layout);
        viewPager = (ViewPager) view.findViewById(R.id.firstActivity_ViewPager);
        SelectImagisGonreOrNot = (ImageView) view.findViewById(R.id.SelectImagisGonreOrNot);
        showCase = (LinearLayout) view.findViewById(R.id.showCase);

        initPage();
        viewPager.setAdapter(new myFirstActivityAdapter(list, getActivity()));
        context = getActivity();
        initIcons(0);
        viewPager.addOnPageChangeListener(this);
        SelectImagisGonreOrNot.setOnClickListener(this);

        return view;
    }

    private void initIcons(int curIndex) {
        ImageView imageView = null;
        Log.e("==========", list.size() + "");
        for (int i = 0; i < list.size(); i++) {
            imageView = new ImageView(context);
            if (curIndex == i) {//如果当前位置就是看到的界面，那么让这个位置的指示小点显示高亮
                imageView.setImageResource(R.mipmap.white);
            } else {
                imageView.setImageResource(R.mipmap.black);
            }
            layout.addView(imageView);
        }
    }

    @Override
    public void onResume() {
            super.onResume();
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    // 初始化viewpager的数据
    private void initPage() {
        list = new ArrayList<>();
        ImageView imageView;
        for (int i = 0; i < 4; i++) {
            imageView = new ImageView(getActivity());
            if (i == 1) {
                imageView.setImageResource(R.mipmap.img001);
            } else if (i == 2) {
                imageView.setImageResource(R.mipmap.img02);
            } else if (i == 3) {
                imageView.setImageResource(R.mipmap.img03);
            } else {
                imageView.setImageResource(R.mipmap.img04);
            }
            list.add(imageView);
        }
        /*listpager.add(R.mipmap.img001);
        listpager.add(R.mipmap.img02);
        listpager.add(R.mipmap.img03);
        listpager.add(R.mipmap.img04);*/
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        //移除layout布局中所有的子视图
        layout.removeAllViews();
        initIcons(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SelectImagisGonreOrNot:
                if (flag){
                    SelectImagisGonreOrNot.setImageResource(R.mipmap.less);
                    showCase.setVisibility(View.VISIBLE);
                    flag = false;
                }else {
                    SelectImagisGonreOrNot.setImageResource(R.mipmap.more_unfold);
                    showCase.setVisibility(View.GONE);
                    flag = true;
                }
                break;
        }

    }
}
