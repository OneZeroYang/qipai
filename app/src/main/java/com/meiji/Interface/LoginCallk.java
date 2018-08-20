package com.meiji.Interface;

import okhttp3.Call;

/**
  *  描述：登录回调
  *  时间：2018/8/20 14:13
  **/
public interface LoginCallk {
    void parseNetworkResponse();
    void onError(Call call, Exception e, int id);
    void onResponse(Object response, int id);
}
