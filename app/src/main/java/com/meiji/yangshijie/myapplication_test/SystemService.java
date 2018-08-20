package com.meiji.yangshijie.myapplication_test;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.meiji.Interface.NetworkCallk;
import com.meiji.yangshijie.myapplication_test.Receiver.NetworkConnectChangedReceiver;
import com.meiji.ysj.youxidating.GlobalVariable;

import java.io.IOException;

/**
 * 描述：系统服务
 * 时间：2018/7/31 14:00
 **/
public class SystemService extends Service {

    private static NetworkCallk networkCallk;

    private Thread netThread;

    private static Context context = null;

    private NetworkConnectChangedReceiver networkConnectChangedReceiver = new NetworkConnectChangedReceiver();

    private MediaPlayer mediaPlayer1;//按钮音效

    private MediaPlayer mediaPlayer2;//背景音乐

    AssetFileDescriptor fd = null;
    AssetFileDescriptor fd1= null;

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
        if (mediaPlayer1!=null){

        }
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String action = intent.getStringExtra("action");
        if (action==null){
            return super.onStartCommand(intent, flags, startId);
        }
        if (action.equals(GlobalVariable.BeginSound)){
            //开启音效
            if (mediaPlayer1!=null){
                mediaPlayer1.start();
            }
        }else if (action.equals(GlobalVariable.ClosesSound)){

            //关闭音效
        } else if (action.equals(GlobalVariable.BeginMusic)){
            //开启音乐

            if (mediaPlayer2!=null){
                Log.i("是谁", "onStartCommand: ");
                try {
                    initSoundEffect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mediaPlayer2.start();
            }
        }else if (action.equals(GlobalVariable.ClosesMusic)){
            //关闭音乐
            if (mediaPlayer2!=null){
                mediaPlayer2.pause();
            }
        }else if (action.equals("begin")){
            //启动
            initSoundEffect();
        }


        return super.onStartCommand(intent, flags, startId);

    }
/**
  *  描述：初始化音效
  *  时间：2018/8/20 10:09
  **/
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initSoundEffect() {
        if (mediaPlayer1==null){
            mediaPlayer1=new MediaPlayer();

        }
        if (mediaPlayer2==null){
            mediaPlayer2=new MediaPlayer();
        }


            try {
               // Log.i("测试", "initSoundEffect: ");
                fd = getAssets().openFd("anniu.wav");
                fd1 = getAssets().openFd("datingyinfyue.mp3");
                mediaPlayer2.setDataSource(fd1);
                mediaPlayer2.setLooping(true);
                mediaPlayer2.prepare() ;

                mediaPlayer1.setDataSource(fd);
                mediaPlayer1.prepare() ;
            } catch (Exception e) {
                e.printStackTrace();
            }



    }

    public static void Isnet(Context context, NetworkCallk networkCallk) {
        SystemService.networkCallk = networkCallk;
        SystemService.context = context;
    }


}
