package com.hhxy.redate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb_index = (RadioButton) findViewById(R.id.rb_index);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
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
        transaction.replace(R.id.frameLayout,indexFragment);
        transaction.commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
       switch (checkedId){
           case R.id.rb_index:
               transaction = manager.beginTransaction();
               transaction.replace(R.id.frameLayout,indexFragment);
               transaction.commit();
               break;
           case R.id.rb_network:
               transaction = manager.beginTransaction();
               transaction.replace(R.id.frameLayout,networkFragment);
               transaction.commit();
               break;
           case R.id.rb_managemoney:
               transaction = manager.beginTransaction();
               transaction.replace(R.id.frameLayout,manageMoneyFragment);
               transaction.commit();
               break;
           case R.id.rb_eatplay:
               transaction = manager.beginTransaction();
               transaction.replace(R.id.frameLayout,eatPalyFragment);
               transaction.commit();
               break;
           case R.id.rb_my:
               transaction = manager.beginTransaction();
               transaction.replace(R.id.frameLayout,myFragment);
               transaction.commit();
               break;
       }
    }
}
