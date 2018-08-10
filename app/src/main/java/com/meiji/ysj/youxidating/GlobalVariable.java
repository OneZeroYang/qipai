package com.meiji.ysj.youxidating;

import android.content.Context;
import android.media.AudioManager;

/**
  *  描述：全局变量、常量============================必须先初始化init()方法
  *  时间：2018/8/7 10:11
  **/
public class GlobalVariable {
    public final static String SYSTEM_SETUP="APP_SYSTEM_SETUP";//系统设置

    public final static String SP_VIBRATOR="APP_VIBRATOR";//sp缓存记录是否开启振动

    public final static String SP_VOLUME="APP_VOLUME";//SP音量

    public final static String SP_ISMUTE="APP_MUTE";//静音

    public final static String SP_ISSOUND="APP_SOUND";//音效






    /**
     * /////////////////////////////以上为不变的常量，不需要初始化//////////////////////////////
     *
     */

    public static boolean isvibrator=false;//是否开启了振动

    public static int volume=0;//音量

    public static  boolean isMute=false;//是否静音

    public static boolean isSound=false;//是否开启音效




    /**
      *  描述：初始化游戏大厅常量
      *  时间：2018/8/7 10:14
      **/
    public static void init(Context context){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        volume  = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        isvibrator=context.getSharedPreferences(SYSTEM_SETUP,0).getBoolean(SP_VIBRATOR,false);
        //volume=context.getSharedPreferences(SYSTEM_SETUP,0).getInt(SP_VOLUME,5);
        isMute=context.getSharedPreferences(SYSTEM_SETUP,0).getBoolean(SP_ISMUTE,false);

    }


}
