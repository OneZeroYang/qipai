package com.meiji.yangshijie.myapplication_test;

import android.app.Service;

/**
  *  描述：网络连接的回调
  *  时间：2018/7/31 13:58
  **/
public interface NetworkCallk {
    void Onnormal(String s);
    void Onerror(String s);
}
