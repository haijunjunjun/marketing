package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 14:48
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(0, "a");
        list.add(0, "b");
        System.out.println("info is :" + list.toString());
    }


}
