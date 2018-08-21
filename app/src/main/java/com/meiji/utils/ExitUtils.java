package com.meiji.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

import com.meiji.yangshijie.login.Receiver.NetworkConnectChangedReceiver;

/**
  *  描述：游戏推出时工具类
  *  时间：2018/8/20 8:57
  **/
public class ExitUtils {

    public static void ExitApp(Context context){
        context.getPackageManager().setComponentEnabledSetting(
                new ComponentName("com.meiji.yangshijie.login",
                        NetworkConnectChangedReceiver.class.getName()),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);


        System.exit(0);

    }
}
