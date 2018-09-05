package com.example.demo.constant;

/**
 * @author haijun
 * @create 2018 - 08 - 16 - 9:53
 */
public enum ActionStatus {

    VISIT(1,"visit","已拜访"),
    PHONE(2,"phone","已打电话"),
    MONEY(3,"money","已付款"),
    INTEREST(4,"interest","有意向客户"),
    BEANS(5,"beans","已赠送金豆"),
    COMPACT(6,"compact","已签合同");

    private Integer code;
    private String name;
    private String desc;

    ActionStatus(Integer code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
