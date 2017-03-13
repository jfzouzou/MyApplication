package com.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by use on 2017/3/6.
 */

public class MyBitmapViewAnother  extends View {

    private int width;//设置高
    private int height;//设置高


    private Paint mPaint;
    //设置一个Bitmap
    private Bitmap bitmap;
    //创建该Bitmap的画布
    private Canvas bitmapCanvas;
    private Paint mPaintCirlcle;
    private Paint mPaintRect;

    public MyBitmapViewAnother(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();//Bitmap的画笔

        mPaintCirlcle = new Paint();
        mPaintCirlcle.setAntiAlias(true);
        mPaintCirlcle.setColor(Color.YELLOW);
//        PorterDuffXfermode mode  = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
//        mPaintCirlcle.setXfermode(mode);

        mPaintRect = new Paint();
        mPaintRect.setAntiAlias(true);
        mPaintRect.setColor(Color.GRAY);
        PorterDuffXfermode mode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        mPaintRect.setXfermode(mode);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);//设置宽和高
        //自己创建一个Bitmap
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCanvas = new Canvas(bitmap);//该画布为bitmap的

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置该View画布的背景
        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        bitmapCanvas.drawCircle(width / 2, height / 2, width / 2, mPaintCirlcle);
        bitmapCanvas.drawRect(0, 0, width / 2, height / 2, mPaintRect);
    }
}
