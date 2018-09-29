package com.niule.yunjiagong.yunjiagong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 10:29
 */
public class DateUtilV1 {

    private static String patternV1 = "yyyy-MM-dd HH:mm:ss";
    private static String patternV2 = "yyyy-MM-dd";
    private static String patternV3 = "yyyyMMdd";

    public static String dateV3 (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(patternV3);
        String format = sdf.format(date);
        return format;
    }
}
