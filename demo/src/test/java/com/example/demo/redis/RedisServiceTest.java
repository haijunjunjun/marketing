package com.example.demo.redis;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 08 - 07 - 9:56
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

//    @Test
//    public void t1 (){
//        redisService.setKey("1","success");
//    }
}
