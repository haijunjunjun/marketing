package com.example.demo.util;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 14:14
 */
public enum  CustBaseAction {

    CONTACT("1","已联系"),
    VISIT("2","已拜访"),
    INTEREST("3","有意向");

    private String code;
    private String name;

    CustBaseAction(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(String code){
        for (CustBaseAction custBaseAction : CustBaseAction.values()){
            if (code.equals(custBaseAction.getCode())){
                return custBaseAction.getName();
            }
        }
        return null;
    }
}
