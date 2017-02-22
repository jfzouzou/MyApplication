package com.util;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;


/**
 * Created by use on 2017/1/22.
 */

public class ZYCustomSpinner extends LinearLayout
{

    private Context mConText;
    private RadioGroup mRGroup;
    private RadioButton mRButton;

    private List<String> listStr = null;

    public static int spinnerPosition;


    /**
     * PopupWindow的内容视图
     */
    private View popView = null;
    private ListView listView;

    /**
     * 屏幕宽高
     */
    private int displayWidth;
    private int displayHeight;

    /**
     * PopupWindow中ListView的item的宽度，即作为锚点的View的宽度
     */
    private int itemWeight;
    /**
     * PopupWindow中的ListView 的item的高度，即作为锚点的View的高度
     */
    private int itemHeight;

    /**
     * 当RadioButton被点击，弹出用来显示具体内容的悬浮框
     */
    private PopupWindow popWindow;

  //  private OnSpinnerItemClickListener onSpinnerItemClickListener;



    public ZYCustomSpinner(Context context) {
        super(context);
      //  init(context);
    }

//
//    private void init(Context context) {
//        /**
//         * 加载spinner布局
//         */
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.layout_spinner, this);
//        mRGroup = (RadioGroup) linearLayout.findViewById(R.id.spinner_radio_group);
////        mRGroup.setBackgroundColor(getResources().getColor(R.color.white));//背景色
//        mRButton = (RadioButton) mRGroup.findViewById(R.id.spinner_radiobutton);
//        mRButton.setTypeface(Typeface.DEFAULT);
//        mRButton.setOnClickListener(this);
//
//        /*
//         * 获取屏幕宽高
//         */
//        WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
//        DisplayMetrics metrics = new DisplayMetrics();
//        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
//        displayHeight = metrics.heightPixels;
//        displayWidth = metrics.widthPixels;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.spinner_radiobutton:
//                if (listStr == null) {
//                    Toast.makeText(mConText, "暂无数据", Toast.LENGTH_LONG).show();
//                    mRGroup.clearCheck();
//                } else {
//                    itemHeight = v.getHeight();
//                    itemWeight = v.getWidth();
//                    popView = initPopView(listStr);
//
//                }
//               break;
//        }
//    }
//
//    private View initPopView(List<String> str){
//        final View view = View.inflate(mConText,R.layout.pop_list,null);
//        listView = (ListView)view.findViewById(R.id.pop_list);
//        SpinnerListAdapter adapter = new SpinnerListAdapter(mContext, str, itemHeight, null, 0);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(mItemClickListener);
//
//
//        return view;
//    }
//
//    /**
//     * 将PopWindow初始化并显示
//     *
//     * @param referView  作为锚点的View
//     * @param layoutView 作为PopWindow内部的布局样式
//     * @author wxf
//     * @date 2013-4-23 上午11:26:22
//     * @version
//     */
//    private void showPopWindow(View referView, final View layoutView)
//    {
//        if (null == layoutView)
//        {
//            return;
//        }
//        popWindow = new PopupWindow(layoutView, itemWeight,
//                itemHeight * 2);
//        /**
//         * 监听popwindow，当PopWindow消失时，将副栏的TAB中的RadioButton恢复原状
//         */
//        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
//        {
//
//            @Override
//            public void onDismiss()
//            {
//                // TODO Auto-generated method stub
//                mRGroup.clearCheck();
//            }
//        });
//
//        /**
//         * 设置背景为空，解决点击PopupWindow中的RadioButton是RadioButton的背景变为透明的问题
//         */
//        popWindow.setBackgroundDrawable(null);
//
//        /**
//         * 去的锚点v的左上角的坐标，并存放到数组xy[]中
//         */
//        int[] xy = getLocation(referView);
//
//        /**
//         *   根据PopWindow的大小及描点坐标计算出PopWindow的弹出方向
//         *   并根据方向设置PopWindow弹出和隐藏的动画
//         */
//        System.out.println("描点的Y值：   " + xy[1]);
//        System.out.println("popWindow的高：  " + popWindow.getHeight());
//        System.out.println("描点的高：   " + referView.getHeight());
//        int height = xy[1] + popWindow.getHeight() + referView.getHeight();
//        int locationX, locationY;
//        if (height > displayHeight)
//        {
//            //此时的PopWindow会在描点referView的上方弹出
//            popWindow.setAnimationStyle(R.style.pop_anim_in_down_to_up);
//            locationX = xy[0];
//            locationY = xy[1] - popWindow.getHeight();
//        } else
//        {
//            //此时的PopWindow会在描点referView的下方弹出
//            popWindow.setAnimationStyle(R.style.pop_anim_in_up_to_down);
//            locationX = xy[0];
//            locationY = xy[1] + referView.getHeight();
//        }
//
//        /**
//         * 设置PopupWindow外部区域是否可触摸
//         */
//        popWindow.setFocusable(true); // 设置PopupWindow可获得焦点
//        popWindow.setTouchable(true); // 设置PopupWindow可触摸
//        popWindow.setOutsideTouchable(true); // 设置非PopupWindow区域可触摸
//
//        /**
//         * 将PopWindow在相对于锚点的指定坐标显示出来
//         */
//        popWindow.showAsDropDown(referView);
//        //gkt:我特么注释了↓反注释了↑
////        popWindow.showAtLocation(this, Gravity.NO_GRAVITY, locationX, locationY);
//    }
//
//    /**
//     * @param v
//     * @return 返回参数View的坐标
//     * @author wxf
//     * @date 2013-4-23 上午11:45:16
//     * @version
//     */
//    private int[] getLocation(View v)
//    {
//        int[] location = new int[2];
//        v.getLocationOnScreen(location);
//        return location;
//    }
//
//
//
//    public void setOnSpinnerItemClickListener(
//           OnSpinnerItemClickListener onSpinnerItemClickListener)
//    {
//        this.onSpinnerItemClickListener = onSpinnerItemClickListener;
//    }
//
//    public interface OnSpinnerItemClickListener
//    {
//        public void onItemClick(String condition, int position);
//    }
//
//
//    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener()
//    {
//
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position,
//                                long id)
//        {
//            ListView listView = (ListView) parent;
//            String condition = listView.getItemAtPosition(position).toString();
//            if (onSpinnerItemClickListener != null)
//                onSpinnerItemClickListener.onItemClick(condition, position);
//            mRButton.setText(condition);
//            hidePopWindow();
//
//            Bundle bu = new Bundle();
//            bu.putInt("Spinner", spinnerPosition);
//            // 发送带参数的广播到指定界面
////            bu.putString(BroadcastUtil.OBJECT, MySohoTabActivity.class.getCanonicalName());
////            BroadcastUtil.senMainBroadcast(getContext(),
////                    BroadcastUtil.MAIN,
////                    BroadcastUtil.SendStateCode.MYSOHOTAB_VIEWPAGE, bu);
//            System.out.print("发送广播");
//
//        }
//    };
//
//
//    /**
//     * 隐藏PopWindow
//     *
//     * @author wxf
//     * @date 2013-4-23 下午1:57:23
//     * @version
//     */
//    public void hidePopWindow()
//    {
//        if (null != popWindow && popWindow.isShowing())
//        {
//            System.out.println("popWindow的Height：" + popWindow.getHeight() + " Y: " );
//            popWindow.dismiss();
//            popWindow = null;
//        }
//    }
}
