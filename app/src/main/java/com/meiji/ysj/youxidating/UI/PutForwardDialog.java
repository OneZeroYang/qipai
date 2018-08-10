package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.meiji.yangshijie.myapplication_test.View.BaesDialog;

/**
  *  描述：提现
  *  时间：2018/8/9 17:06
  **/
public class PutForwardDialog extends BaesDialog{
    private Context context;
    public PutForwardDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public PutForwardDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected PutForwardDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return 0;
    }

    @Override
    protected void init() {

    }
}
