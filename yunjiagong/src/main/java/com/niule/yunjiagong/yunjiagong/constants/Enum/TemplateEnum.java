package com.niule.yunjiagong.yunjiagong.constants.Enum;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 11:08
 */
public enum TemplateEnum {
    SIGN_TEMPLATE("签到模板", "1");

    private String name;
    private String code;

    TemplateEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
