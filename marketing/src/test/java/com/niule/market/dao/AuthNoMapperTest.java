package com.niule.market.dao;

import com.niule.market.MarketingApplication;
import com.niule.market.dao.mapper.AuthNoMapper;
import com.niule.market.dao.model.AuthNo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 08 - 01 - 18:01
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MarketingApplication.class)
public class AuthNoMapperTest {

    @Autowired
    private AuthNoMapper authNoMapper;

    @Test
    public void t1() {
        AuthNo authNo = new AuthNo();
        authNo.setQq("909411098");
        authNo.setWorkNo("001");
        authNo.setCreateTime(new Date());
        authNo.setAdvertId(1);
        int i = authNoMapper.insertSelective(authNo);
        System.out.println("info is :" + i);
    }
}
