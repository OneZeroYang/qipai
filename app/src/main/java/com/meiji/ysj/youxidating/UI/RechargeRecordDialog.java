package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;
import com.meiji.ysj.youxidating.utils.DialogUtils;

/**
  *  描述：充值记录
  *  时间：2018/8/9 17:15
  **/
public class RechargeRecordDialog extends BaesDialog implements View.OnClickListener {

    private Button btRecordXx;


    private Context context;
    public RechargeRecordDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public RechargeRecordDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RechargeRecordDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.record_dialog;
    }

    @Override
    protected void init() {

        btRecordXx = (Button) findViewById(R.id.bt_record_xx);
        btRecordXx.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_record_xx:
                this.dismiss();
                break;
        }
    }


    public static void Show(Context context){
        RechargeRecordDialog rechargeRecordDialog=new RechargeRecordDialog(context);
        DialogUtils.Show(rechargeRecordDialog);
    }
}
