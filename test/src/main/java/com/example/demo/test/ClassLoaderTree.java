package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class ClassLoaderTree {
    public static void main(String[] args) throws ParseException {
//        ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();
//        while (classLoader != null) {
//            log.info("classLoader is :" + classLoader.toString());
//            classLoader = classLoader.getParent();
//        }
//        System.out.println(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(getBeforeDay(new Date()));
    }

    public static Date getPreDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(date);
        return parse;
    }


    public static Date getBeforeDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }
}
