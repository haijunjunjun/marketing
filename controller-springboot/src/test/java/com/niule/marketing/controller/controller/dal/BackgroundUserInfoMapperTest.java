package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.BackgroundUserInfoMapper;
import com.niule.marketing.controller.controller.dal.model.BackgroundUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 09 - 21 - 11:02
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class BackgroundUserInfoMapperTest {

    @Autowired
    private BackgroundUserInfoMapper backgroundUserInfoMapper;

    @Test
    public void t1() {
        BackgroundUserInfo backgroundUserInfo = new BackgroundUserInfo();
        backgroundUserInfo.setUserName("haijun");
        int insert = backgroundUserInfoMapper.insert(backgroundUserInfo);
        log.info("insert is :" + insert);
    }
}
