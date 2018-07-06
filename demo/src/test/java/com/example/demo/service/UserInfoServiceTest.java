package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.model.UserRole;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by haijun on 2018/7/3.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void t1() {
        List<UserInfo> userInfo = userInfoService.getUserInfo();
        log.info("user info is :" + userInfo.get(0).getRealName());
    }

    @Test
    public void loginTest() {
        String userId = "18306845521";
        String passWord = "123456";
        MessageInfo<UserRole> login = userInfoService.login(userId, passWord);
        log.info("login result is :" + login);
    }

    @Test
    public void getRoleInfoTest() {
        String roleInfo = userInfoService.getRoleInfo(1);
        log.info("role info is :" + roleInfo);
    }

    @Test
    public void validPhone() {
        boolean b = userInfoService.checkMobileNumber("18306845521");
        log.info("valid info is :" + b);
    }

}
