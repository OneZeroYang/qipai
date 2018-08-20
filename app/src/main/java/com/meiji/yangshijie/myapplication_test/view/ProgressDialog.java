package com.meiji.yangshijie.myapplication_test.view;


import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.utils.DialogUtils;

/**
  *  描述：耗时操作进度对话框
  *  时间：2018/8/15 9:05
  **/
public class ProgressDialog extends BaesDialog{
    private Context context;


    private static ProgressDialog progressDialog=null;



    public ProgressDialog(@NonNull Context context) {
        super(context);
        this.context=context;

    }


    public ProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.progress_dialog;
    }

    @Override
    protected void init() {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay(); //获取屏幕宽高
        Point point = new Point();
        display.getSize(point);

        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes(); //获取当前对话框的参数值
        layoutParams.width = (int) (point.x * 0.4); //宽度设置为屏幕宽度的0.5
        layoutParams.height = (int) (point.y * 0.4); //高度设置为屏幕高度的0.5
//        layoutParams.width = (int) (display.getWidth() * 0.5);
//        layoutParams.height = (int) (display.getHeight() * 0.5);
        window.setAttributes(layoutParams);

    }

    public static void Show(Context context){
        progressDialog=new ProgressDialog(context);
        DialogUtils.Show(progressDialog);

    }

    public static void Stop(){
        progressDialog.dismiss();
    }



}
