package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.CustGoldBeansMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CustGoldBeansMapperTest {

    @Autowired
    private CustGoldBeansMapper custGoldBeansMapper;

    @Test
    public void updateCustGoldBeansTest() {
        int i = custGoldBeansMapper.updateCustGoldBeans(7, 12);
        log.info("result is :" + i);
    }
}
