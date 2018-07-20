package com.niule.yunjiagong.yunjiagong.redis;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 16:03
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void setKeyTest() {
        redisService.setKey("test", "success--info");
    }

    @Test
    public void getValue() {
        Object test = redisService.get("test");
        log.info("info is :" + test);
    }

    @Test
    public void deleteKey (){
        redisService.remove("test");
    }

}
