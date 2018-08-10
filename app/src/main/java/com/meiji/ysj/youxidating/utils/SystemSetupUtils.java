package com.meiji.ysj.youxidating.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.meiji.ysj.youxidating.GlobalVariable;

/**
  *  描述：系统设置工具类
  *  时间：2018/8/7 10:15
  **/

public class SystemSetupUtils {

    /**
      *  描述：设置音量
      *  时间：2018/8/7 10:31
      **/
    public static void setvolume(Context context,int a){
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalVariable.SYSTEM_SETUP, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SharedPreferences.Editor editor = edit.putInt(GlobalVariable.SP_VOLUME, a);
        GlobalVariable.volume=a;

    }

    /**
      *  描述：设置是否振动===
      *  时间：2018/8/7 10:38
      **/

    public static void setisvibrator(Context context,boolean b){
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalVariable.SYSTEM_SETUP, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SharedPreferences.Editor editor = edit.putBoolean(GlobalVariable.SP_VIBRATOR, b);
        GlobalVariable.isvibrator=b;

    }
    /**
      *  描述：设置是否静音、、是否静音可查询  GlobalVariable.isMute
      *  时间：2018/8/7 11:03
      **/

    public static void setisMute(Context context,boolean b){
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalVariable.SYSTEM_SETUP, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SharedPreferences.Editor editor = edit.putBoolean(GlobalVariable.SP_ISMUTE, b);
        GlobalVariable.isMute=b;
    }

    /**
      *  描述：设置是否开启音效
      *  时间：2018/8/10 15:50
      **/

    public static void setisSound(Context context,boolean b){
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalVariable.SYSTEM_SETUP, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(GlobalVariable.SP_ISSOUND,b);
        GlobalVariable.isSound=b;
    }


}
