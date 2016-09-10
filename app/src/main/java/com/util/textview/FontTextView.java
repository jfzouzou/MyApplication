package com.util.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.base.BaseApplication;

/**
 * 微软雅黑字体
 * Created by cx on 2016/8/10.
 */
public class FontTextView extends TextView {

    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setTypeface(BaseApplication.getInstance().createWRYHTypeFace());

    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
