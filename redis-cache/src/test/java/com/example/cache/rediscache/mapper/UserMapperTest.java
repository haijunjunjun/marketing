package com.example.cache.rediscache.mapper;

import com.example.cache.rediscache.RedisCacheApplication;
import com.example.cache.rediscache.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 10:56
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisCacheApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void t1() {
        UserInfo userInfo = userMapper.getUserInfo(1);
        log.info("userInfo is :" + userInfo.toString());
    }

    @Test
    public void test2() {
        List<String> mobile = new ArrayList<>();//2002
        int i = 1000;

        final Integer begin = 0;
        final Integer end = i;
        int countThread = (mobile.size() - mobile.size() % i) / i;
        for (int j = 0; j < countThread; j++) {
            new Runnable() {
                @Override
                public void run() {
                    Integer c2 = userMapper.getUserListInfoV1(begin, end);
                }
            };
            if (mobile.size() % i != 0) {

            }
        }


    }
}
