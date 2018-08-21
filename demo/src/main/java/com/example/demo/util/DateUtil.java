package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String patternV1 = "yyyyMMdd";
    private static final String patternV2 = "yyyy-MM-dd HH:mm:ss";

    public static String dateStrV1(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV1);
        return sdf.format(date);
    }

    public static String dateStrV2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV2);
        return sdf.format(date);
    }
}
