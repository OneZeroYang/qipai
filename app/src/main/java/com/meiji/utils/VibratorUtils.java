package com.meiji.utils;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

import com.meiji.ysj.youxidating.GlobalVariable;

/**
  *  描述：控制手机振动的工具类、音量
  *  时间：2018/8/7 9:54
  **/

public class VibratorUtils {
    /**
      *  描述：开启一秒振动
      *  时间：2018/8/7 10:01
      **/
    public static void longbegin(Context context){
        if (GlobalVariable.isvibrator){
            Vibrator vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            vibrator.cancel();
        }

    }

    /**
      *  描述：开启0.5秒的振动
      *  时间：2018/8/7 10:03
      **/
    public static void  shortbegin(Context context){
        Log.i("测试", "shortbegin: ");
        if (GlobalVariable.isvibrator){

            Vibrator vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);
            //vibrator.cancel();
            Log.i("测试通过", "shortbegin: ");
        }

    }
    
    








}
