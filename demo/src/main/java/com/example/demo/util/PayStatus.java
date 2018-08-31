package com.example.demo.util;

/**
 * @author haijun
 * @create 2018 - 08 - 28 - 17:09
 */
public enum PayStatus {
    PAY_SUCCESS("10000", "支付成功"),
    PAY_FAIL("40004", "支付失败"),
    WAIT_PAY("10003", "等待用户付款"),
    UNKNOWN("20000", "未知异常");

    private String code;
    private String message;

    PayStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
