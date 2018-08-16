package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.UserInfoMapper;
import com.example.demo.util.DateUtil;
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
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void validNewTest() {
        Integer integer = userInfoMapper.validNew(1, "20180709", DateUtil.dateStrV1(new Date()));
        log.info("result is :" + integer);
    }

    @Test
    public void removeTest() {
        Integer remove = userInfoMapper.remove(3);
        log.info("remove info is :" + remove);
    }
}
