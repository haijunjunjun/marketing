package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CustomerInfoMapperTest {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Test
    public void getMonthNumTest() {
        Integer monthNum = customerInfoMapper.getMonthNum(1, "201807");
        log.info("monthNum is :" + monthNum);
    }

    @Test
    public void getWeekNumTest() {
        Integer weekNum = customerInfoMapper.getWeekNum(1, "20180709", "20180715");
        log.info("weekNum is :" + weekNum);
    }
}
