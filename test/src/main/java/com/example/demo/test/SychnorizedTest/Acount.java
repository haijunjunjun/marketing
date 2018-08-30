package com.example.demo.test.SychnorizedTest;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 11:34
 */
public class Acount {
    private int count = 0;

    /**
     * 12      * 存钱
     * 13      * @param money
     * 14
     */
    public synchronized void addAcount(String name, int money) {
        // 存钱
        count += money;
        System.out.println(name + "...存入：" + money + "..." + Thread.currentThread().getName());
        SelectAcount(name);
    }

    /**
     * 25      * 取钱
     * 26      * @param money
     * 27
     */
    public synchronized void subAcount(String name, int money) {
        // 先判断账户现在的余额是否够取钱金额
        if (count - money < 0) {
            System.out.println("账户余额不足！");
            return;
        }
        // 取钱
        count -= money;
        System.out.println(name + "...取出：" + money + "..." + Thread.currentThread().getName());
        SelectAcount(name);
    }

    /**
     * 43      * 查询余额
     * 44
     */
    public void SelectAcount(String name) {
        System.out.println(name + "...余额：" + count);
    }
}
