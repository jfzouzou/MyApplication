package com.util.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.base.BaseApplication;

/**
 * Created by cx on 2016/8/15.
 */
public class FontEditext extends EditText {

    public FontEditext(Context context) {
        super(context);
    }

    public FontEditext(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setTypeface(BaseApplication.getInstance().createWRYHTypeFace());
    }
}
