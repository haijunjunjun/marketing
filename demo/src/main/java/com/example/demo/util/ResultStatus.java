package com.example.demo.util;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 11:21
 */
public enum ResultStatus {
    SUCCESS("200", "token验证通过"),
    FAIL("401", "无效token");

    private String code;
    private String message;

    ResultStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
