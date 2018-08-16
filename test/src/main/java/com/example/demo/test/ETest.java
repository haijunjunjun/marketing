package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 14 - 9:13
 */
public class ETest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Character> characterList = new ArrayList<>();
        for (int i = 65; i < 91; i++) {
            characterList.add((char) i);
        }
        for (int i = 0; i < characterList.size(); i++) {
            stringList.add(characterList.get(i).toString());
        }
        System.out.println(stringList.toString());
    }
}
