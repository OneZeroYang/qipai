package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;
import com.meiji.ysj.youxidating.utils.DialogUtils;

/**
  *  描述：完善个人信息
  *  时间：2018/8/10 11:36
  **/

public class PerfectDialog extends BaesDialog implements View.OnClickListener {
    private Button btPerfectXx;
    private EditText edPerfectName;
    private EditText edPerfectId;
    private EditText edPerfectKahao;
    private ImageView imPerfectYinghangtubiao;
    private TextView tvPerfectYinghang;
    private ImageView imPerfectXiala;
    private EditText edPerfectKaihuyinghang;
    private EditText edPerfectKaihushi;
    private Button btPerfectQueding;


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

        btPerfectXx = (Button) findViewById(R.id.bt_perfect_xx);//关闭
        edPerfectName = (EditText) findViewById(R.id.ed_perfect_name);//真实姓名
        edPerfectId = (EditText) findViewById(R.id.ed_perfect_id);//身份证号
        edPerfectKahao = (EditText) findViewById(R.id.ed_perfect_kahao);//银行卡号
        imPerfectYinghangtubiao = (ImageView) findViewById(R.id.im_perfect_yinghangtubiao);//银行图标
        tvPerfectYinghang = (TextView) findViewById(R.id.tv_perfect_yinghang);//那个银行
        imPerfectXiala = (ImageView) findViewById(R.id.im_perfect_xiala);//下拉按钮
        edPerfectKaihuyinghang = (EditText) findViewById(R.id.ed_perfect_kaihuyinghang);//开户银行
        edPerfectKaihushi = (EditText) findViewById(R.id.ed_perfect_kaihushi);//开户行市
        btPerfectQueding = (Button) findViewById(R.id.bt_perfect_queding);//确定

        btPerfectXx.setOnClickListener(this);
        imPerfectXiala.setOnClickListener(this);
        btPerfectQueding.setOnClickListener(this);

    }

    public static void Show(Context context){
        PerfectDialog perfectDialog=new PerfectDialog(context);
        DialogUtils.Show(perfectDialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_perfect_xx://关闭
                this.dismiss();
                break;
            case R.id.im_perfect_xiala://下拉
                break;
            case R.id.bt_perfect_queding://确定
                break;
        }
    }
}
