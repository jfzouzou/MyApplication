package com.util;

import android.text.Editable;
import android.text.InputType;
import android.widget.EditText;

/**
 * Created by zy on 2016/7/21.
 */

public class InputNumber{

    public void afterTextChanged(Editable s) {

        try {
            String temp = s.toString();
            int posDot = temp.indexOf(".");

            //输入9位整数后只能输入.,否则删除第9位
            if (temp.length() > 9) {
                if (posDot > 0) {
                    if (temp.length() - posDot - 1 > 2) {
                        s.delete(posDot + 3, posDot + 4);
                    }
                }
                if (posDot < 0) {
                    s.delete(9 , 10 );
                }
            }

            //如果第一个数为0，第二个数只能为.,否则删除第二个数
            int iszeo = temp.indexOf("0");
            if (iszeo == 0 && temp.length() > 1) {
                if (posDot != 1) {
                    s.delete(1, 2);
                }
            }

            //如果第一个数为.就删掉
            if (posDot == 0) {
                s.delete(posDot, posDot + 1);
            }

            //小数点后保留两位
            if (posDot <= 0) return;
            if (temp.length() <= 9)
                if (temp.length() - posDot - 1 > 2) {
                    s.delete(posDot + 3, posDot + 4);
                }

        } catch (Exception e) {

        }

    }

    EditText edt ;
    public void edit(){
        int inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER;
        edt.setInputType(inputType);

//        edt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//        String temp = s.toString();
//        int posDot = temp.indexOf(".");
//
//        //输入9位整数后只能输入.,否则删除第十位
//        if (temp.length() > 9) {
//            if (posDot > 0) {
//                if (temp.length() - posDot - 1 > 2) {
//                    s.delete(posDot + 3, posDot + 4);
//                }
//            }
//            if (posDot < 0) {
//                s.delete(9, 10);
//            }
//        }
//
//        //如果第一个数为0，第二个数只能为.,否则删除第二个数
//        int iszeo = temp.indexOf("0");
//        if (iszeo == 0 && temp.length() > 1) {
//            if (posDot != 1) {
//                s.delete(1, 2);
//            }
//        }
//
//        //如果第一个数为.就删掉
//        if (posDot == 0) {
//            s.delete(posDot, posDot + 1);
//        }
//
//        //小数点后保留两位
//        if (posDot <= 0) return;
//        if (temp.length() <= 9)
//            if (temp.length() - posDot - 1 > 2) {
//                s.delete(posDot + 3, posDot + 4);
//            }

    }

            //输入的最大金额
            private static final int MAX_VALUE = Integer.MAX_VALUE;
            //小数点后的位数
            private static final int POINTER_LENGTH = 2;

            private static final String POINTER = ".";

            private static final String ZERO = "0";

//    public CashierInputFilter() {
//        mPattern = Pattern.compile("([0-9]|\\.)*");
//    }

            /**
             * @param source    新输入的字符串
             * @param start     新输入的字符串起始下标，一般为0
             * @param end       新输入的字符串终点下标，一般为source长度-1
             * @param dest      输入之前文本框内容
             * @param dstart    原内容起始坐标，一般为0
             * @param dend      原内容终点坐标，一般为dest长度-1
             * @return 输入内容
             */
//    @Override
//    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//        String sourceText = source.toString();
//        String destText = dest.toString();
//
//        //验证删除等按键
//        if (TextUtils.isEmpty(sourceText)) {
//            return "";
//        }
//
//        Matcher matcher = mPattern.matcher(source);
//        //已经输入小数点的情况下，只能输入数字
//        if(destText.contains(POINTER)) {
//            if (!matcher.matches()) {
//                return "";
//            } else {
//                if (POINTER.equals(source)) {  //只能输入一个小数点
//                    return "";
//                }
//            }
//
//            //验证小数点精度，保证小数点后只能输入两位
//            int index = destText.indexOf(POINTER);
//            int length = dend - index;
//
//            if (length > POINTER_LENGTH) {
//                return dest.subSequence(dstart, dend);
//            }
//        } else {
//            //没有输入小数点的情况下，只能输入小数点和数字，但首位不能输入小数点和0
//            if (!matcher.matches()) {
//                return "";
//            } else {
//                if ((POINTER.equals(source) || ZERO.equals(source)) && TextUtils.isEmpty(destText)) {
//                    return "";
//                }
//            }
//        }
//
//        //验证输入金额的大小
//        double sumText = Double.parseDouble(destText + sourceText);
//        if (sumText > MAX_VALUE) {
//            return dest.subSequence(dstart, dend);
//        }
//
//        return dest.subSequence(dstart, dend) + sourceText;

        }