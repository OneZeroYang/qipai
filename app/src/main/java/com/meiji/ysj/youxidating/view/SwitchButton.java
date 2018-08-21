package com.meiji.ysj.youxidating.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.meiji.yangshijie.login.R;
import com.meiji.Interface.SwitchButtonListener;



/**
  *  描述：自定义开关
  *  时间：2018/8/17 14:11
  **/
public class SwitchButton extends View {

    /**
     * 开关按钮的背景
     */
    private Bitmap backgroundBitmap;
    /**
     * 开关按钮的滑动部分
     */
    private Bitmap slideButton;
    /**
     * 滑动按钮的左边界
     */
    private float slideBtn_left;
    /**
     * 当前开关的状态
     */
    private static boolean currentState = false;


    private SwitchButtonListener switchButtonListener;

    /**
     * 在代码里面创建对象的时候，使用此构造方法
     *
     * @param context
     */
    public SwitchButton(Context context) {
        super(context);
    }

    /**
     * 在布局文件中声明的view，创建时由系统自动调用
     *
     * @param context
     * @param attrs
     */
    public SwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    /**
     * 测量尺寸时的回调方法
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 设置当前view的大小 width:view的宽，单位都是像素值 heigth:view的高，单位都是像素值
        setMeasuredDimension(backgroundBitmap.getWidth(),
                backgroundBitmap.getHeight()+20);
    }

    // 这个方法对于自定义view的时候帮助不大，因为view的位置一般由父组件来决定的
    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 画view的方法,绘制当前view的内容
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // super.onDraw(canvas);

        Paint paint = new Paint();
        // 打开抗锯齿
        paint.setAntiAlias(true);

        // 画背景
        canvas.drawBitmap(backgroundBitmap, 0, 15, paint);
        // 画滑块
        canvas.drawBitmap(slideButton, slideBtn_left-5, 7, paint);


//        int paddingLeft = getPaddingLeft();
//        int paddingRight = getPaddingRight();
//        int paddingTop = getPaddingTop();
//        int paddingBottom = getPaddingBottom();
//
//        int width = getWidth()-paddingLeft-paddingRight;
//        int height = getHeight()-paddingBottom-paddingTop;
//
//        int radius  = Math.min(width,height)/2;
//        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,radius,paint);
    }

    /**
     * 初始化view
     */
    private void initView() {

        backgroundBitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.tv_setup_kai);
        slideButton = BitmapFactory.decodeResource(getResources(),
                R.mipmap.im_setup_kaiguan);

        /*
         * 点击事件
         */
        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                currentState = !currentState;
                switchButtonListener.OnClick(v,currentState);

                flushState();
                flushView();

            }
        });
    }

    /**
     * 刷新视图
     */
    protected void flushView() {
        // 刷新当前view会导致ondraw方法的执行
        invalidate();
    }

    /**
     * 刷新当前的状态
     */
    protected void flushState() {
        if (currentState) {
            backgroundBitmap = BitmapFactory.decodeResource(getResources(),
                    R.mipmap.tv_setup_guan);
            slideBtn_left = backgroundBitmap.getWidth()
                    - slideButton.getWidth()+10;
        } else {
            slideBtn_left = 0;
            backgroundBitmap = BitmapFactory.decodeResource(getResources(),
                    R.mipmap.tv_setup_kai);
        }
    }

    public  void setcurrentState(boolean b){
        SwitchButton.currentState=b;
        flushState();
        flushView();

    }


    public void setOnClick(SwitchButtonListener switchButtonListener){
        this.switchButtonListener=switchButtonListener;
    }


}