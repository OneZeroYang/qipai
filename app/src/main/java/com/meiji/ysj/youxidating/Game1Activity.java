package com.meiji.ysj.youxidating;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meiji.yangshijie.myapplication_test.BaseActivity;
import com.meiji.yangshijie.myapplication_test.MainActivity;
import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.ysj.youxidating.UI.NewsDialog;
import com.meiji.ysj.youxidating.UI.PersonalDialog;
import com.meiji.ysj.youxidating.UI.SetUpDialog;

public class Game1Activity extends BaseActivity implements View.OnClickListener {


    private static final String TAG ="Game1Activity" ;
    private ImageView gameImTouxiang;
    private TextView gameTvName;
    private TextView gameTvId;
    private TextView gameTvMoney;
    private TextView gameTvDonggao;
    private FrameLayout gameImZ1;
    private TextView gameTvGonggao1;
    private FrameLayout gameImZ2;
    private FrameLayout gameImL2;
    private FrameLayout gameImL1;
    private FrameLayout gameImR1;
    private FrameLayout gameImR2;
    private LinearLayout gameLlXiaoxi;
    private LinearLayout gameLlGerenzhongxing;
    private LinearLayout gameLlSehzhi;





    @Override
    protected int setView() {
        return R.layout.activity_game1;
    }

    @Override
    protected void initViews() {
        gameImTouxiang = (ImageView) findViewById(R.id.game_im_touxiang);//头像
        gameTvName = (TextView) findViewById(R.id.game_tv_name);//昵称
        gameTvId = (TextView) findViewById(R.id.game_tv_id);//ID
        gameTvMoney = (TextView) findViewById(R.id.game_tv_money);//金币;
        gameTvDonggao = (TextView) findViewById(R.id.game_tv_donggao);//消息通知
        gameImZ1 = (FrameLayout) findViewById(R.id.game_im_z1);//站内公告
        gameTvGonggao1 = (TextView) findViewById(R.id.game_tv_gonggao1);//公告内容
        gameImZ2 = (FrameLayout) findViewById(R.id.game_im_z2);//电子游戏
        gameImL2 = (FrameLayout) findViewById(R.id.game_im_l2);//彩票游戏
        gameImL1 = (FrameLayout) findViewById(R.id.game_im_l1);//真人咨询
        gameImR1 = (FrameLayout) findViewById(R.id.game_im_r1);//体育赛事
        gameImR2 = (FrameLayout) findViewById(R.id.game_im_r2);//棋牌游戏
        gameLlXiaoxi = (LinearLayout) findViewById(R.id.game_ll_xiaoxi);//消息
        gameLlGerenzhongxing = (LinearLayout) findViewById(R.id.game_ll_gerenzhongxing);//个人中心
        gameLlSehzhi = (LinearLayout) findViewById(R.id.game_ll_sehzhi);//设置

        gameImTouxiang.setOnClickListener(this);
        gameImZ1.setOnClickListener(this);
        gameImZ2.setOnClickListener(this);
        gameImL2.setOnClickListener(this);
        gameImL1.setOnClickListener(this);
        gameImR1.setOnClickListener(this);
        gameImR2.setOnClickListener(this);
        gameLlXiaoxi.setOnClickListener(this);
        gameLlGerenzhongxing.setOnClickListener(this);
        gameLlSehzhi.setOnClickListener(this);





    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.game_im_touxiang://头像
                break;
            case R.id.game_im_z1://站内公告
                Log.i(TAG, "onClick: 站内公告");
                break;
            case R.id.game_im_z2://电子游戏
                Log.i(TAG, "onClick: 电子游戏");
                break;
            case R.id.game_im_l2://彩票游戏
                Log.i(TAG, "onClick: 彩票游戏");
                break;
            case R.id.game_im_l1://真人咨询
                Log.i(TAG, "onClick: 真人咨询");
                break;
            case R.id.game_im_r1://体育赛事
                Log.i(TAG, "onClick: 体育赛事");
                break;
            case R.id.game_im_r2://棋牌游戏
                Log.i(TAG, "onClick: 棋牌游戏");
                break;
            case R.id.game_ll_xiaoxi://消息
                NewsDialog.Show(Game1Activity.this);
                break;
            case R.id.game_ll_gerenzhongxing://个人中心
                ShowPersonalDialog();
                break;
            case R.id.game_ll_sehzhi://设置
                SetUpDialog.Show(Game1Activity.this);
                break;
        }

    }
/**
  *  描述：个人中心
  *  时间：2018/8/9 14:55
  **/
    private void ShowPersonalDialog() {
        PersonalDialog.Show(Game1Activity.this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void Error(String s) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }



}
