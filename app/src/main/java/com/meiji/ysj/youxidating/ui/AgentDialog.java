package com.meiji.ysj.youxidating.ui;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.ysj.youxidating.Game1Activity;
import com.meiji.Interface.FileCallk;
import com.meiji.Interface.PermissionsCallk;
import com.meiji.utils.CompressUtils;
import com.meiji.utils.DialogUtils;
import com.meiji.utils.PermissionsUtils;

import java.io.File;

/**
  *  描述：申请成为代理
  *  时间：2018/8/13 9:07
  **/

public class AgentDialog extends BaesDialog implements View.OnClickListener {

    private ImageView imAgentXx;
    private EditText edAgentName;
    private EditText edAgentPhone;
    private static ImageView imAgentZhengmian;
    private static ImageView imAgentFanmian;
    private ImageView imAgentTijiao;
    private ImageView imAgentQuxiao;
    private static Activity activity;
    private static Context context;


    public AgentDialog(@NonNull Context context) {

        super(context);
        AgentDialog.context=context;
    }

    public AgentDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AgentDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.agent_dialog;
    }

    @Override
    protected void init() {

        imAgentXx = (ImageView) findViewById(R.id.im_agent_xx);//关闭
        edAgentName = (EditText) findViewById(R.id.ed_agent_name);//真实姓名
        edAgentPhone = (EditText) findViewById(R.id.ed_agent_phone);//手机号
        imAgentZhengmian = (ImageView) findViewById(R.id.im_agent_zhengmian);//身份证正面
        imAgentFanmian = (ImageView) findViewById(R.id.im_agent_fanmian);//身份证反面
        imAgentTijiao = (ImageView) findViewById(R.id.im_agent_tijiao);//提交
        imAgentQuxiao = (ImageView) findViewById(R.id.im_agent_quxiao);//取消

        imAgentXx.setOnClickListener(this);
        imAgentZhengmian.setOnClickListener(this);
        imAgentFanmian.setOnClickListener(this);
        imAgentTijiao.setOnClickListener(this);
        imAgentQuxiao.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        switch (view.getId()){
            case R.id.im_agent_xx://关闭
                this.dismiss();
                break;
            case R.id.im_agent_zhengmian:////身份证正面
                initPermissions(1);
                break;
            case R.id.im_agent_fanmian://身份证反面
                initPermissions(2);
                break;
            case R.id.im_agent_tijiao://提交
                break;
            case R.id.im_agent_quxiao://取消
                this.dismiss();
                break;
        }
    }

    /**
      *  描述：初始化动态权限申请
      *  时间：2018/8/14 10:43
      **/
    private void initPermissions(final int a) {
        PermissionsUtils.Photograph(activity, new PermissionsCallk() {
            @Override
            public void Success() {
                if (a==1){
                    Game1Activity.startMatisse1(activity);
                }else if (a==2){
                    Game1Activity.startMatisse2(activity);
                }

            }

            @Override
            public void Error() {

            }
        });
    }


    public static void Show(Context context, Activity activity){
        AgentDialog.activity=activity;
        AgentDialog agentDialog=new AgentDialog(context);
        DialogUtils.Show(agentDialog);

    }

    /**
      *  描述：更新正面身份证
      *  时间：2018/8/14 14:31
      **/
    public static void upview1(Uri url){

        Glide
                .with(context)
                .load(url)
                .override(150, 100) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(imAgentZhengmian);
        CompressUtils.getFile(url, context, new FileCallk() {
            @Override
            public void Success(File file) {


                Log.i("成功", "Success: "+file.getAbsolutePath());

            }

            @Override
            public void Error(Throwable s) {

            }

            @Override
            public void onStart() {

            }
        });



        /**
          *  描述：更新反面身份证
          *  时间：2018/8/14 14:31
          **/
    }
    public static void upview2(Uri url){

        Glide
                .with(context)
                .load(url)
                .override(150, 100) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(imAgentFanmian);
        CompressUtils.getFile(url, context, new FileCallk() {
            @Override
            public void Success(File file) {
                Log.i("成功", "Success: "+file.getAbsolutePath());
            }

            @Override
            public void Error(Throwable s) {

            }

            @Override
            public void onStart() {

            }
        });




    }
}
