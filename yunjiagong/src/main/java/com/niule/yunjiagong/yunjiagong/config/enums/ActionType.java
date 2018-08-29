package com.niule.yunjiagong.yunjiagong.config.enums;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 11:34
 */
public enum ActionType {

    SEND_WORK_CREDIBILITY(0, "发活审核加信誉度"),
    SEND_WORK_BEANS(1, "发活审核加金豆"),
    WORK_INFO_LIMIT(2, "活信息发布上限"),
    USER_CHECK_BEANS(3, "审核用户加金豆"),
    WORK_INFO_ENJOY(4, "活信息分享朋友圈"),
    WORK_INFO_VIEW_PHONE(5, "活信息查看电话"),
    USER_CHECK_CREDIBILITY(6, "用户审核加信誉度"),
    USER_COMPLAINTED_CREDIBILITY(7, "用户被投诉减信誉度"),
    SEND_CHENGJIE_CHECK_CREDIBILITY(8, "发承接审核加信誉度"),
    WORK_INFO_SUBSCRIBE(9, "活信息订阅设置"),
    PUSH_NUM_LIMIT(10, "推送条数上限设置"),
    CASH_LOW_AMOUNT(11, "提现最低金额设置"),
    CHENGJIE_INFO_ENJOY(12, "承接信息分享朋友圈"),
    CHENGJIE_INFO_VIEW(13, "查看承接信息上限"),
    CASH_RATE(14, "提现费率设置");

    private Integer type;
    private String typeDesc;

    ActionType(Integer type, String typeDesc) {
        this.type = type;
        this.typeDesc = typeDesc;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }
}
