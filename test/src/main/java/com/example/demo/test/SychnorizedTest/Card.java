package com.example.demo.test.SychnorizedTest;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 11:36
 */
public class Card implements Runnable {
    private String name;
    private Acount account = new Acount();

    public Card(String name, Acount account) {
        this.account = account;
        this.name = name;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.addAcount(name, 100);
        }
    }

}
