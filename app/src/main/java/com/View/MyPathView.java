package com.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by use on 2017/3/2.
 */

public class MyPathView extends View {

    private int width;
    private int height;

    private Path mPath;

    private Paint mPaint;
    private Paint mPaintCircle;
    private int count = 0;
    private static final int NEED_INVALIDATE = 0X6666;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case NEED_INVALIDATE:
                    count += 5;
                    if (count > 80) {
                        count = 0;
                    }
                    invalidate();
                    sendEmptyMessageDelayed(NEED_INVALIDATE, 50);
                    break;
            }
        }
    };

    public MyPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(30);

        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(Color.BLUE);
        mPaintCircle.setStrokeWidth(5);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setTextSize(30);

        mHandler.sendEmptyMessageDelayed(NEED_INVALIDATE, 50);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 绘制三角形
         */
//        mPath.moveTo(50, 50);
//        mPath.lineTo(0, 120);
//        mPath.lineTo(120, 120);
//        mPath.close();
//        canvas.drawPath(mPath, mPaint);

        /**
         * 绘制圆形，并沿着圆形上添加文字
         */
//        mPath.addCircle(width/2,height/2,300,Path.Direction.CW);
//        canvas.drawPath(mPath, mPaint);
//        canvas.drawTextOnPath("哈哈哈哈哈哈",mPath,0,0,mPaint);

        /**
         * 绘制贝塞尔曲线
         */
//        mPath.moveTo(0, 0);
//        mPath.quadTo(50,300,500,300);
//        canvas.drawPoint(100, 100, mPaint);
//        canvas.drawPoint(50,400, mPaint);
//        canvas.drawPoint(500, 400, mPaint)¬;
//        canvas.drawPath(mPath,mPaint);

        /**
         * 绘制波浪线
         */
        mPath.reset();
        mPath.moveTo(count, height / 2);
        for (int i = 0; i < 10; i++) {
            mPath.rQuadTo(20, 5, 40, 0);
            mPath.rQuadTo(-20, -5, 40, 0);
        }
        canvas.drawPath(mPath, mPaint);
        canvas.drawCircle(width / 2, height / 2, 50, mPaintCircle);

    }
}
