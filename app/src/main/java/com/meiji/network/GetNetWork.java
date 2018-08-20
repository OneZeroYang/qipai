package com.meiji.network;

import com.meiji.Interface.GetCallk;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * 描述：一般的get数据请求
 * 时间：2018/8/20 15:27
 **/
public class GetNetWork {


    public static void GetData(String url,final GetCallk getCallk) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        getCallk.onError(e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        getCallk.onResponse( jiexi(response));
                    }
                });

    }
/**
  *  描述：解析
  *  时间：2018/8/20 15:37
  **/
    private static Object jiexi(String response) {

        return null;
    }


}
