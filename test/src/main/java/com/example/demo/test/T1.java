package com.example.demo.test;

import java.math.BigDecimal;

public class T1 {
    public static void main(String[] args) {
//        BigDecimal divide = new BigDecimal(500).divide(new BigDecimal(6000), 2, BigDecimal.ROUND_HALF_DOWN);
//        BigDecimal bigDecimal = divide.setScale(2);
//        System.out.println("info is :" + bigDecimal);
//
//        BigDecimal d1 = new BigDecimal(0.1);
//        System.out.println("d1 is:" + d1);
//        BigDecimal d2 = new BigDecimal("0.1");
//        System.out.println("d2 is:" + d2);

        BigDecimal add = new BigDecimal("0.26").add(new BigDecimal("0.256")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("info is :" + add);
    }
}
