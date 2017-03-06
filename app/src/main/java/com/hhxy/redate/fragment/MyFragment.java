package com.hhxy.redate.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hhxy.redate.R;
import com.hhxy.redate.view.IUsableRebateView;
import com.hhxy.redate.view.MessageActivity;
import com.hhxy.redate.view.SetActivity;
import com.hhxy.redate.view.StayRebateActivity;
import com.hhxy.redate.view.TotalRebateActivity;
import com.hhxy.redate.view.UsableRebateActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/1.
 * 我的
 */

public class MyFragment extends Fragment implements IUsableRebateView{
    Unbinder unbind;
    @BindView(R.id.top_title) TextView top_title;//顶部
    @BindView(R.id.huiyuan) LinearLayout huiyuan;//头像，用户名
    @BindView(R.id.image_xinxi) ImageView image_xinxi;//信息
    @BindView(R.id.image_shezhi) ImageView image_shezhi;// 设置
    @BindView(R.id.keyongfanli) LinearLayout keyongfanli;//可用返利
    @BindView(R.id.leijifanli) LinearLayout leijifanli;//累计返利
    @BindView(R.id.daifanli) LinearLayout daifanli;//待返利
    @BindView(R.id.zuijinxiadan) TextView zuijinxiadan;//最近下单
    @BindView(R.id.zuijindaozhang) TextView zuijindaozhang;//最近到账
    @BindView(R.id.daichuli) TextView daichuli;//待处理
    @BindView(R.id.lipei) TextView lipei;//理赔
    @BindView(R.id.dingdan) TextView dingdan;//订单
    @BindView(R.id.fanli) TextView fanli;//返利
    @BindView(R.id.hongbao) TextView hongbao;//红包
    @BindView(R.id.youhuiquan) TextView youhuiquan;//优惠券
    @BindView(R.id.jiasuquan) TextView jiasuquan;//加速券
    @BindView(R.id.zichan) TextView zichan;//资产
    @BindView(R.id.duobao) TextView duobao;//一元夺宝
    @BindView(R.id.youhui) TextView youhui;//优惠福利
    @BindView(R.id.jiangli) TextView jiangli;//邀请有奖
    @BindView(R.id.kefu) TextView kefu;//客服中心
    @BindView(R.id.gengduo) TextView gengduo;//更多
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_fragment,null);
        unbind = ButterKnife.bind(this, view);
        top_title.setText("我的账户");
        return view;
    }
    @OnClick({R.id.huiyuan,R.id.keyongfanli,R.id.image_xinxi,R.id.image_shezhi
    ,R.id.leijifanli,R.id.daifanli})
    public void  MyAccount(View v){
        switch (v.getId()){
            case R.id.huiyuan:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.image_xinxi:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.image_shezhi:
                startActivity(new Intent(getActivity(), SetActivity.class));
                break;
            case R.id.keyongfanli:
                startActivity(new Intent(getActivity(), UsableRebateActivity.class));
                break;
            case R.id.leijifanli:
                startActivity(new Intent(getActivity(), TotalRebateActivity.class));
                break;
            case R.id.daifanli:
                startActivity(new Intent(getActivity(), StayRebateActivity.class));
                break;
        }
    }


    @Override
    public void onDestroyView() {
        unbind.unbind();
        super.onDestroyView();
    }

    @Override
    public void NetWork() {
        Toast.makeText(getActivity(),"网络不给力哦，请稍后重试",Toast.LENGTH_LONG).show();
    }
}
