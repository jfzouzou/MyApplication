package com.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * Created by use on 2017/2/27.
 */

public class MyView extends View {

    private int width;
    private int height;


    private Paint mPaintLine;//定义直线的画笔
    private Paint mPaintInterCircle;//画一个内时钟园
    private Paint mPaintoutSideCircle;//画一个外时钟圆
    private Paint mPaintText;//定义一个绘制文字的画笔
    private Paint mPaintSecondLine;//定义一个绘制指针的画笔


    /**
     * 定义时间类
     */
    private Calendar mCalendar;

    private static final int NEED_INVALIDATE = 0X6666;
    //操作UI主线程
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case NEED_INVALIDATE:
                    //跟新时间
                    mCalendar = Calendar.getInstance();
                    invalidate();
                    sendEmptyMessageDelayed(NEED_INVALIDATE, 1000);
                    break;
            }

        }
    };


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaintLine = new Paint();
        mPaintLine.setAntiAlias(true);//消除锯齿
        mPaintLine.setColor(Color.GRAY);//设置画笔颜色
        mPaintLine.setStyle(Paint.Style.STROKE);//设置为空心
        mPaintLine.setStrokeWidth(10);//设置宽度


        //初始化内圆的画笔
        mPaintInterCircle = new Paint();
        mPaintInterCircle.setAntiAlias(true);//消除锯齿
        mPaintInterCircle.setColor(Color.BLACK);
        mPaintInterCircle.setStyle(Paint.Style.STROKE);//设置为空心
        mPaintInterCircle.setStrokeWidth(1);

        //初始化外圆的画笔
        mPaintoutSideCircle = new Paint();
        mPaintoutSideCircle.setAntiAlias(true);//消除锯齿
        mPaintoutSideCircle.setColor(Color.BLACK);
        mPaintoutSideCircle.setStyle(Paint.Style.STROKE);//设置为空心
        mPaintoutSideCircle.setStrokeWidth(5);

        //初始化时钟时刻点数
        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setColor(Color.BLUE);
        mPaintText.setStyle(Paint.Style.STROKE);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(30);
        mPaintText.setStrokeWidth(5);

        // 初始化秒针的画笔
        mPaintSecondLine = new Paint();
        mPaintSecondLine.setAntiAlias(true);//消除锯齿
        mPaintSecondLine.setColor(Color.GRAY);//设置画笔颜色
        mPaintSecondLine.setStyle(Paint.Style.STROKE);//设置为空心
        mPaintSecondLine.setStrokeWidth(7);//设置宽度

        //初始化日历
        mCalendar = Calendar.getInstance();

        //发送一个消息给UI主线程
        handler.sendEmptyMessageDelayed(NEED_INVALIDATE, 2000);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, width);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2, height / 2, 150, mPaintInterCircle);
        canvas.drawCircle(width / 2, height / 2, 140, mPaintoutSideCircle);

        for (int i = 1; i <= 12; i++) {
            canvas.save();
            canvas.rotate(360 / 12 * i, width / 2, height / 2);
            canvas.drawText("" + i, width / 2, height / 2 - 240, mPaintText);
            // canvas.drawLine(width / 2, height / 2 - 300, width, height / 2 - 270, mPaintLine);
            canvas.drawLine(width / 2, height / 2 - 300, width / 2, height / 2 - 270, mPaintLine);
            canvas.restore();//回到save()方法保存的状态
        }

        //绘制分针
        int minute = mCalendar.get(Calendar.MINUTE);
        float minuteDegree = minute / 60f * 360;
        canvas.save();
        canvas.rotate(minuteDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 200, width / 2, height / 2 + 40, mPaintLine);
        canvas.restore();
        //绘制时针
        int hour = mCalendar.get(Calendar.HOUR);
        float hourDegree = (hour * 60 + minute);//(12f*60)*360;
        canvas.save();
        canvas.rotate(hourDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 170, width / 2, height / 2 + 30, mPaintLine);
        canvas.restore();
        //绘制秒针
        int second = mCalendar.get(Calendar.SECOND);
        float secondDegree = second * 6;//一秒是6度。
        canvas.save();
        canvas.rotate(secondDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 220, width / 2, height / 2 + 50, mPaintSecondLine);
        canvas.restore();

    }
}
