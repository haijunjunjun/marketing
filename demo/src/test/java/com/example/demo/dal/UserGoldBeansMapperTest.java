package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.UserGoldBeansMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserGoldBeansMapperTest {

    @Autowired
    private UserGoldBeansMapper userGoldBeansMapper;

    @Test
    public void updateGoldBeansNumTest() {
        userGoldBeansMapper.updateGoldBeansNum(350, 1, new Date());
    }
}
