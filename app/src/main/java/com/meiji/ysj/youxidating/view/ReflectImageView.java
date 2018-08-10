package com.meiji.ysj.youxidating.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ReflectImageView extends android.support.v7.widget.AppCompatImageView {
    private boolean mReflectionMode = true;
    ReflectImageView imageview;
    Bitmap bitmap;
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0x9999) {
                imageview.setImageBitmap(bitmap);
            }
        }

        ;
    };

    public ReflectImageView(Context context) {
        this(context, null);
    }

    public ReflectImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReflectImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        imageview = this;
    }

    public void setReflectionMode(boolean isRef) {
        mReflectionMode = isRef;
    }

    public boolean getReflectionMode() {
        return mReflectionMode;
    }

    public Bitmap createReflectedImage(Bitmap originalImage) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        Matrix matrix = new Matrix();
        // 实现图片翻转90度
        matrix.preScale(1, -1);
        // 创建倒影图片（是原始图片的同样大小）
        Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, 0,
                width, height, matrix, false);
        // 创建倒影图片
        Bitmap finalReflection = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // 创建画布
        Canvas canvas = new Canvas(finalReflection);
        // canvas.drawBitmap(originalImage, 0, 0, null);
        // 把倒影图片画到画布上
        canvas.drawBitmap(reflectionImage, 0, 0, null);
        Paint shaderPaint = new Paint();
        // 创建线性渐变LinearGradient对象
        LinearGradient shader = new LinearGradient(0, 0, 0, 100, 0x20ffffff,
                0x00ffffff, Shader.TileMode.CLAMP);
        shaderPaint.setShader(shader);
        shaderPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        // 画布画出反转图片大小区域，然后把渐变效果加到其中，就出现了图片的倒影效果。
        canvas.drawRect(0, 0, width, finalReflection.getHeight(), shaderPaint);
        return finalReflection;
    }

    public void StartReflect(Bitmap bitmap) {
        this.setScaleType(ScaleType.CENTER_CROP);
        ImageViewAsync async = new ImageViewAsync();
        async.execute(bitmap);
    }

    class ImageViewAsync extends AsyncTask<Bitmap, Bitmap, Bitmap> {

        @Override
        protected Bitmap doInBackground(Bitmap... params) {
            // TODO Auto-generated method stub
            return createReflectedImage(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            bitmap = result;
            handler.sendEmptyMessage(0x9999);
        }
    }
}