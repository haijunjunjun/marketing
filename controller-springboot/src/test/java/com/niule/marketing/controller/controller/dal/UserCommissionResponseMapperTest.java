package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.UserCommissionResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.UserCommissionResponse;
import com.niule.marketing.controller.controller.model.UserCommissionRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 15:12
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class UserCommissionResponseMapperTest {

    @Autowired
    private UserCommissionResponseMapper userCommissionResponseMapper;

    @Test
    public void t1() {
        UserCommissionRequestModel userCommissionRequestModel = new UserCommissionRequestModel();
        List<UserCommissionResponse> userCommissionResponses = userCommissionResponseMapper.searchUserCommission(userCommissionRequestModel);
        log.info("userCommissionResponses is :" + userCommissionResponses);
    }
}
