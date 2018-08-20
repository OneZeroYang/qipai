package com.meiji.utils;


import android.content.Context;
import android.content.Intent;

import com.meiji.yangshijie.myapplication_test.SystemService;
import com.meiji.ysj.youxidating.GlobalVariable;

/**
  *  描述：音效触发工具类
  *  时间：2018/8/20 10:44
  **/
public class IsBeginSoundEffectUtils {

    public static void Begin(Context context){
        if (GlobalVariable.isSound){
            Intent intent=new Intent(context, SystemService.class);
            intent.putExtra("action", GlobalVariable.BeginSound);
            context.startService(intent);
        }

    }

    public static void IsMusic(Context context){
        if (!GlobalVariable.isMute){
            Intent intent=new Intent(context, SystemService.class);
            intent.putExtra("action", GlobalVariable.BeginMusic);
            context.startService(intent);
        }
    }


    public static void CloseMusic(Context context){

            Intent intent=new Intent(context, SystemService.class);
            intent.putExtra("action", GlobalVariable.ClosesMusic);
            context.startService(intent);

    }



}
