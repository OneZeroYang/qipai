package com.meiji.ysj.youxidating.UI;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;
import com.meiji.yangshijie.myapplication_test.utils.DialogUtil;
import com.meiji.ysj.youxidating.utils.DialogUtils;

/**
  *  描述：消费记录
  *  时间：2018/8/9 17:56
  **/
public class RecordsOfConsumptionDialog extends BaesDialog {
    private Context context;
    private Button btRecordosfconsumptionXx;


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
        btRecordosfconsumptionXx = (Button) findViewById(R.id.bt_recordosfconsumption_xx);
        btRecordosfconsumptionXx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecordsOfConsumptionDialog.this.dismiss();
            }
        });

    }


    public static void Show(Context context){
        RecordsOfConsumptionDialog recordsOfConsumptionDialog=new RecordsOfConsumptionDialog(context);
        DialogUtils.Show(recordsOfConsumptionDialog);

    }
}
