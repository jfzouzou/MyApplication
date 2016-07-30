package com.example.use.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.service.ServiceTest;
import com.util.guideview.Component;
import com.util.guideview.Guide;
import com.util.guideview.GuideBuilder;
import com.util.guideview.cumponent.MutiComponent;
import com.util.guideview.cumponent.SimpleComponent;
import com.util.guideview1.GuideView1;

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
    @InjectView(R.id.guidetest)
    EditText guidetest;
    @InjectView(R.id.guideviewbutton1)
    Button mGuideviewbutton1;
    @InjectView(R.id.guideviewbutton2)
    Button mGuideviewbutton2;
    @InjectView(R.id.imageButton)
    ImageButton mImageButton;

    private GuideView1 mGuideView1;
    private GuideView1 mGuideView13;
    private GuideView1 mGuideView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        intentService = new Intent(MainActivity.this, ServiceTest.class);

        //第一种写法
        edt.post(new Runnable() {
            @Override
            public void run() {
                showGuideView();
            }
        });


    }

    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(edt)
                .setAlpha(150)
                .setHighTargetCorner(20)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
                // Toast.makeText(SimpleGuideViewActivity.this, "show", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDismiss() {
                // Toast.makeText(SimpleGuideViewActivity.this, "dismiss", Toast.LENGTH_SHORT)
                // .show();
                showGuideView2();
            }
        });
        builder.addComponent(new SimpleComponent());
        Guide guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(false);
        guide.show(MainActivity.this);
    }

    public void showGuideView2() {
        final GuideBuilder builder1 = new GuideBuilder();
        builder1.setTargetView(guidetest)
                .setAlpha(150)
                .setHighTargetGraphStyle(Component.CIRCLE)
                .setOverlayTarget(false)
                .setExitAnimationId(android.R.anim.fade_out)
                .setOutsideTouchable(false);
        builder1.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
                //  Toast.makeText(MutiGuideViewActivity.this, "show", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDismiss() {
                //   Toast.makeText(MutiGuideViewActivity.this, "dismiss", Toast.LENGTH_SHORT).show();
            }
        });

        builder1.addComponent(new MutiComponent());
        Guide guide = builder1.createGuide();
        guide.setShouldCheckLocInWindow(false);
        guide.show(MainActivity.this);
    }

    @OnClick({R.id.startService, R.id.stopService, R.id.guideviewbutton1, R.id.guideviewbutton2, R.id.imagebutton})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startService:
                startService(intentService);
                break;
            case R.id.stopService:
                stopService(intentService);
                break;
            case R.id.guideviewbutton1:
                break;
            case R.id.guideviewbutton2:
                break;
        }
    }

    private void setGuideView() {

        // 使用图片
        final ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.notification_template_icon_bg);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iv.setLayoutParams(params);

        // 使用文字
        TextView tv = new TextView(this);
        tv.setText("欢迎使用");
        tv.setTextColor(getResources().getColor(R.color.color_white));
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);

        // 使用文字
        final TextView tv2 = new TextView(this);
        tv2.setText("欢迎使用2");
        tv2.setTextColor(getResources().getColor(R.color.color_white));
        tv2.setTextSize(30);
        tv2.setGravity(Gravity.CENTER);


        mGuideView1 = GuideView1.Builder
                .newInstance(this)
                .setTargetView(mImageButton)//设置目标
                .setCustomGuideView(iv)
                .setDirction(GuideView1.Direction.LEFT_BOTTOM)
                .setShape(GuideView1.MyShape.CIRCULAR)   // 设置圆形显示区域，
                .setBgColor(getResources().getColor(R.color.colorAccent))
                .setOnclickListener(new GuideView1.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        mGuideView1.hide();
                        mGuideView12.show();
                    }
                })
                .build();


        mGuideView12 = GuideView1.Builder
                .newInstance(this)
                .setTargetView(mGuideView12)
                .setCustomGuideView(tv)
                .setDirction(GuideView1.Direction.LEFT_BOTTOM)
                .setShape(GuideView1.MyShape.ELLIPSE)   // 设置椭圆形显示区域，
                .setBgColor(getResources().getColor(R.color.abc_input_method_navigation_guard))
                .setOnclickListener(new GuideView1.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        mGuideView12.hide();
                        mGuideView13.show();
                    }
                })
                .build();


        mGuideView13 = GuideView1.Builder
                .newInstance(this)
                .setTargetView(mGuideView13)
                .setCustomGuideView(tv2)
                .setDirction(GuideView1.Direction.LEFT_BOTTOM)
                .setShape(GuideView1.MyShape.RECTANGULAR)   // 设置矩形显示区域，
                .setRadius(80)          // 设置圆形或矩形透明区域半径，默认是targetView的显示矩形的半径，如果是矩形，这里是设置矩形圆角大小
                .setBgColor(getResources().getColor(R.color.abc_input_method_navigation_guard))
                .setOnclickListener(new GuideView1.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        mGuideView13.hide();
                        mGuideView1.show();
                    }
                })
                .build();

        mGuideView1.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setGuideView();
    }

}
