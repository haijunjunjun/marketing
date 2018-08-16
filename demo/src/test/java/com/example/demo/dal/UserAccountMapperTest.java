package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.UserAccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserAccountMapperTest {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Test
    public void updateUserAccountTest() {
        int i = userAccountMapper.updateUserAccount(1, +300.13);
        log.info("info is :" + i);
    }

    @Test
    public void updateBankNoTest() {
        int i = userAccountMapper.updateBankNo(1, "6217");
        log.info("info is :" + i);
    }
}
