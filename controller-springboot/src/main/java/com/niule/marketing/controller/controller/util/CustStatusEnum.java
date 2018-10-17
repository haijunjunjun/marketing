package com.niule.marketing.controller.controller.util;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 10:10
 */
public enum  CustStatusEnum {

    DOING(1,"待跟进"),
    HASCOMPACT(2,"已签约"),
    ABANDON(3,"已放弃"),
    DELETE(4,"已删除");

    private Integer code;
    private String name;

    CustStatusEnum(Integer code, String name) {
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
        for (CustStatusEnum custStatusEnum : CustStatusEnum.values()){
            if (code.equals(custStatusEnum.getCode())){
                return custStatusEnum.getName();
            }
        }
        return null;
    }
}
