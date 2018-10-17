package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.UserPerformanceResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.UserPerformanceResponse;
import com.niule.marketing.controller.controller.model.DateRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 13:26
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class UserPerformanceResponseMapperTest {

    @Autowired
    private UserPerformanceResponseMapper userPerformanceResponseMapper;

    @Test
    public void t1() {
        DateRequestModel dateRequestModel = new DateRequestModel();
        dateRequestModel.setUserId(3);
        List<UserPerformanceResponse> userPerformanceResponses = userPerformanceResponseMapper.searchUserActionInfo(dateRequestModel);
        log.info("userPerformanceResponses is :" + userPerformanceResponses.size());
    }
}
