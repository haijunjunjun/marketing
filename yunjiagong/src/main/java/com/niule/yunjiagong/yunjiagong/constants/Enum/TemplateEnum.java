package com.niule.yunjiagong.yunjiagong.constants.Enum;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 11:08
 */
public enum TemplateEnum {
    SIGN_TEMPLATE("签到第三天", "1"),
    SIGN_TEMPLATE_V1("签到第七天", "2");

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
