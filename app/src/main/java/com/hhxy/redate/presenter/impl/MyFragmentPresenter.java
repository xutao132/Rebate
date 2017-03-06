package com.hhxy.redate.presenter.impl;

import com.hhxy.redate.presenter.IMyFragmentPresenter;
import com.hhxy.redate.view.IUsableRebateView;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/3/6.
 */

public class MyFragmentPresenter implements IMyFragmentPresenter{
    private IUsableRebateView iUsableRebateView;
    public MyFragmentPresenter(IUsableRebateView iUsableRebateView){
        this.iUsableRebateView = iUsableRebateView;
    }
    @Override
    public void UsableRebateOperate(final String url) {
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String status = jsonObject.getString("status");
                    if(status.equals("5004")){
                       iUsableRebateView.NetWork();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
