package com.meiji.ysj.youxidating.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
  *  描述：图片的倒影效果
  *  时间：2018/8/7 15:01
  **/

public class ReflectionImage extends android.support.v7.widget.AppCompatImageView {
    // 是否为Reflection模式
    private boolean mReflectionMode = true;

    public ReflectionImage(Context context) {
        super(context);
    }

    public ReflectionImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        measure(0, 0);
        // 取得原始图片的bitmap并重画
        Bitmap originalImage = ((BitmapDrawable) this.getDrawable()).getBitmap();
        DoReflection(originalImage);
    }

    public ReflectionImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Bitmap originalImage = ((BitmapDrawable) this.getDrawable()).getBitmap();
        DoReflection(originalImage);
    }

    public void setReflectionMode(boolean isRef) {
        mReflectionMode = isRef;
    }

    public boolean getReflectionMode() {
        return mReflectionMode;
    }

    // 偷懒了,只重写了setImageResource,和构造函数里面干了同样的事情
    @Override
    public void setImageResource(int resId) {
        Bitmap originalImage = BitmapFactory.decodeResource(getResources(), resId);
        DoReflection(originalImage);
        // super.setImageResource(resId);
    }

    private void DoReflection(Bitmap originalImage) {
        // 原始图片和反射图片中间的间距
        final int reflectionGap = 4;
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        // 反转
        Matrix matrix = new Matrix();
        // 第一个参数为1表示x方向上以原比例为准保持不变，正数表示方向不变。
        // 第二个参数为-1表示y方向上以原比例为准保持不变，负数表示方向取反。
        matrix.preScale(1, -0.75f);
        // reflectionImage就是下面透明的那部分,可以设置它的高度为原始的3/4,这样效果会更好些
        Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, 0, width, height * 3/ 4, matrix, false);
        // 创建一个新的bitmap,高度为原来的两倍
        Bitmap bitmap4Reflection = Bitmap.createBitmap(width, (height + height * 3 / 4), Bitmap.Config.ARGB_8888);
        // 其宽*高 = width * (height + height * 3 / 4)
        Canvas canvasRef = new Canvas(bitmap4Reflection);
        // 先画原始的图片
        canvasRef.drawBitmap(originalImage, 0, 0, null);
        // 画间距
        Paint deafaultPaint = new Paint();
        // defaultPaint不能为null，否则会有空指针异常。
        canvasRef.drawRect(0, height, width, height + reflectionGap, deafaultPaint);
        // 画被反转以后的图片
        canvasRef.drawBitmap(reflectionImage, 0, height + reflectionGap, null);
        // 创建一个渐变的蒙版放在下面被反转的图片上面
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(200, originalImage.getHeight(), 10, bitmap4Reflection.getHeight()
                + reflectionGap, 0x80ffffff, 0x00ffffff, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        // Set the Transfer mode to be porter duff and destination in
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        // 将蒙板画上
        canvasRef.drawRect(0, height, width, bitmap4Reflection.getHeight() + reflectionGap, paint);
        // 调用ImageView中的setImageBitmap
        this.setImageBitmap(bitmap4Reflection);
    }
}

