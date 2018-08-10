package com.meiji.yangshijie.myapplication_test.View;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.meiji.yangshijie.myapplication_test.R;

/**
  *  描述：DialogView基类  弃用
 *
  *  时间：2018/8/3 11:02
  **/

public abstract class DialogView {

    private Context context;
    private AlertDialog.Builder dialog;
    private  AlertDialog show=null;

    public  DialogView(Context context){
        this.context=context;
        dialog=new AlertDialog.Builder(context);

        initView();
    }

    /**
      *  描述：初始化View
      *  时间：2018/8/3 11:09
      **/
    private void initView(){
        //LayoutInflater inflater=LayoutInflater.from(context);
        LayoutInflater from = LayoutInflater.from(context);
        dialog.setView(getView( from));

        show = dialog.show();

    }

    /**
      *  描述：强制设置布局
      *  时间：2018/8/3 11:09
      **/
    protected abstract View getView(LayoutInflater inflater);

    /**
      *  描述：停止显示
      *  时间：2018/8/3 11:08
      **/
    public void Stop(){
        if (show!=null){
            show.dismiss();
            show=null;
        }
    }

}
