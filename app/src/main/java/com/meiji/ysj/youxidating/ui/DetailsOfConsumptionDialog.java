package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.utils.DialogUtils;
import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;

import static com.meiji.utils.IsBeginSoundEffectUtils.Begin;

/**
  *  描述：消费详情
  *  时间：2018/8/21 9:56
  **/
public class DetailsOfConsumptionDialog extends BaesDialog{

    private ImageView imDetailsXx;
    private TextView tvDetailsTv1;


    private Context context;

    public DetailsOfConsumptionDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public DetailsOfConsumptionDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DetailsOfConsumptionDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.detailsofconsumption_dialog;
    }

    @Override
    protected void init() {

        imDetailsXx = (ImageView) findViewById(R.id.im_details_xx);
        tvDetailsTv1 = (TextView) findViewById(R.id.tv_details_tv1);

        String s="<font color='#B2E7FF'>"+"体育赛事"+"\n"+"尊敬的 xxxx"+"\n"+" 您在2018年7月12日 14：52 棋牌游戏中获得 "+"</font><font color='#FEB528'>1000金币</font>";
        //tvDetailsTv1.setText(s);
        tvDetailsTv1.setText(Html.fromHtml(s));
        imDetailsXx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Begin(context);
                DetailsOfConsumptionDialog.this.dismiss();
            }
        });
    }

    public static void Show(Context context){
        DetailsOfConsumptionDialog detailsOfConsumptionDialog=new DetailsOfConsumptionDialog(context);
        DialogUtils.Show(detailsOfConsumptionDialog);
    }








}
