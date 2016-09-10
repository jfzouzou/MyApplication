package com.util;

import android.util.Log;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zy on 2016/7/21.
 */
public class StringUtil {

    //判断字符串是否为数字
    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }

    //将服务器返回的日期格式转换成时间戳再转成字符串
    public static String subString(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timeStemp = date.getTime() / 1000;
        string = simpleDateFormat.format(new Date(timeStemp * 1000));
        Log.i("zy", "stringdate" + string);
        return string;
    }

    //将超出8位的double数转换成string
    public static String stringFormat(String string) {
        double adouble = Double.valueOf(string);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        SDLogUtil.debug("adouble;" + adouble + "doubleString" + String.valueOf(nf.format(adouble)));
        return string;
    }
}
