package com.meiji.ysj.youxidating.ui;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.DialogUtils;
import com.meiji.ysj.youxidating.adapter.RecordsOfConsumptionApapter;

import java.util.ArrayList;
import java.util.List;

import static com.meiji.utils.IsBeginSoundEffectUtils.Begin;

/**
  *  描述：消费记录
  *  时间：2018/8/9 17:56
  **/
public class RecordsOfConsumptionDialog extends BaesDialog {
    private Context context;
    private ImageView btRecordosfconsumptionXx;
    private RecyclerView rlv_recordosfconsumption_;

    private RecordsOfConsumptionApapter apapter;





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
                Begin(context);
                IsBeginSoundEffectUtils.Begin(context);
                RecordsOfConsumptionDialog.this.dismiss();
            }
        });
        rlv_recordosfconsumption_=findViewById(R.id.rlv_recordosfconsumption_);

        initData();


    }

    /**
      *  描述：初始化数据
      *  时间：2018/8/21 9:34
      **/
    private void initData() {
        List<String[]> list=new ArrayList<>();
        String [] s1=new String[10];
        String [] s2=new String[10];
        String [] s3=new String[10];
        for (int a=0;a<s1.length;a++){
            s1[a]="体育赛事";
            s2[a]="总获得1000金币";
            s3[a]="2018.10.1";
        }
        s2[2]="总损失500金币";
        s2[6]="总损失500金币";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        apapter=new RecordsOfConsumptionApapter(context,list);
        rlv_recordosfconsumption_.setAdapter(apapter);
        rlv_recordosfconsumption_.setLayoutManager(new LinearLayoutManager(context));



    }


    public static void Show(Context context){
        RecordsOfConsumptionDialog recordsOfConsumptionDialog=new RecordsOfConsumptionDialog(context);
        DialogUtils.Show(recordsOfConsumptionDialog);

    }
}
