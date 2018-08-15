package com.meiji.yangshijie.myapplication_test.utils;

import android.os.Message;
/**
  *  描述：消息工具类
  *  时间：2018/7/31 14:28
  **/

public class MsgUtils {
    public static Message getmsg(int what,Object o){
//        if (what<=0||o==null){      | BUG
//            return null;            |
//        }                           |
        Message msg=new Message();
        msg.what=what;
        msg.obj=o;
        return msg;
    }
}
