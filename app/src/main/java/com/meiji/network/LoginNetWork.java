package com.meiji.network;

import com.meiji.Interface.LoginCallk;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
  *  描述：登录注册网络请求
  *  时间：2018/8/20 14:00
  **/
public class LoginNetWork {

    /**
      *  描述：登录逻辑
      *  时间：2018/8/20 14:02
     *
     *  url:地址
     *
     *  data:请求参数
     *
      **/
    public static void login(String url, String[] data, final LoginCallk loginCallk){

        OkHttpUtils.post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        loginCallk.parseNetworkResponse();
                        return null;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        loginCallk.onError(call,e,id);

                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        loginCallk.onResponse(response,id);

                    }
                });

    }
}
