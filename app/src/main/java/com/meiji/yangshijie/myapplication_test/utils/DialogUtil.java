package com.meiji.yangshijie.myapplication_test.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.meiji.yangshijie.myapplication_test.NetworkCallk;
import com.meiji.yangshijie.myapplication_test.R;


/**
 * 描述：对话框工具类
 * 时间：2018/8/1 14:00
 **/
public class DialogUtil {


    private ProgressDialog progressDialog;//进度条对话框
    private Context context;
    private Dialog dialog;//强制下线对话框

    private AlertDialog.Builder NetworkDialog;//网络连接失败对话框

    private AlertDialog.Builder ExitDialog;//是否退出游戏对话框

    private AlertDialog show;


    public DialogUtil(Context context) {
        this.context = context;
    }


    /**
     * 描述：创建进度条对话框
     * 时间：2018/8/1 14:04
     **/
    public void CreateProgressDialg() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("加载中");


    }


    /**
     * 描述：显示进度条对话框
     * 时间：2018/8/1 14:09
     **/
    public void ShowProgressDialg() {
        if (progressDialog != null) {
            //Looper.loop();
            progressDialog.show();

        }

    }

    /**
     * 描述：停止进度条对话框
     * 时间：2018/8/1 14:09
     **/

    public void DismissDialg() {
        if (progressDialog != null) {
            // Looper.loop();
            progressDialog.dismiss();
        }

        if (show != null) {

            show.dismiss();

        }


    }

    /**
     * 描述：创建网络类对话框
     * 时间：2018/8/1 14:17
     **/
    public void CreateNetworkDialog() {

        NetworkDialog = new AlertDialog.Builder(context);
        NetworkDialog.setTitle("网络连接失败！");
        NetworkDialog.setMessage("网络连接失败，请查看的系统设置");
        NetworkDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                /**
                 *  描述：启动WIFI设置界面
                 *  时间：2018/8/2 11:29
                 **/
                Intent it = new Intent();
                ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings");
                it.setComponent(cn);
                context.startActivity(it);


                Log.i("确定", "onClick: ");
            }
        });
        NetworkDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                ExitUtils.ExitApp(context);
                Log.i("取消", "onClick: ");
            }
        });

    }

    /**
     * 描述：显示网络类对话框
     * 时间：2018/8/1 14:27
     **/

    public void ShowNetworkDialog() {
        if (NetworkDialog != null) {
            //Looper.loop();
            show = NetworkDialog.show();

        }
    }


    public void CreateExitDialog() {
        ExitDialog = new AlertDialog.Builder(context);
        ExitDialog.setTitle("是否退出游戏？");
        ExitDialog.setMessage("您确定要退出游戏吗？");
        ExitDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ExitUtils.ExitApp(context);

            }
        });

        ExitDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }

    public void ShowExitDialog() {
        if (ExitDialog != null) {
            ExitDialog.show();
        }
    }


}

