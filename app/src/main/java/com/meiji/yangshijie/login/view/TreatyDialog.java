package com.meiji.yangshijie.login.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.meiji.yangshijie.login.R;
import com.meiji.utils.IsBeginSoundEffectUtils;

/**
 *  @ 作用： 开户条约
 *
 *  @ 时间： 2018/8/12 13:54
 */



public class TreatyDialog extends BaesDialog implements View.OnClickListener {

    private Button btTreatyQueding;
    private Context context;
    private ImageView imTreatyXx;


    public TreatyDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public TreatyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected TreatyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.treaty_dialog;
    }

    @Override
    protected void init() {
        btTreatyQueding = (Button) findViewById(R.id.bt_treaty_queding);
        imTreatyXx = (ImageView) findViewById(R.id.im_treaty_xx);

        btTreatyQueding.setOnClickListener(this);
        imTreatyXx.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        this.dismiss();
        RegisterDialog registerDialog=new RegisterDialog(context);
        registerDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        registerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        registerDialog.show();
    }
}
