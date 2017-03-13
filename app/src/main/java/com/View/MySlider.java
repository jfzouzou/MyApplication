package com.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by use on 2017/3/10.
 */

public class MySlider extends View {

    private int width;
    private int height;

    //字母的宽度和高度
    private float textWidth;
    private float textHeight;
    private Paint mPaintText;//绘制字母的画笔
    private Paint  mPaintRed;
    private int index = -1;

    //设置字母数组
    private String[] array = {"#", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "G",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    public MySlider(Context context, AttributeSet attrs) {
        super(context, attrs);

        //初始化画笔，并设置相关参数。
        mPaintText = new Paint();
        mPaintText.setColor(Color.GRAY);//画笔颜色
        mPaintText.setAntiAlias(true);//去锯齿
        mPaintText.setTextAlign(Paint.Align.CENTER);//设置字体居中显示

        mPaintRed = new Paint();
        mPaintRed.setColor(Color.BLUE);
        mPaintRed.setAntiAlias(true);
        mPaintRed.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);

        textHeight = height / 27f - 2;
        //设置字母的高度
        mPaintText.setTextSize(textHeight);
        mPaintRed.setTextSize(textHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //求出"M"字母的宽度，因为我们需要将字母设置在控件的最左边，所以我们需要求出字母的宽度，然后设置。这里我们会求宽度最大的字母的宽度。
        textWidth = mPaintText.measureText("M");
        //通过循环，将字母绘制在控件上。
        for (int i = 0; i < 27; i++) {
            //绘制文字从数组中获得， 绘制的位置时控件宽度减去字母宽度width-textWidth，高度是height/27*(i+1)
            canvas.drawText("" + array[i], width - textWidth, height / 27 * (i + 1), mPaintText);
        }

        textWidth = mPaintText.measureText("M");
        //添加修改如下，通过index来绘制文本，试问本变颜色。
        for (int i = 0; i < 26; i++) {
            if (index == i) {
                //将点击的位置修改颜色
                canvas.drawText("" + array[i], width - textWidth, height / 27 * (i + 1), mPaintRed);
            } else {
                canvas.drawText("" + array[i], width - textWidth, height / 27 * (i + 1), mPaintText);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                if (x > width - 2 * textWidth) {
                    index = (int) (y / (height / 27));
                    //此处有增加，当屏幕被点击后，将参数传入。
                    if (listener != null) {
                        listener.onItemSelect(index, array[index]);
                    }
                    invalidate();
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP:
                index = -1;
                invalidate();
                return true;
        }
        return super.onTouchEvent(event);
    }

    //定义一个接口对象listerner
    private OnItemSelectListener listener;

    //获得接口对象的方法。
    public void setOnItemSelectListener(OnItemSelectListener listener) {
        this.listener = listener;
    }

    //定义一个接口
    public interface OnItemSelectListener {
        public void onItemSelect(int index, String indexString);
    }
}
