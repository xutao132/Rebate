package com.hhxy.redate;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hhxy.redate.fragment.EatPalyFragment;
import com.hhxy.redate.fragment.IndexFragment;
import com.hhxy.redate.fragment.ManageMoneyFragment;
import com.hhxy.redate.fragment.MyFragment;
import com.hhxy.redate.fragment.NetworkFragment;
/**
 * 主页
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioButton rb_index;//首页
    private RadioGroup radioGroup;
    private IndexFragment indexFragment;//首页碎片
    private NetworkFragment networkFragment;//全网商城碎片
    private ManageMoneyFragment manageMoneyFragment;//理财返利碎片
    private EatPalyFragment eatPalyFragment;//吃玩住行碎片
    private MyFragment myFragment;//我的碎片
    private android.app.FragmentManager manager;//碎片管理器
    private android.app.FragmentTransaction transaction;
    private LinearLayout foot_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb_index = (RadioButton) findViewById(R.id.rb_index);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        foot_layout = (LinearLayout) findViewById(R.id.foot_layout);
        rb_index.setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);
        indexFragment = new IndexFragment();
        networkFragment = new NetworkFragment();
        manageMoneyFragment = new ManageMoneyFragment();
        eatPalyFragment = new EatPalyFragment();
        myFragment = new MyFragment();
        //默认加载加载第一个碎片
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.frameLayout,indexFragment,"Tab1");
        transaction.add(R.id.frameLayout,networkFragment,"Tab2");
        transaction.add(R.id.frameLayout,manageMoneyFragment,"Tab3");
        transaction.add(R.id.frameLayout,eatPalyFragment,"Tab4");
        transaction.add(R.id.frameLayout,myFragment,"Tab5");
        transaction.show(indexFragment);
        transaction.hide(networkFragment);
        transaction.hide(manageMoneyFragment);
        transaction.hide(eatPalyFragment);
        transaction.hide(myFragment);
        transaction.commit();
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
       switch (checkedId){
           case R.id.rb_index:
               manager.findFragmentByTag("Tab1");
               transaction = manager.beginTransaction();
               transaction.show(indexFragment);
               transaction.hide(networkFragment);
               transaction.hide(manageMoneyFragment);
               transaction.hide(eatPalyFragment);
               transaction.hide(myFragment);
               transaction.commit();
               break;
           case R.id.rb_network:
               foot_layout.setVisibility(View.GONE);
               manager.findFragmentByTag("Tab2");
               transaction = manager.beginTransaction();
               transaction.show(networkFragment);
               transaction.hide(indexFragment);
               transaction.hide(manageMoneyFragment);
               transaction.hide(eatPalyFragment);
               transaction.hide(myFragment);
               transaction.commit();
               break;
           case R.id.rb_managemoney:
               foot_layout.setVisibility(View.GONE);
               manager.findFragmentByTag("Tab3");
               transaction = manager.beginTransaction();
               transaction.show(manageMoneyFragment);
               transaction.hide(networkFragment);
               transaction.hide(indexFragment);
               transaction.hide(eatPalyFragment);
               transaction.hide(myFragment);
               transaction.commit();
               break;
           case R.id.rb_eatplay:
               manager.findFragmentByTag("Tab4");
               transaction = manager.beginTransaction();
               transaction.show(eatPalyFragment);
               transaction.hide(networkFragment);
               transaction.hide(manageMoneyFragment);
               transaction.hide(indexFragment);
               transaction.hide(myFragment);
               transaction.commit();
               break;
           case R.id.rb_my:
               manager.findFragmentByTag("Tab5");
               transaction = manager.beginTransaction();
               transaction.show(myFragment);
               transaction.hide(networkFragment);
               transaction.hide(manageMoneyFragment);
               transaction.hide(eatPalyFragment);
               transaction.hide(indexFragment);
               transaction.commit();
               break;
           default:
               break;
       }
    }
}
