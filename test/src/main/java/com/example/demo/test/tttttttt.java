package com.example.demo.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 17 - 11:45
 */
public class tttttttt {

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = sdf.format(" ");
//        System.out.println("format:" + format);
//        Date parse = sdf.parse(format);
//        System.out.println("parse" + parse);

//        test();
//        System.out.println("  "+new BigDecimal("1").divide(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        t2();
    }

    public static void test() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("this is " + i);
            if ("b".equals(stringList.get(i))) {
                System.out.println("this is " + stringList.get(i));
                return;
            }
        }
    }

    public static void t2() {
        String str = "山西省";
        String str1 = str.substring(str.trim().length() - 1, str.trim().length());
        if ("省".equals(str1)) {

        }
        System.out.println(str1);
    }
}
