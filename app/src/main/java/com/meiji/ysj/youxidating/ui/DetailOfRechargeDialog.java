package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.utils.DialogUtil;
import com.meiji.utils.DialogUtils;
import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.view.BaesDialog;

/**
  *  描述：充值详情
  *  时间：2018/8/20 17:01
  **/
public class DetailOfRechargeDialog extends BaesDialog{

    private Context context;

    private ImageView imDetailOfChargeXx;
    private TextView tvDetailOfChargeTv1;


    public DetailOfRechargeDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public DetailOfRechargeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DetailOfRechargeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.detailofrecharge_dialog;
    }

    @Override
    protected void init() {

        imDetailOfChargeXx = (ImageView) findViewById(R.id.im_detail_of_charge_xx);
        tvDetailOfChargeTv1 = (TextView) findViewById(R.id.tv_detail_of_charge_tv1);
        String s1="尊敬的 xxxx 你在2018年1月25日 14时59分 由微信充值 ";
        String s2="成功充值100元";
        String s3="已为您自动兑换成金币";

        String s="<font color='#B2E7FF'>"+s1+"</font><font color='#FCB428'>"+s2+"</font></font><font color='#B2E7FF'> "+s3+"</font>";
        tvDetailOfChargeTv1.setText(Html.fromHtml(s));
       // tvDetailOfChargeTv1.setText(s);

        imDetailOfChargeXx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailOfRechargeDialog.this.dismiss();
            }
        });

    }

    public static void Show(Context context){
        DetailOfRechargeDialog detailOfRechargeDialog=new DetailOfRechargeDialog(context);
        DialogUtils.Show(detailOfRechargeDialog);
    }
}
