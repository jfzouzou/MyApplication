package com.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.use.ui.R;

/**
 * Created by use on 2017/3/3.
 */

public class MyBitmapVIew extends View {

    private int width;
    private int height;

    private int bitmapWidth;
    private int bitmapHeight;

    private Matrix mMatrix;

    private Paint mPaint;
    private Bitmap bitmap;


    public MyBitmapVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon);
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();

        mMatrix = new Matrix();
        mPaint = new Paint();
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
        mMatrix.reset();
        mMatrix.postScale(2, 2);
        canvas.drawBitmap(bitmap, mMatrix, mPaint);

//        mMatrix.reset();
//        canvas.drawBitmap(bitmap, mMatrix, mPaint);

        //平移操作，x轴平移2倍宽,y轴平移2倍高
        mMatrix.reset();//矩阵复位
        mMatrix.postTranslate(2 * bitmapWidth,  0);
        canvas.drawBitmap(bitmap, mMatrix, mPaint);

        //旋转操作，原图以左上角点位中心旋转180度，下移三倍高
        mMatrix.reset();//矩阵复位
//        mMatrix.postRotate(180, bitmapWidth, 0);
        mMatrix.postTranslate(2 * bitmapWidth, bitmapHeight);//下移三倍高
        canvas.drawBitmap(bitmap, mMatrix, mPaint);//旋转之后的图

//        //旋转操作，原图以左上角点位中心旋转180度，下移三倍高
        mMatrix.reset();//矩阵复位
//        mMatrix.postRotate(360, bitmapWidth, 20);
        mMatrix.postTranslate(0, 2 * bitmapHeight);//下移三倍高
        canvas.drawBitmap(bitmap, mMatrix, mPaint);//旋转之后的图

        //错切操作， x轴错切1倍。
        mMatrix.reset();//矩阵复位
        mMatrix.postSkew(1, 0);
        canvas.drawBitmap(bitmap, mMatrix, mPaint);//错切之后的图

        //对称操作，关于x轴对称，也就是上下的镜面效果。
        float matrix_values_x[] = {1f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 1f};
        mMatrix.setValues(matrix_values_x);
        mMatrix.postTranslate(0, 3 * bitmapHeight);//下移三倍高
        canvas.drawBitmap(bitmap, mMatrix, mPaint);//对称之后的图

        //对称操作，关于y轴对称，也就是左右的镜面效果。
        float matrix_values_y[] = {-1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f};
        mMatrix.setValues(matrix_values_y);
        mMatrix.postTranslate(3 * bitmapWidth, 0);//下移三倍高
        canvas.drawBitmap(bitmap, mMatrix, mPaint);//对称之后的图
    }
}
