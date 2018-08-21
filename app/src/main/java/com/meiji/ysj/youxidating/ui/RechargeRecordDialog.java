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
import com.meiji.ysj.youxidating.adapter.RechargeRecyclerViewAdapter;
import com.meiji.ysj.youxidating.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
  *  描述：充值记录
  *  时间：2018/8/9 17:15
  **/
public class RechargeRecordDialog extends BaesDialog implements View.OnClickListener {

    private ImageView btRecordXx;
    private RecyclerView rlv_record_list;
    private RechargeRecyclerViewAdapter adapter;


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
        rlv_record_list=findViewById(R.id.rlv_record_list);
        btRecordXx = (ImageView) findViewById(R.id.bt_record_xx);
        btRecordXx.setOnClickListener(this);

        adapter=new RechargeRecyclerViewAdapter(context, initData());

        rlv_record_list.setAdapter(adapter);
        rlv_record_list.setLayoutManager(new LinearLayoutManager(context));

    }

    /**
      *  描述：初始化List数据
      *  时间：2018/8/20 16:36
     **/
    private List<String[]> initData() {
        List<String[]> list=new ArrayList<>();
        String[] s = new String[3];
        for (int b = 0; b < 3; b++) {
            s[b] = "100元";
        }
        list.add(s);
        String[] s1 = new String[3];
        for (int b = 0; b < 3; b++) {
            s1[b] = "充值成功！";
        }
        s1[1]="充值失败!";
        list.add(s1);
        String[] s2 = new String[3];
        for (int b = 0; b < 3; b++) {
            s2[b] = "2018.1.1";
        }
        list.add(s2);
        return list;
    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
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
