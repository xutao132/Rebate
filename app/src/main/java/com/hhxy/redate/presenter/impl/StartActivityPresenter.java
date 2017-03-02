package com.hhxy.redate.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.hhxy.redate.presenter.IstartActivityPresenter;
import com.hhxy.redate.view.IStartActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/3/1.
 */

public class StartActivityPresenter
        implements IStartActivity {
    private IstartActivityPresenter istartActivityPresenter;

    public StartActivityPresenter(Context context) {
        if (context instanceof IstartActivityPresenter)
        this.istartActivityPresenter = (IstartActivityPresenter) context;
    }

    @Override
    public void getWellCome(String WellComeURL) {
        x.http().get(new RequestParams(WellComeURL), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //Log.e("=====result=", result);
                AnalysisJsonResult(result);
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

    private void AnalysisJsonResult(String result) {
        if (result != null) {
            try {
                JSONObject mJSONObject = new JSONObject(result);
                String info = mJSONObject.getString("info");
                JSONObject data = mJSONObject.getJSONObject("data");
                JSONObject splash_infos = data.getJSONObject("splash_infos");
                String content = splash_infos.getString("content");
                String updatetime = splash_infos.getString("updatetime");
                Log.e("=======info=",info);
                JSONArray jsonArray = new JSONArray(content);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String fgFileUrl = jsonObject.getString("fgFileUrl");
                    Log.e("=======fgFileUrl=",fgFileUrl);
                    istartActivityPresenter.getStartActivityImagePath(fgFileUrl);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
