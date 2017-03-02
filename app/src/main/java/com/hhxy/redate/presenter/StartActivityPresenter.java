package com.hhxy.redate.presenter;

import android.util.Log;

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

public class StartActivityPresenter implements IStartActivity {
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
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
