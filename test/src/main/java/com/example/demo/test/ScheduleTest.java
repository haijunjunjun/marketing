package com.example.demo.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author haijun
 * @create 2018 - 08 - 09 - 19:01
 */
@Component
public class ScheduleTest {

//    @Scheduled(cron = "0 23 9 ? * FRI")
//    public void schedule (){
//
//        long startTime = System.currentTimeMillis();
//
//        for (int i = 0;i<100;i++){
//            System.out.println("success_"+i);
//        }
//
//        long endTime = System.currentTimeMillis();
//
//        float seconds = (endTime - startTime) / 1000F;
//        System.out.println(Float.toString(seconds) + " seconds.");
//
//        System.out.println("success");
//    }

    @Scheduled(cron = "0 34 9 ? * FRI")
    public void schedule() {

        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();

        float seconds = (endTime - startTime) / 1000F;
        System.out.println(Float.toString(seconds) + " seconds.");

        System.out.println("success");
    }
}
