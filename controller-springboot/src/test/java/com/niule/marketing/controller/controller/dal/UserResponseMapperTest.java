package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.UserResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.UserResponse;
import com.niule.marketing.controller.controller.model.UserSearchRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 17:39
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class UserResponseMapperTest {

    @Autowired
    private UserResponseMapper userResponseMapper;

    @Test
    public void t1() {
        UserSearchRequestModel userSearchRequestModel = new UserSearchRequestModel();
        userSearchRequestModel.setUserRealName("海军");
        List<UserResponse> userResponses = userResponseMapper.searchUserInfo(userSearchRequestModel);
        log.info("userResponses is :" + userResponses);
    }
}
