package com.meiji.yangshijie.myapplication_test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.meiji.yangshijie.myapplication_test.R;


/**
  *  描述：梯形显示测试类
  *  时间：2018/8/6 9:57
  **/

public class TestView extends android.support.v7.widget.AppCompatImageView {

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        Drawable d = getResources().getDrawable(R.mipmap.ic_1);
        d.setBounds(0, 0, width, height);

        canvas.save();
        //一个平行四边形
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(100, height);
        path.lineTo(width , height);
        path.lineTo(width-100, 0);
        canvas.clipPath(path);
        //将图像画在canvas上
        d.draw(canvas);
        canvas.restore();

    }

}
