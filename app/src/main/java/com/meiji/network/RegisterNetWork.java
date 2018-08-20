package com.meiji.network;

import com.meiji.Interface.RegisterCallk;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
  *  描述：注册逻辑
  *  时间：2018/8/20 14:27
  **/
public class RegisterNetWork {

    public static void Register(String url,String[] data,RegisterCallk registerCallk){
        OkHttpUtils.post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {

                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {


                    }

                    @Override
                    public void onResponse(Object response, int id) {


                    }
                });
    }
}
