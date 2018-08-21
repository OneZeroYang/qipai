package com.meiji.yangshijie.login.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


/**
  *  描述：自定义梯形View
  *  时间：2018/8/6 9:36
  **/

public class TrapezoidView extends ViewGroup {
    public TrapezoidView(Context context) {
        super(context);
    }

    public TrapezoidView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TrapezoidView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        MarginLayoutParams params = null;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        //开始处理wrap_content,如果一个子元素都没有，就设置为0
        if (getChildCount() == 0) {
            setMeasuredDimension(0,0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup，宽，高都是wrap_content，根据我们的需求，宽度是子控件的宽度，高度则是所有子控件的总和
            View childOne = getChildAt(0);
            params = (MarginLayoutParams) childOne.getLayoutParams();
            int childWidth = childOne.getMeasuredWidth();
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(childWidth + params.leftMargin + params.rightMargin,
                    childHeight * getChildCount() + params.topMargin + params.bottomMargin);

        } else if (widthMode == MeasureSpec.AT_MOST) {
            //ViewGroup的宽度为wrap_content,则高度不需要管，宽度还是自控件的宽度
            View childOne = getChildAt(0);
            params = (MarginLayoutParams) childOne.getLayoutParams();
            int childWidth = childOne.getMeasuredWidth();
            setMeasuredDimension(childWidth + params.leftMargin + params.rightMargin,heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup的高度为wrap_content,则宽度不需要管，高度为子View的高度和
            View childOne = getChildAt(0);
            params = (MarginLayoutParams) childOne.getLayoutParams();
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(widthSize, childHeight * getChildCount() + params.topMargin + params.bottomMargin);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int row = 0;
        int right = 0;
        int bottom = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            int childW = childView.getMeasuredWidth();
            int childH = childView.getMeasuredHeight();
            right += childW;
            bottom += row * (childH+5)+childH;
            if (right>r){
                row++;
                right = childW;
                bottom += row * (childH+5)+childH;
            }
            childView.layout(right - childW,bottom - childH,right,bottom);
        }
    }
}
