package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;

/**
  *  描述：充值提现
  *  时间：2018/8/9 15:40
  **/
public class RechargePutForwardDialog extends BaesDialog implements View.OnClickListener {

    private Button btRechargeXx;
    private TextView tvRechargeJingbi;
    private Button btRechargeTixian;
    private EditText edRechargeEd;
    private TextView tvRechargeWeixing;
    private TextView tvRechargeZhifubao;
    private TextView tvRechargeYinghangka;


    private Context context;
    public RechargePutForwardDialog(@NonNull Context context) {
        super(context);
        this.context=context;

    }

    public RechargePutForwardDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RechargePutForwardDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.rechargeputforward_dialog;
    }

    @Override
    protected void init() {

        btRechargeXx = (Button) findViewById(R.id.bt_recharge_xx);//关闭
        tvRechargeJingbi = (TextView) findViewById(R.id.tv_recharge_jingbi);//金币
        btRechargeTixian = (Button) findViewById(R.id.bt_recharge_tixian);//提现
        edRechargeEd = (EditText) findViewById(R.id.ed_recharge_ed);//输入的充值金额
        tvRechargeWeixing = (TextView) findViewById(R.id.tv_recharge_weixing);//微信充值
        tvRechargeZhifubao = (TextView) findViewById(R.id.tv_recharge_zhifubao);//支付宝充值
        tvRechargeYinghangka = (TextView) findViewById(R.id.tv_recharge_yinghangka);//银行卡充值

        btRechargeXx.setOnClickListener(this);
        btRechargeTixian.setOnClickListener(this);
        tvRechargeWeixing.setOnClickListener(this);
        tvRechargeZhifubao.setOnClickListener(this);
        tvRechargeYinghangka.setOnClickListener(this);


    }

    public static void Show(Context context){
        RechargePutForwardDialog rechargePutForwardDialog=new RechargePutForwardDialog(context);
        rechargePutForwardDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        rechargePutForwardDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        rechargePutForwardDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_recharge_xx://关闭
                this.dismiss();
                break;
            case R.id.bt_recharge_tixian://提现
                break;
            case R.id.tv_recharge_weixing://微信充值
                break;
            case R.id.tv_recharge_zhifubao://支付宝充值
                break;
            case R.id.tv_recharge_yinghangka://银行卡充值
                break;
        }
    }
}
