package com.meiji.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    /**
      *  描述：Toast工具类
      *  时间：2018/7/31 13:33
      **/

    private static Toast mShortToast;
    private static Toast mLongToast;

    public static void showToast(Context context, String message) {
        if (mShortToast == null) {
            mShortToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        mShortToast.setText(message);
        mShortToast.show();

    }

    public static void showToast(String message, Context context) {
        if (mShortToast == null) {
            mShortToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        mShortToast.setText(message);
        mShortToast.show();

    }

    public static void showLongToast(Context context, String message) {
        if (mLongToast == null) {
            mLongToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        mLongToast.setText(message);
        mLongToast.show();
    }

    public static void showLongToast(String message, Context context) {
        if (mLongToast == null) {
            mLongToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        mLongToast.setText(message);
        mLongToast.show();
    }
}