package com.meiji.yangshijie.myapplication_test;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.meiji.yangshijie.myapplication_test.utils.ToastUtils;

/**
  *  描述：ACTIVITY的所有基类
  *  时间：2018/7/31 10:47
  **/

public abstract class BaseActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        super.onCreate(savedInstanceState);
        setContentView(setView());

        init();

    }




/**
  *  描述：这个界面要进行登录状态的判断、、、、、、、判断用户是否一直处于登录状态。。。。。。。若果不是则强制弹窗告知用户
  *  时间：2018/7/31 13:45
  **/




/**
  *  描述：网络状态的判断   在较差的时候自动重连
  *  时间：2018/7/31 13:46
  **/






    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

/**
  *  描述：初始化
  *  时间：2018/7/31 10:55
  **/
    private  void init(){

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制横屏

        SystemService.Isnet(getApplicationContext(), new NetworkCallk() {
            //网络没有问题
            @Override
            public void Onnormal(String s) {
                // ToastUtils.showToast(getResources().getString(R.string.netok),getApplicationContext());
                initViews();
                initData();
            }

            //网络有问题
            @Override
            public void Onerror(String s) {
                ToastUtils.showToast(getResources().getString(R.string.neterror),getApplicationContext());

            }
        });

    }
    protected abstract int setView();
    protected abstract void initViews();
    protected abstract void initData();



}
