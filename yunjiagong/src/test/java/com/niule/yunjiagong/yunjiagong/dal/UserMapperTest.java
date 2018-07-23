package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.UserMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 07 - 23 - 10:07
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserInfo() {
        User user = userMapper.selectByPrimaryKey(1);
        log.info("info is :" + user.getName());
    }

    @Test
    public void getInfoTest() {
        User info = userMapper.getInfo(1);
        log.info("info is :" + info.getName());
    }
}
