package com.niule.marketing.controller.controller.util;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 18:04
 */
public enum  RoleNameEnum {

    MARKET(1,"销售人员"),
    MANAGE(2,"城市经理"),
    MONITOR(3,"组长");

    private Integer code;
    private String name;

    RoleNameEnum(Integer code, String name) {
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
        for (RoleNameEnum roleNameEnum : RoleNameEnum.values()){
            if (code.equals(roleNameEnum.getCode())){
                return roleNameEnum.getName();
            }
        }
        return null;
    }
}
