package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.model.MyPerformanceModel;
import com.example.demo.util.PerformanceMessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 11:07
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MyServiceTest {

    @Autowired
    private MyService myService;

//    @Test
//    public void t1() {
//        PerformanceMessageInfo<List<MyPerformanceModel>> myPerformanceInfo = myService.getMyPerformanceInfo(1, new Date());
//        System.out.print(myPerformanceInfo);
//    }
}
