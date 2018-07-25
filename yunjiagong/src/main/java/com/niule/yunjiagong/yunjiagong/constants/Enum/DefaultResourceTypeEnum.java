package com.niule.yunjiagong.yunjiagong.constants.Enum;

public enum DefaultResourceTypeEnum {
    V1("活信息列表图", "1"),
    V2("承接信息列表图", "2"),
    V3("用户头像图", "3"),
    V4("活信息详情banner图", "4"),
    V5("承接信息详情banner图", "5"),
    V6("分享出去的承接轮播图", "6"),
    V7("分享出去的发活轮播图", "7");

    private String name;
    private String value;

    DefaultResourceTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
