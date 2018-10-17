package com.niule.marketing.controller.controller.util;

/**
 * @author haijun
 * @create 2018 - 09 - 27 - 16:35
 */
public enum  CashStatusEnum {

    WAITCHECK(0,"待审核"),
    CHECKED(1,"审核通过"),
    CHECKFAIL(2,"审核失败"),
    HASMONEY(3,"已打款"),
    NOMONEY(4,"未打款");

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

    public static String getNameByCode(Integer code){
        for (CashStatusEnum cashStatusEnum : CashStatusEnum.values()){
            if (code == cashStatusEnum.getCode()){
                return cashStatusEnum.getName();
            }
        }
        return null;
    }
}
