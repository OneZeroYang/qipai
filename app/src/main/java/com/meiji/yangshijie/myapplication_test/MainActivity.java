package com.meiji.yangshijie.myapplication_test;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.Receiver.NetworkConnectChangedReceiver;
import com.meiji.yangshijie.myapplication_test.View.ProgressSeek;
import com.meiji.yangshijie.myapplication_test.utils.DialogUtil;
import com.meiji.yangshijie.myapplication_test.utils.MsgUtils;
import com.meiji.yangshijie.myapplication_test.utils.Variable;
import com.meiji.ysj.youxidating.Game1Activity;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import static android.content.ContentValues.TAG;

/**
 * 描述：启动界面
 * 时间：2018/7/31 10:56
 **/

public class MainActivity extends BaseActivity {


    private ImageView mainLog;
    private TextView mainTv1;
   // private ProgressBar mainPb1;

    private ProgressSeek mainPb1;

    private int SRAT=0;//解决启动2次的常量


    private  Thread thread=null;
    int a=0;

    private static Context context;

    public static Activity activity;



    private DialogUtil dialogUtil = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mainPb1.init((Integer) msg.obj);

                    break;
                case 2:
                    break;
            }
        }
    };

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        /**
          *  描述：初始化OkhttpUtils框架
          *  时间：2018/8/7 11:25
          **/

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);


        /**
         *  描述：启动服务
         *  时间：2018/8/2 13:37
         **/
        startService(new Intent(getApplicationContext(), SystemService.class));
        initNetwork(getApplicationContext());
        initUser();

        /**
         *
         * 在这里判断是否已登录（已有账户）
         *
         */

        activity=this;
        context=MainActivity.this;
        Variable.isOnline = false;
        mainLog = (ImageView) findViewById(R.id.main_log);
        mainTv1 = (TextView) findViewById(R.id.main_tv_1);
//        mainPb1 = (ProgressBar) findViewById(R.id.main_pb_1);
        mainPb1 = (ProgressSeek) findViewById(R.id.main_pb_1);
        initEvet();
        if (thread!=null){
            synchronized (thread){
                thread.start();
            }
        }


        a++;
        Log.i(TAG, "initViews: a==================================================================="+a);


    }

    /**
     * 描述：初始化用户启动是的一些设置及配置
     * 时间：2018/8/2 9:17
     **/
    private void initUser() {
        SharedPreferences sp = getSharedPreferences(Variable.AppUser, 0);
        String name = sp.getString(Variable.name, "");
        String password = sp.getString(Variable.password, "");
        if (!name.trim().equals("") && !password.trim().equals("") && name != null && password != null) {
            //证明用户已登录
        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void Error(String s) {

//        if (dialogUtil==null){
//            dialogUtil=new DialogUtil(MainActivity.this);
//            dialogUtil.CreateNetworkDialog();
//            dialogUtil.ShowNetworkDialog();
//        }
    }

    /**
     * 描述：模拟启动进度条
     * 时间：2018/7/31 11:25
     **/
    public void initEvet() {

         thread=new Thread() {
            @Override
            public void run() {
                for (int a = 0; a < 100; a++) {
                    handler.sendMessage(MsgUtils.getmsg(1, a));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /**
                     *  描述：启动登录界面前应判断用户是否已有账户登录过
                     *  时间：2018/7/31 11:41
                     **/

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (Variable.isNetwork == true) {
                            if (Variable.isOnline == false) {
                                //之前没有登录过
                                if (dialogUtil != null) {
                                    dialogUtil.DismissDialg();
                                    dialogUtil=null;
                                }
                                Log.i(TAG, "run: 11111111111111111111111111111111111111111111111");
                                startLoginActivity();
                            } else {
                                //用户之前已登录
                            }
                        }
                    }
                });

            }
        };


    }

    /**
     * 描述：资源加载完成！启动登录界面
     * 时间：2018/7/31 11:40
     **/
    private void startLoginActivity() {
        if (SRAT==0){
            SRAT++;
            startActivity(new Intent(getApplicationContext(), User_selectionActivity.class));
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.i("", "onDestroy: 界面销毁了");

    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onRestart() {
//        Log.i(TAG, "onRestart: ");
//        initEvet();

        //initEvet();
//        Log.i(TAG, "onResume: ");
        super.onRestart();
    }


    /**
      *  描述：解决横竖屏切换时候重复调用OnCreate方法
      *  时间：2018/8/8 11:03
      **/


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }



    public static void startGameActivity(){
        context.startActivity(new Intent(context, Game1Activity.class));


    }

    public void finishActivity(){
        finish();
    }
}
