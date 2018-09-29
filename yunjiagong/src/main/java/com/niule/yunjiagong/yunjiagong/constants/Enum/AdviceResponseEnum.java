package com.niule.yunjiagong.yunjiagong.constants.Enum;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 14:18
 */
public enum  AdviceResponseEnum {

    FUNCTION("1","功能问题：功能异常或存在问题"),
    PRODUCT("2","产品问题：用的不爽，我有建议"),
    SECURITY("3","安全问题：密码、隐私、欺诈等"),
    OTHER("4","其他问题");

    private String code;
    private String name;

    AdviceResponseEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode (String code){
        for (AdviceResponseEnum adviceResponseEnum : AdviceResponseEnum.values()){
            if (code.equals(adviceResponseEnum.getCode())){
                return adviceResponseEnum.getName();
            }
        }
        return null;
    }
}
