package com.example.demo.test.SychnorizedTest;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 11:39
 */
public class ThreadDemo2 {
    public static void main(String[] args) {

        // 开个银行帐号
        Acount account = new Acount();
        // 开银行帐号之后银行给张银行卡
        Card card = new Card("card",account);
        // 开银行帐号之后银行给张存折
        Paper paper = new Paper("存折",account);

        Thread thread1 = new Thread(card);
        Thread thread2 = new Thread(paper);

        thread1.start();
        thread2.start();
    }
}
