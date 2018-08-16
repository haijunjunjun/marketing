package com.example.demo.util;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 17:10
 */
public enum CustomerUtil {

    DONATE_CUST_GOLD_BEANS("donate_cust_gold_beans");

    private String name;

    CustomerUtil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
