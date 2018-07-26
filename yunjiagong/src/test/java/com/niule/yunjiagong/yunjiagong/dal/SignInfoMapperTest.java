package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 11:18
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class SignInfoMapperTest {

    @Autowired
    private SignInfoMapper signInfoMapper;

    @Test
    public void saveSignInfoTest() {
        int i = signInfoMapper.saveSignInfo(1, new Date(), 2);
        log.info("info is :" + i);
    }

    @Test
    public void updateSignInfoTest() {
        int i = signInfoMapper.updateSignInfo(1, new Date(), new Date(), 6);
        log.info("info is :" + i);
    }
}
