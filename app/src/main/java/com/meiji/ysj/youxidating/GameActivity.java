package com.meiji.ysj.youxidating;

import android.util.Log;

import com.meiji.yangshijie.myapplication_test.BaseActivity;
import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.ysj.youxidating.view.ParallelogramShape;
import com.meiji.ysj.youxidating.view.ShapeImageView;

import static com.meiji.ysj.youxidating.utils.FileUtils.TAG;

public class GameActivity extends BaseActivity {

    private ShapeImageView iconZldx;
    private ShapeImageView iconDzyx;


    private ShapeImageView iconCpyx;
    private ShapeImageView iconZrsx;
    private ShapeImageView iconTyss;
    private ShapeImageView iconQpyx;







    @Override
    protected int setView() {
        return R.layout.activity_game;
    }

    @Override
    protected void initViews() {
        GlobalVariable.init(GameActivity.this);//初始化全局变量
        iconZldx = (ShapeImageView) findViewById(R.id.icon_zldx);
        iconDzyx = (ShapeImageView) findViewById(R.id.icon_dzyx);
        ParallelogramShape shape = new ParallelogramShape();
        shape.setScale(3);
        iconZldx.setShap(shape);
        ParallelogramShape shape1=new ParallelogramShape();
        shape1.setScale(4);
        iconDzyx.setShap(shape1);



        iconCpyx = (ShapeImageView) findViewById(R.id.icon_cpyx);
        iconZrsx = (ShapeImageView) findViewById(R.id.icon_zrsx);
        iconTyss = (ShapeImageView) findViewById(R.id.icon_tyss);
        iconQpyx = (ShapeImageView) findViewById(R.id.icon_qpyx);


        ParallelogramShape shape2=new ParallelogramShape();
        shape2.setScale(1);
        iconCpyx.setShap(shape2);

        ParallelogramShape shape3=new ParallelogramShape();
        shape3.setScale(1);
        iconZrsx.setShap(shape3);


        ParallelogramShape shape4=new ParallelogramShape();
        shape4.setScale(2);
        iconTyss.setShap(shape4);

        ParallelogramShape shape5=new ParallelogramShape();
        shape5.setScale(2);
        iconQpyx.setShap(shape5);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void Error(String s) {

    }
}
