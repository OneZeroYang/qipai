package com.meiji.yangshijie.myapplication_test;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.meiji.yangshijie.myapplication_test.utils.NetworkUtils;

/**
  *  描述：系统服务
  *  时间：2018/7/31 14:00
  **/
public class SystemService extends Service {

    private static Context context=null;
    public SystemService(Context context){
        this.context=context;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public static void Isnet(Context context,NetworkCallk networkCallk){

        if (context!=null){
            if (NetworkUtils.isNetworkAvailable(context)){
                networkCallk.Onnormal("");
            }else {
                networkCallk.Onerror(context.getResources().getString(R.string.neterror));
            }
        }else {
            networkCallk.Onerror(context.getResources().getString(R.string.neterror));
        }

    }

}
