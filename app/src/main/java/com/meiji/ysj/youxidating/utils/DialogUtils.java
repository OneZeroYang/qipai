package com.meiji.ysj.youxidating.utils;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

public class DialogUtils {

    /**
      *  描述：显示Dialog
      *  时间：2018/8/9 17:48
      **/
    public static void Show(Object o){

        Dialog dialog= (Dialog) o;

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();

    }
}
