package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.utils.DialogUtils;
import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;

/**
  *  描述：提现
  *  时间：2018/8/9 17:06
  **/
public class PutForwardDialog extends BaesDialog implements View.OnClickListener {
    private Context context;

    private ImageView imPutForwardXx;
    private TextView tvPutForwardBank;
    private ImageView imPutForwardXiala;
    private TextView tvPutForwardMoney;
    private ImageView imPutForwardTixian;


    public PutForwardDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public PutForwardDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected PutForwardDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.putforward_dialog;
    }

    @Override
    protected void init() {

        imPutForwardXx = (ImageView) findViewById(R.id.im_put_forward_xx);//关闭
        tvPutForwardBank = (TextView) findViewById(R.id.tv_put_forward_bank);//银行名称
        imPutForwardXiala = (ImageView) findViewById(R.id.im_put_forward_xiala);//下拉按钮
        tvPutForwardMoney = (TextView) findViewById(R.id.tv_put_forward_money);//可提现或提现的钱
        imPutForwardTixian = (ImageView) findViewById(R.id.im_put_forward_tixian);//确认提现


        imPutForwardXx.setOnClickListener(this);
        imPutForwardXiala.setOnClickListener(this);
        imPutForwardTixian.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im_put_forward_xx://关闭
                this.dismiss();
                break;
            case R.id.im_put_forward_xiala://下拉按钮
                break;
            case R.id.im_put_forward_tixian://确认提现
                /**
                  *  描述：首先要判断用户有没有提现密码
                  *  时间：2018/8/21 14:34
                  **/



                /**
                  *  描述：如果没有则设置，如果有则输入
                  *  时间：2018/8/21 14:34
                  **/


                //没有的情况
                setpassword();


                break;
        }
    }

    /**
      *  描述：设置提现密码
      *  时间：2018/8/21 14:38
      **/
    private void setpassword() {
        //SetPaawordDilog.Show(context);
        PutinPasswordDialog.Show(context);
    }

    public static void Show(Context context){
        PutForwardDialog putForwardDialog=new PutForwardDialog(context);
        DialogUtils.Show(putForwardDialog);
    }
}
