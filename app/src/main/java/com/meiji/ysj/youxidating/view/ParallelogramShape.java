package com.meiji.ysj.youxidating.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;


/**
  *  描述：画矩形
  *  时间：2018/8/6 10:27
  **/

public class ParallelogramShape extends Shape {

    private int XY=0;

    Path path;

    Rect rect;
    int offset;

    float scale = -1f;

    public ParallelogramShape() {
        path = new Path();
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setScale(int XY) {
        this.XY=XY;
        this.scale = 0.2f;
    }

    //此方法设置path，path为平行四边形
    @Override
    public void draw(Canvas canvas, Paint paint) {
        if (rect == null || rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        if (scale > 0.0f && scale < 1.0f) {
            offset = (int) (scale * rect.width());
        }


        /**
          *  描述：左边
          *  时间：2018/8/6 10:57
          **/
        if (XY==1){
            path.reset();
            path.moveTo(rect.left, rect.left);
            path.lineTo(offset+40, rect.bottom);
            path.lineTo(rect.right , rect.bottom);
            path.lineTo(rect.right-offset-40, 0);
            canvas.drawPath(path, paint);


            /**
              *  描述：右边
              *  时间：2018/8/6 10:58
              **/
        } else if (XY==2){
            path.reset();
            path.moveTo(offset+50, rect.left);
            path.lineTo(rect.left, rect.bottom);
            path.lineTo(rect.right - offset-50, rect.bottom);
            path.lineTo(rect.right, 0);
            canvas.drawPath(path, paint);

        }else if (XY==3){
            path.reset();
            path.moveTo(rect.left, rect.left);
            path.lineTo(offset-50, rect.bottom);
            path.lineTo(rect.right - offset+50, rect.bottom);
            path.lineTo(rect.right, 0);
            canvas.drawPath(path, paint);
        }


        else if (XY==4){
            path.reset();
            path.moveTo(rect.left, rect.left);
            path.lineTo(offset, rect.bottom);
            path.lineTo(rect.right - offset, rect.bottom);
            path.lineTo(rect.right, 0);
            canvas.drawPath(path, paint);
        }



    }

}
