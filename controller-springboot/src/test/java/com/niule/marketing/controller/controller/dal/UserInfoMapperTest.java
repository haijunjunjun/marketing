package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.UserInfoMapper;
import com.niule.marketing.controller.controller.dal.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 11:18
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void t1() {
        int maxUserId = userInfoMapper.getMaxUserId();
        log.info("maxUserId is :" + maxUserId);
    }

    @Test
    public void t2() {
        List<UserInfo> userInfos = userInfoMapper.fetchUserInfoByStatus();
        log.info("userInfos is :" + userInfos.size());
    }

    @Test
    public void t3() {
        List<UserInfo> userTeamInfo = userInfoMapper.getUserTeamInfo(1);
        log.info("userTeamInfo is :" + userTeamInfo.size());
    }
}
