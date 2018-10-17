package com.niule.marketing.controller.controller.util;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 18:00
 */
public enum  MarketLevelStatusEnum {

    LOW("low","P1"),
    MID("mid","P2"),
    HIGH("high","P3");

    private String code;
    private String name;

    MarketLevelStatusEnum(String code, String name) {
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
        for (MarketLevelStatusEnum marketLevelStatusEnum : MarketLevelStatusEnum.values()){
            if (code.equals(marketLevelStatusEnum.getCode())){
                return marketLevelStatusEnum.getName();
            }
        }
        return null;
    }

    public static String getCodeByName(String name){
        for (MarketLevelStatusEnum marketLevelStatusEnum : MarketLevelStatusEnum.values()){
            if (name.equals(marketLevelStatusEnum.getName())){
                return marketLevelStatusEnum.getCode();
            }
        }
        return null;
    }
}
