package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.UserActionResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.UserActionResponse;
import com.niule.marketing.controller.controller.model.UserActionRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 10:17
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class UserActionResponseMapperTest {

    @Autowired
    private UserActionResponseMapper userActionResponseMapper;

    @Test
    public void t1() {
        UserActionRequestModel userActionRequestModel = new UserActionRequestModel();
        userActionRequestModel.setUserId(4);
        List<String> actions = new ArrayList<>();
        List<UserActionResponse> userActionResponseList = userActionResponseMapper.searchUserActionInfo(userActionRequestModel.getUserId(),userActionRequestModel.getCustName(),userActionRequestModel.getStartTime(),userActionRequestModel.getEndTime(),actions);
        log.info("userActionResponseModelList is :" + userActionResponseList.size());
    }
}
