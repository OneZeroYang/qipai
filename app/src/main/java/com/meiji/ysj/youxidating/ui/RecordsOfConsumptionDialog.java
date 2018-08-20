package com.meiji.ysj.youxidating.ui;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.DialogUtils;

/**
  *  描述：消费记录
  *  时间：2018/8/9 17:56
  **/
public class RecordsOfConsumptionDialog extends BaesDialog {
    private Context context;
    private ImageView btRecordosfconsumptionXx;
    private RecyclerView rlv_recordosfconsumption_;





    public RecordsOfConsumptionDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public RecordsOfConsumptionDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RecordsOfConsumptionDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.recordsofconsumption_dialog;
    }

    @Override
    protected void init() {

        btRecordosfconsumptionXx = (ImageView) findViewById(R.id.bt_recordosfconsumption_xx);
        btRecordosfconsumptionXx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsBeginSoundEffectUtils.Begin(context);
                RecordsOfConsumptionDialog.this.dismiss();
            }
        });
        rlv_recordosfconsumption_=findViewById(R.id.rlv_recordosfconsumption_);


    }


    public static void Show(Context context){
        RecordsOfConsumptionDialog recordsOfConsumptionDialog=new RecordsOfConsumptionDialog(context);
        DialogUtils.Show(recordsOfConsumptionDialog);

    }
}
