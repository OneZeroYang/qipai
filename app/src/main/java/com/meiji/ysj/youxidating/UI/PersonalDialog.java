package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.User_selectionActivity;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;
import com.meiji.yangshijie.myapplication_test.View.RegisterDialog;

/**
  *  描述：个人中心
  *  时间：2018/8/9 13:59
  **/

public class PersonalDialog extends BaesDialog implements View.OnClickListener {
    private Context context;

    private ImageView imPersonalTouxiang;
    private TextView tvPersonalName;
    private TextView tvPersonalId;
    private TextView tvPersonalMoney;
    private RelativeLayout rlPersonalXx;
    private TextView tvPersonalCongzhitixian;
    private TextView tvPersonalLianxikefu;
    private TextView tvPersonalWanshangerenzilian;
    private TextView tvPersonalChongzhijilu;
    private TextView tvPersonalXiaofeijilu;
    private Button tbPersonalBtdaili;


    public PersonalDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public PersonalDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected PersonalDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.personaldialog;
    }

    @Override
    protected void init() {

        imPersonalTouxiang = (ImageView) findViewById(R.id.im_personal_touxiang);//头像
        tvPersonalName = (TextView) findViewById(R.id.tv_personal_name);//昵称
        tvPersonalId = (TextView) findViewById(R.id.tv_personal_id);//id
        tvPersonalMoney = (TextView) findViewById(R.id.tv_personal_money);//金币
        rlPersonalXx = (RelativeLayout) findViewById(R.id.rl_personal_xx);//关闭
        tvPersonalCongzhitixian = (TextView) findViewById(R.id.tv_personal_congzhitixian);//充值提现
        tvPersonalLianxikefu = (TextView) findViewById(R.id.tv_personal_lianxikefu);//联系客服
        tvPersonalWanshangerenzilian = (TextView) findViewById(R.id.tv_personal_wanshangerenzilian);//完善个人信息
        tvPersonalChongzhijilu = (TextView) findViewById(R.id.tv_personal_chongzhijilu);//充值记录
        tvPersonalXiaofeijilu = (TextView) findViewById(R.id.tv_personal_xiaofeijilu);//消费记录
        tbPersonalBtdaili = (Button) findViewById(R.id.tb_personal_btdaili);//申请代理


        imPersonalTouxiang.setOnClickListener(this);
        rlPersonalXx.setOnClickListener(this);
        tvPersonalCongzhitixian.setOnClickListener(this);
        tvPersonalLianxikefu.setOnClickListener(this);
        tvPersonalWanshangerenzilian.setOnClickListener(this);
        tvPersonalChongzhijilu.setOnClickListener(this);
        tvPersonalXiaofeijilu.setOnClickListener(this);
        tbPersonalBtdaili.setOnClickListener(this);


    }

    /**
      *  描述：开始显示
      *  时间：2018/8/9 14:57
      **/
    public static void Show(Context context){
        PersonalDialog personalDialog=new PersonalDialog(context);
        personalDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        personalDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        personalDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im_personal_touxiang://头像
                break;
            case R.id.rl_personal_xx://关闭
                this.dismiss();
                break;
            case R.id.tv_personal_congzhitixian://充值提现
                RechargePutForwardDialog.Show(context);
                break;
            case R.id.tv_personal_lianxikefu://联系客服
                break;
            case R.id.tv_personal_wanshangerenzilian://完善个人信息
                PerfectDialog.Show(context);
                break;
            case R.id.tv_personal_chongzhijilu://充值记录
                RechargeRecordDialog.Show(context);
                break;
            case R.id.tv_personal_xiaofeijilu://消费记录
                RecordsOfConsumptionDialog.Show(context);
                break;
            case R.id.tb_personal_btdaili://申请代理
                break;
        }

    }
}
