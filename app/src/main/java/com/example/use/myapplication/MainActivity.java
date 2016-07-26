package com.example.use.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.service.ServiceTest;
import com.util.SDLogUtil;

import java.text.NumberFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    Intent intentService;
    @InjectView(R.id.startService)
    Button startService;
    @InjectView(R.id.stopService)
    Button stopService;
    @InjectView(R.id.edt)
    EditText edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        intentService = new Intent(MainActivity.this, ServiceTest.class);

        String string = "111111111.11";
        double adouble = Double.valueOf(string);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        SDLogUtil.debug("adouble;" + adouble + "doubleString" + String.valueOf(nf.format(adouble)));

        int inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER;
        edt.setInputType(inputType);
        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String temp = s.toString();
                int posDot = temp.indexOf(".");

                //输入9位整数后只能输入.,否则删除第十位
                if (temp.length() > 9) {
                    if (posDot > 0){
                        if (temp.length() - posDot - 1 > 2) {
                            s.delete(posDot + 3, posDot + 4);
                        }
                    }
                    if (posDot < 0) {
                        s.delete(9, 10);
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
                if(temp.length() <= 9)
                if (temp.length() - posDot - 1 > 2) {
                    s.delete(posDot + 3, posDot + 4);
                }


//                String temp = s.toString();
//                int posDot = temp.indexOf(".");

//                //输入9位整数后只能输入.,否则删除第十位
//                if (temp.length() > 9) {
//                    if (posDot > 0) return;
//                    if (posDot < 0) {
//                        s.delete(temp.length()-8, temp.length());
//                    }
//                }
//
//                //判断如果小数位超过2就删掉2+
//
//                if (posDot < 0) return;
//                if (posDot <= 0) {
//                    s.delete(posDot + 3, posDot + 4);
//                }
//                if (temp.length() - posDot - 1 > 2) {
//                    s.delete(posDot + 3, posDot + 4);
//                }
//
//                //判断如果第一个数为.就删掉
//                int Dot = temp.indexOf(".");
//                if (Dot < 0) return;
//                if (Dot == 0) {
//                    s.delete(Dot, Dot + 1);
//                }
//
//                //判断如果第一个数为0，第二个数只能为.,否则删除第二个数
//                int iszeo = temp.indexOf("0");
//              //  if (iszeo < 0) return;
//                if (iszeo == 0 && temp.length() > 1) {
//                    int iszeoposDot = temp.indexOf(".");
//                    if (iszeoposDot != 1) {
//                        s.delete(1, 2);
//                    }
//                }
            }
        });

    }

    @OnClick({R.id.startService, R.id.stopService})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startService:
                startService(intentService);
                break;
            case R.id.stopService:
                stopService(intentService);
                break;
        }
    }

    @OnClick(R.id.edt)
    public void onClick() {
    }
}
