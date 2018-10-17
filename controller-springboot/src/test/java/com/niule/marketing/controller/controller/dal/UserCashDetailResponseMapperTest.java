package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.UserCashDetailResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.UserCashDetailResponse;
import com.niule.marketing.controller.controller.model.UserCashDetailRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 11:29
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class UserCashDetailResponseMapperTest {

    @Autowired
    private UserCashDetailResponseMapper userCashDetailResponseMapper;

    @Test
    public void t1() {
        UserCashDetailRequestModel userCashDetailRequestModel = new UserCashDetailRequestModel();
        List<UserCashDetailResponse> userCashDetailResponses = userCashDetailResponseMapper.searchUserCashDetail(userCashDetailRequestModel);
        log.info("userCashDetailResponses is :" + userCashDetailResponses.size());
    }
}
