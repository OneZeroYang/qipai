package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meiji.network.BankNetWork;
import com.meiji.Interface.NetworkCallk;
import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.utils.ToastUtils;
import com.meiji.utils.DialogUtils;
import com.meiji.utils.IDCardUtils;

import java.text.ParseException;

import static com.meiji.utils.FileUtils.TAG;

/**
  *  描述：完善个人信息
  *  时间：2018/8/10 11:36
  **/

public class PerfectDialog extends BaesDialog implements View.OnClickListener, View.OnFocusChangeListener {
    private ImageView btPerfectXx;
    private EditText edPerfectName;
    private EditText edPerfectId;
    private EditText edPerfectKahao;
    private ImageView imPerfectYinghangtubiao;
    private LinearLayout tvPerfectYinghang;
    private ImageView imPerfectXiala;
    private EditText edPerfectKaihuyinghang;
    private EditText edPerfectKaihushi;
    private Button btPerfectQueding;
    private TextView tv_perfect_bank;


    private Context context;
    public PerfectDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public PerfectDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected PerfectDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.perfect_dialog;
    }

    @Override
    protected void init() {
        tv_perfect_bank=findViewById(R.id.tv_perfect_bank);//输入后识别后的银行
        btPerfectXx = (ImageView) findViewById(R.id.bt_perfect_xx);//关闭
        edPerfectName = (EditText) findViewById(R.id.ed_perfect_name);//真实姓名
        edPerfectId = (EditText) findViewById(R.id.ed_perfect_id);//身份证号
        edPerfectKahao = (EditText) findViewById(R.id.ed_perfect_kahao);//银行卡号
        //imPerfectYinghangtubiao = (ImageView) findViewById(R.id.im_perfect_yinghangtubiao);//银行图标
        tvPerfectYinghang = (LinearLayout) findViewById(R.id.tv_perfect_yinghang);//那个银行
      //  imPerfectXiala = (ImageView) findViewById(R.id.im_perfect_xiala);//下拉按钮
        edPerfectKaihuyinghang = (EditText) findViewById(R.id.ed_perfect_kaihuyinghang);//开户银行
        edPerfectKaihushi = (EditText) findViewById(R.id.ed_perfect_kaihushi);//开户行市
        btPerfectQueding = (Button) findViewById(R.id.bt_perfect_queding);//确定

        btPerfectXx.setOnClickListener(this);
  //      imPerfectXiala.setOnClickListener(this);
        btPerfectQueding.setOnClickListener(this);
        edPerfectKahao.setOnFocusChangeListener(this);
        edPerfectId.setOnFocusChangeListener(this);
    }

    public static void Show(Context context){
        PerfectDialog perfectDialog=new PerfectDialog(context);
        DialogUtils.Show(perfectDialog);
    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        switch (view.getId()){
            case R.id.bt_perfect_xx://关闭
                this.dismiss();
                break;
//            case R.id.im_perfect_xiala://下拉
//                new ConfirmPopWindow(context).showAtBottom(tvPerfectYinghang);
//                break;
            case R.id.bt_perfect_queding://确定


               // doing();
                break;
        }
    }

    /**
      *  描述：验证银行卡
      *  时间：2018/8/16 17:38
      **/
    private void VerificationBankCard() {
        String s = edPerfectKahao.getText().toString();
        if (!s.equals("")){
            BankNetWork.getBank(s, new NetworkCallk() {
                @Override
                public void Onnormal(String s) {
                 //   Log.i("反会结果", "Onnormal: "+s);
                   // ToastUtils.showToast(context,""+s);
                    if (s!=null)
                    tv_perfect_bank.setText(s);

                }

                @Override
                public void Onerror(String s) {
                  //  Log.i("错误", "Onerror: "+s);
                    ToastUtils.showToast(context,"错误："+s);

                }
            });

        }else{
            ToastUtils.showToast(context,"请输入卡号");
        }

    }


    /**
      *  描述：失去和获得焦点的事件
      *  时间：2018/8/17 9:43
      **/

    @Override
    public void onFocusChange(View view, boolean b) {

        switch (view.getId()){

            case R.id.tv_perfect_bank://银行卡输入完成
                if (b){

                }else {
                   // Log.i(TAG, "onFocusChange: ");
                    VerificationBankCard();
                }
                break;
            case R.id.ed_perfect_id://身份证输入完成
                if (b){

                }else {
                    VerificationIDCard();
                }

                break;




        }

    }

    /**
      *  描述：验证身份证
      *  时间：2018/8/17 9:47
      **/
    private void VerificationIDCard() {
        String s = edPerfectId.getText().toString();
        if (s.equals("")){
            ToastUtils.showToast(context,"身份证不能为空");

        }else{
            try {
                String s1 = IDCardUtils.IDCardValidate(s);
                if (!s1.equals(""))
                ToastUtils.showToast(context,s1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }
}
