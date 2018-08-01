package com.meiji.yangshijie.myapplication_test;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.utils.DialogUtil;
import com.meiji.yangshijie.myapplication_test.utils.MsgUtils;
import com.meiji.yangshijie.myapplication_test.utils.Variable;

/**
  *  描述：启动界面
  *  时间：2018/7/31 10:56
  **/

public class MainActivity extends BaseActivity {

    private ImageView mainLog;
    private TextView mainTv1;
    private ProgressBar mainPb1;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    mainPb1.setProgress((Integer) msg.obj);
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
         *
         * 在这里判断是否已登录（已有账户）
         *
         */
        Variable.isOnline=false;
        mainLog = (ImageView) findViewById(R.id.main_log);
        mainTv1 = (TextView) findViewById(R.id.main_tv_1);
        mainPb1 = (ProgressBar) findViewById(R.id.main_pb_1);
        initEvet();

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void Error(String s) {
        DialogUtil dialogUtil=new DialogUtil(MainActivity.this);
        dialogUtil.CreateNetworkDialog();
        dialogUtil.ShowNetworkDialog();
    }

    /**
      *  描述：模拟启动进度条
      *  时间：2018/7/31 11:25
      **/
    public void initEvet(){

        new Thread(){
            @Override
            public void run() {
              for(int a =0;a<100;a++){
                  handler.sendMessage(MsgUtils.getmsg(1,a));
                  try {
                      Thread.sleep(10);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  /**
                    *  描述：启动登录界面前应判断用户是否已有账户登录过
                    *  时间：2018/7/31 11:41
                    **/
                  if (a>=99){
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              if (Variable.isNetwork==true){
                                  if (Variable.isOnline==false){
                                      //之前没有登录过
                                      startLoginActivity();
                                  }else {
                                      //用户之前已登录
                                  }
                              }
                          }
                      });
                  }
              }

            }
        }.start();
    }

    /**
      *  描述：资源加载完成！启动登录界面
      *  时间：2018/7/31 11:40
      **/
    private void startLoginActivity() {

        startActivity(new Intent(getApplicationContext(),User_selectionActivity.class));
        finish();

    }
}
