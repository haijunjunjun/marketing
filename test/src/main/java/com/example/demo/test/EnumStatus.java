package com.example.demo.test;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 9:01
 */
public enum EnumStatus {

    SUCCESS("成功", "1"),
    FAIL("失败", "0");

    private String name;
    private String value;

    EnumStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
