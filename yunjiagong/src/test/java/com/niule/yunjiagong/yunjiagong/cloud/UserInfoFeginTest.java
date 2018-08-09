package com.niule.yunjiagong.yunjiagong.cloud;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 15:25
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class UserInfoFeginTest {

    @Autowired
    private UserInfoFegin userInfoFegin;

    @Test
    public void getLoginStatusTest() {
//        DataResponse loginStatus = userInfoFegin.getLoginStatus();
        log.info("loginStatus is :" + userInfoFegin.getLoginStatus());
        System.out.println("Ss");
    }
}
