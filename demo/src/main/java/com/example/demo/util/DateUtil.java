package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String patternV1 = "yyyyMMdd";
    private static final String patternV2 = "yyyy-MM-dd HH:mm:ss";
    private static final String patternV3 = "yyyy";
    private static final String patternV4 = "MM-dd HH:mm";
    private static final String patternV5 = "yyyy-MM-dd";
    private static final String patternV6 = "yyyyMMddHHmm";

    public static String dateStrV1(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV1);
        return sdf.format(date);
    }

    public static String dateStrV2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV2);
        return sdf.format(date);
    }

    public static Date dateStrV3(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV2);
        return sdf.parse(date);
    }

    public static String dateStrV4(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(patternV3);
        String format = sdf.format(date);
        return format;
    }

    public static String dateStrV5 (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(patternV4);
        return sdf.format(date);
    }

    public static String dateStrV6 (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(patternV5);
        return sdf.format(date);
    }

    public static Date dateStrV7 (String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV6);
        return sdf.parse(date);
    }

    public static Date dateStrV8(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV1);
        return sdf.parse(date);
    }
}
