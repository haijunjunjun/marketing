package com.niule.marketing.controller.controller.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 17:33
 */
public class DateUtils {

    public static String dateFormatV1 (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String format = sdf.format(date);
        return format;
    }

    public static String dateFormatV2 (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format;
    }
}
