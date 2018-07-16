package com.example.demo.service;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class PerformanceConfigServiceTest {

    @Autowired
    private PerformanceConfigService performanceConfigService;

    @Test
    public void getLevelCodeTest() {
        String levelCode = performanceConfigService.getLevelCode(1);
        log.info("levelCode is :" + levelCode);
    }

    @Test
    public void getPerformanceConfigTest() {
        Map<String, Object> performanceConfig = performanceConfigService.getPerformanceConfig();
        log.info("performanceConfig is :" + performanceConfig);
    }

    @Test
    public void getWeekDaysTest() {
        String weekDays = performanceConfigService.getWeekDays(2);
        log.info("weekDays is :" + weekDays);
    }

    @Test
    public void calUserCommissionTest() {
        Double aDouble = performanceConfigService.calUserCommission(1);
        log.info("commissions is :" + aDouble);
    }
}
