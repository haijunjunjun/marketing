package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.UserPerformanceMapper;
import com.example.demo.dal.model.UserPerformance;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserPerformanceMapperTest {

    @Autowired
    private UserPerformanceMapper userPerformanceMapper;

    @Test
    public void getPerformanceTest() {
        Integer performance = userPerformanceMapper.getPerformance(1, "20180702", "20180707");
        log.info("performance is :" + performance);
    }

    @Test
    public void getPerformanceListTest() {
        List<UserPerformance> userPerformanceList = userPerformanceMapper.getUserPerformanceList(1, "20180702", "20180707");
        log.info("userPerformanceList is :" + userPerformanceList.get(0).getId());
        log.info("userPerformanceList is :" + userPerformanceList.get(1).getId());
    }
}
