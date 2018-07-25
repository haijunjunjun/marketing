package com.niule.yunjiagong.yunjiagong.constants.Enum;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:53
 */
public enum NoticeTypeEnum {

    SALE("促销信息", "1"),
    NOTICE("系统公告", "2"),
    ACTIV_INFO("活跃信息", "3");

    private String name;
    private String code;

    NoticeTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
