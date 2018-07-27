package com.niule.market.constants.enums;

public enum AdvertTypeEnum {
    EWM("二维码", "1"),
    URL("链接", "2"),
    ALL("显示所有信息", "3");

    private String name;
    private String code;

    AdvertTypeEnum(String name, String code) {
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
