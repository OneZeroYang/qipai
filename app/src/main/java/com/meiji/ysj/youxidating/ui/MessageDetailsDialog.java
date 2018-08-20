package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.DialogUtils;


/**
  *  描述：消息详情
  *  时间：2018/8/17 15:51
  **/
public class MessageDetailsDialog extends BaesDialog implements View.OnClickListener {
    private Context context;
    private ImageView imDetailsXx;


    public MessageDetailsDialog(@NonNull Context context) {
        super(context);

        this.context=context;
    }

    public MessageDetailsDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MessageDetailsDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.message_details_dialog;
    }

    @Override
    protected void init() {
        imDetailsXx = (ImageView) findViewById(R.id.im_details_xx);
        imDetailsXx.setOnClickListener(this);

    }

    public static void Show(Context context){
        MessageDetailsDialog messageDetailsDialog=new MessageDetailsDialog(context);
        DialogUtils.Show(messageDetailsDialog);
    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        this.dismiss();
    }
}
