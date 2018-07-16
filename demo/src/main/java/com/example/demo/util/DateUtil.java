package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String patternV1 = "yyyyMMdd";

    public static String dateStrV1(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(patternV1);
        return sdf.format(date);
    }
}
