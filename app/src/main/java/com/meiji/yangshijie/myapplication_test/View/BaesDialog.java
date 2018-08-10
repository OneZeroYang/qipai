package com.meiji.yangshijie.myapplication_test.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

/**
  *  描述：对话框基类
  *  时间：2018/8/8 14:56
  **/

public abstract class BaesDialog extends Dialog {
    private Context context;
    public BaesDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public BaesDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaesDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setView());
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay(); //获取屏幕宽高
        Point point = new Point();
        display.getSize(point);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes(); //获取当前对话框的参数值
        layoutParams.width = (int) (point.x * 0.9); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.9); //高度设置为屏幕高度的0.5
//        layoutParams.width = (int) (display.getWidth() * 0.5);
//        layoutParams.height = (int) (display.getHeight() * 0.5);
        window.setAttributes(layoutParams);
        init();

    }

    protected abstract int setView();
    protected abstract void init();
}
