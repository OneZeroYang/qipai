package com.meiji.yangshijie.myapplication_test;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.meiji.yangshijie.myapplication_test.Receiver.NetworkConnectChangedReceiver;
import com.meiji.yangshijie.myapplication_test.utils.NetworkUtils;
import com.meiji.yangshijie.myapplication_test.utils.Variable;

/**
 * 描述：系统服务
 * 时间：2018/7/31 14:00
 **/
public class SystemService extends Service {

    private static NetworkCallk networkCallk;

    private Thread netThread;

    private static Context context = null;

    private NetworkConnectChangedReceiver networkConnectChangedReceiver = new NetworkConnectChangedReceiver();

    public SystemService() {

    }

    public SystemService(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkConnectChangedReceiver);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();

    }

    private void init() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectChangedReceiver, filter);

        /**
         *  描述：网络监听
         *  时间：2018/8/1 15:40
         **/
//        if (context != null) {
//            if (NetworkUtils.isNetworkAvailable(context)) {
//                networkCallk.Onnormal("");
//            } else {
//                networkCallk.Onerror(context.getResources().getString(R.string.neterror));
//            }
//        } else {
//            networkCallk.Onerror(context.getResources().getString(R.string.neterror));
//        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public static void Isnet(Context context, NetworkCallk networkCallk) {
        SystemService.networkCallk = networkCallk;
        SystemService.context = context;
    }


}
