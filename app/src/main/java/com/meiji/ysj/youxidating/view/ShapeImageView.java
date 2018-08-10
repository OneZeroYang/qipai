package com.meiji.ysj.youxidating.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;


/**
  *  描述：平行四边形自定义类
  *  时间：2018/8/6 10:28
  **/

public class ShapeImageView extends android.support.v7.widget.AppCompatImageView {

    public static final String TAG = "ShapeImageView";

    private ShapeDrawable mShapeDrawable;

    private Shape mShape;

    private boolean mIsShape;

    private boolean mRebuildShape;

    public ShapeImageView(Context context) {
        this(context, null);
    }

    public ShapeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //设置shape
    public void setShap(Shape shape) {
        mShape = shape;
        mIsShape = true;
        mRebuildShape = true;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        if (mIsShape) {
            //获取ImageView的drawble，当调用过setShape方法时，走下面的流程
            Drawable oldDrawable = getDrawable();
            if (oldDrawable == null || mShape == null) {
                return;
            }

            Rect bounds = oldDrawable.getBounds();

            if (bounds == null || bounds.width() == 0 || bounds.height() == 0) {
                return;
            }
            if (mShapeDrawable == null) {
                mShapeDrawable = new ShapeDrawable();
            }
            //设置shapedrawable的bounds
            mShapeDrawable.setBounds(bounds);

            if (mRebuildShape) {
                mRebuildShape = false;
                //获取bitmap
                Bitmap bm = drawableToBitmap(oldDrawable);
                if (bm == null) {
                    return;
                }
                //创建一个bitmapshader，shapedrawable设置这个位图渲染
                BitmapShader bitmapShader = new BitmapShader(bm,
                        Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                mShapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
                mShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
                mShapeDrawable.getPaint().setShader(bitmapShader);
                mShapeDrawable.setShape(mShape);
            }

            //当时平行四边形时设置Shape的所在区域
            if (mShape instanceof ParallelogramShape) {
                ((ParallelogramShape) mShape).setRect(bounds);
            }

            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();
            // int paddingRight = getPaddingRight();
            // int paddingBottom = getPaddingBottom();
            // Matrix imageMatrix = getImageMatrix();
            // int left = getLeft();
            // int top = getTop();
            // int right = getRight();
            // int bottom = getBottom();

            //将mShapeDrawable画在canvas
            if (paddingTop == 0 && paddingLeft == 0) {
                mShapeDrawable.draw(canvas);
            } else {
                int saveCount = canvas.getSaveCount();
                canvas.save();

                canvas.translate(paddingLeft, paddingTop);
                mShapeDrawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
        } else {
            super.onDraw(canvas);
        }

    }

    //此方法用于创建一个bitmap
    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null || drawable.getBounds() == null) {
            return null;
        }

        // if (drawable instanceof BitmapDrawable) {
        // return ((BitmapDrawable) drawable).getBitmap();
        // }

        Bitmap bitmap;
        int width = drawable.getBounds().width();
        int height = drawable.getBounds().height();
        try {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.draw(canvas);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            bitmap = null;
        }
        return bitmap;
    }

}
