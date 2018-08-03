package com.meiji.yangshijie.myapplication_test.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.BaseActivity;
import com.meiji.yangshijie.myapplication_test.R;


/**
 * 描述：注册条约
 * 时间：2018/8/2 13:46
 **/
public class AgreementActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout agreementRl;
    private TextView agreementTv1;
    private TextView agreementTv2;
    private ScrollView agreementSv;
    private TextView agreementTv3;
    private Button agreementBt1;

    @Override
    protected int setView() {
        return R.layout.activity_agreement;
    }

    @Override
    protected void initViews() {
        agreementRl = (RelativeLayout) findViewById(R.id.agreement_rl);
        agreementTv1 = (TextView) findViewById(R.id.agreement_tv1);//关闭退出
        agreementTv2 = (TextView) findViewById(R.id.agreement_tv2);//标题
        agreementSv = (ScrollView) findViewById(R.id.agreement_sv);//
        agreementTv3 = (TextView) findViewById(R.id.agreement_tv3);//长文本
        agreementBt1 = (Button) findViewById(R.id.agreement_bt1);//确定按钮
        agreementTv1.setOnClickListener(this);
        agreementBt1.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }
    @Override
    protected void Error(String s) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.agreement_tv1:
                finish();
                break;
            case R.id.agreement_bt1:
                finish();
                break;
        }
    }
}
