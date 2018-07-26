package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 12:04
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class SignLogMapperTest {

    @Autowired
    private SignLogMapper signLogMapper;

    @Test
    public void saveSignLogTest() {
        int i = signLogMapper.saveSignLog(1, 3 + "", "用户签到", new Date());
        log.info("info is :" + i);
    }
}
