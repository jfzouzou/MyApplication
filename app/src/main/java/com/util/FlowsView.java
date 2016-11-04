package com.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.use.ui.R;

import java.util.List;

/**
 * 流程图
 * Created by cc on 2016/6/30.
 */
public class FlowsView extends LinearLayout {

    private static final String TAG = "FlowsView";

    private static final String STAFF_PROCESS_COLOR = "#2d7a10";
    private static final String MANA_PROCESS_COLOR = "#c1a872";

    private LayoutInflater mInflater;
    private View rootView;
    private LinearLayout flowsGroup;
    private TextView processTextView;
    private int oneFlowWidth;
    private boolean isMana;
    private String processTxt;

    private int flowGroupWidth;
    private boolean isFirstMesure;

    public FlowsView(Context context) {
        this(context, null);
    }

    public FlowsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = null;
        try {
            ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FlowsView, defStyleAttr, 0);
            int n = ta.getIndexCount();
            for (int i = 0; i < n; i++) {
                int attr = ta.getIndex(i);
                if (attr == R.styleable.FlowsView_is_mana) {
                    isMana = ta.getBoolean(attr, false);
                } else if (attr == R.styleable.FlowsView_process_txt) {
                    processTxt = ta.getString(attr);
                }
            }
        } finally {
            if (ta != null) {
                ta.recycle();
            }
        }

        this.mInflater = LayoutInflater.from(context);

        initViews();
    }

    private void initViews() {
        rootView = mInflater.inflate(R.layout.view_flows, null);
        flowsGroup = (LinearLayout) rootView.findViewById(R.id.flows_group);
        processTextView = (TextView) rootView.findViewById(R.id.process);

        flowsGroup.setBackgroundResource(isMana ? R.mipmap.staff_arrow : R.mipmap.staff_arrow);

        processTextView.setBackgroundColor(isMana ? Color.parseColor(MANA_PROCESS_COLOR) : Color.parseColor(STAFF_PROCESS_COLOR));
        processTextView.setTextColor(isMana ? getContext().getResources().getColor(android.R.color.black)
                : getContext().getResources().getColor(android.R.color.white));
        if (!TextUtils.isEmpty(processTxt)) {
            processTextView.setText(processTxt);
        }

        addView(rootView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setProcessText(String text) {
        processTextView.setText(TextUtils.isEmpty(text) ? "" : text);
    }

    /**
     * 绑定数据，该方法必须在 view完全显示后才能调用，即view完全绘制完毕才能调用
     *
     * @param list
     */
    public void bindDatas(@NonNull List<FlowUtils.FlowBean> list) {
        flowsGroup.removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        if (oneFlowWidth == 0) {
            setFlowsGroupWidth(list.size());
        }
        for (FlowUtils.FlowBean flowBean : list) {
            View flowView = mInflater.inflate(R.layout.view_one_flow, null);
            ImageView icon = (ImageView) flowView.findViewById(R.id.icon);
            TextView flowName = (TextView) flowView.findViewById(R.id.flow_name);
            ImageView oneFlowArrow = (ImageView) flowView.findViewById(R.id.one_flow_arrow);

            icon.setImageResource(flowBean.getIconRes());
            flowName.setText(flowBean.getName());
            oneFlowArrow.setImageResource(isMana ? R.mipmap.staff_arrow_2 : R.mipmap.staff_arrow_1);

            flowsGroup.addView(flowView);
        }
    }

    /**
     * 设置flowsGroup大小
     *
     * @param i
     */
    private void setFlowsGroupWidth(int i) {
        if (flowsGroup == null) {
            return;
        }
        int allWidth = flowsGroup.getMeasuredWidth();
        oneFlowWidth = allWidth / 3;
        LayoutParams groupParams = (LayoutParams) flowsGroup.getLayoutParams();
//        groupParams.width = oneFlowWidth * i;
        groupParams.width = LayoutParams.WRAP_CONTENT;
        flowsGroup.setLayoutParams(groupParams);
    }

}
