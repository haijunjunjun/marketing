package com.example.cache.rediscache.service;

import com.example.cache.rediscache.RedisCacheApplication;
import com.example.cache.rediscache.config.AliPayConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 18:03
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisCacheApplication.class)
public class TestService {

    @Autowired
    private AliPayConfig aliPayConfig;

    @Test
    public void t1() {
        System.out.println("appid is :" + aliPayConfig.getAppID());
    }
}
