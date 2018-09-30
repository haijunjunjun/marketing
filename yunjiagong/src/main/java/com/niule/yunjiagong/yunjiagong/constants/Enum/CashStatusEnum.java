package com.niule.yunjiagong.yunjiagong.constants.Enum;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 11:18
 */
public enum  CashStatusEnum {

    WAIT(1,"待审核"),
    CHECK_SUCCESS(2,"审核成功"),
    CHECK_FAIL(3,"审核失败");

    private Integer code;
    private String name;

    CashStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
