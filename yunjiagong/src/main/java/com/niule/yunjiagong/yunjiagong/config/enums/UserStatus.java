package com.niule.yunjiagong.yunjiagong.config.enums;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 11:18
 */
public enum UserStatus {

    REGISTER_USER(1, "注册用户"),
    PERSONAL_IDENTIFY(2, "个人认证"),
    COMMUNITY_IDENTITY(3, "企业认证");

    private Integer userStatus;
    private String statusDesc;

    UserStatus(Integer userStatus, String statusDesc) {
        this.userStatus = userStatus;
        this.statusDesc = statusDesc;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public String getStatusDesc() {
        return statusDesc;
    }
}
