package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ThreadTest extends Thread {

    private int countDown = 5;
    private int threadNumber;
    private static int threadCount = 0;

    public ThreadTest() {
        threadNumber = ++threadCount;
        System.out.println("making" + threadNumber);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread" + threadNumber + "(" + countDown + ")");
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            new ThreadTest().start();
//        }
//        System.out.println("线程已全部启动!");
//        String timeInterval = getTimeInterval(new Date());
//        System.out.println(timeInterval);
        String info = getInfo();
        System.out.println("info is :" + info);
    }

    public static String getTimeInterval(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        // System.out.println("所在周星期日的日期：" + imptimeEnd);
        return imptimeBegin + "," + imptimeEnd;
    }

    public static String getInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        return format;
    }
}
