package com.util;


import com.example.use.ui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程图工具类
 * Created by cc on 2016/6/29.
 */
public class FlowUtils {

    //部门
    private static final String DP_BM = "dp_bm";
    //电商
    private static final String DP_DS = "dp_ds";
    //销售
    private static final String DP_XS = "dp_xs";
    //市场
    private static final String DP_MK = "dp_mk";
    //采购
    private static final String DP_CG = "dp_cg";
    //仓库
    private static final String DP_CK = "dp_ck";
    //行政
    private static final String DP_XZ = "dp_xz";
    //财务
    private static final String DP_CW = "dp_cw";
    //研发
    private static final String DP_YF = "dp_yf";
    //秘书
    private static final String DP_MS = "dp_ms";
    //生产
    private static final String DP_SC = "dp_sc";
    //总经办
    private static final String DP_ZJB = "dp_zjb";

    //流程key对应的名称
    private static final Map<String, String> mFlowNameMap = new HashMap<>();

    static {
        mFlowNameMap.clear();
        mFlowNameMap.put(DP_BM, "部门确认");
        mFlowNameMap.put(DP_DS, "电商确认");
        mFlowNameMap.put(DP_XS, "销售确认");
        mFlowNameMap.put(DP_MK, "市场确认");
        mFlowNameMap.put(DP_CG, "采购确认");
        mFlowNameMap.put(DP_CK, "仓库确认");
        mFlowNameMap.put(DP_XZ, "行政确认");
        mFlowNameMap.put(DP_CW, "财务确认");
        mFlowNameMap.put(DP_YF, "研发确认");
        mFlowNameMap.put(DP_MS, "秘书确认");
        mFlowNameMap.put(DP_SC, "生产确认");
        mFlowNameMap.put(DP_ZJB, "领导确认");
    }

    /**
     * 通过key获取名称
     *
     * @param key
     * @return
     */
    public static String getFlowName(String key) {
        if (mFlowNameMap.isEmpty()) {
            return null;
        }
        if (!mFlowNameMap.containsKey(key)) {
            return null;
        }
        return mFlowNameMap.get(key);
    }

    /**
     * 获取 FlowBean 数组
     *
     * @param flowMapList
     * @return
     */
    public static List<FlowBean> buildFlowList(List<Map<String, String>> flowMapList) {
        if (flowMapList == null || flowMapList.isEmpty()) {
            return null;
        }
        List<FlowBean> flowBeanList = new ArrayList<>();
        for (Map<String, String> flowMap : flowMapList) {
            if (flowMap == null || flowMap.isEmpty()) {
                continue;
            }
            String dp_key = getMapFirstKey(flowMap);
            if (null == dp_key || "".equals(dp_key) || !mFlowNameMap.containsKey(dp_key)) {
                continue;
            }
            String dp_name = mFlowNameMap.get(dp_key);
            String dp_state = flowMap.get(dp_key);


            FlowBean flowBean = new FlowBean();
            flowBean.setKey(dp_key);
            flowBean.setName(dp_name);
            flowBean.setState(dp_state);

            flowBeanList.add(flowBean);
        }

        if (flowBeanList.isEmpty()) {
            flowBeanList = null;
        }
        return flowBeanList;
    }

    /**
     * 获取map的第一个key
     *
     * @param map
     * @param <K>
     * @return
     */
    private static <K> K getMapFirstKey(Map<K, ? extends Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (K key : map.keySet()) {
            if (key != null) {
                return key;
            }
        }
        return null;
    }

    //流程实体类
    public static class FlowBean {
        private String key;
        private String state;
        private String name;
        private int iconRes;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
            if (null == state || "".equals(state)) {
                this.iconRes = R.mipmap.doing;
            }else if (state.equals("1")) {
                this.iconRes = R.mipmap.sure;
            } else if (state.equals("2")) {
                this.iconRes = R.mipmap.cancal;
            } else if (state.equals("3")){
                this.iconRes = R.mipmap.doing;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIconRes() {
            return iconRes;
        }
    }
}
