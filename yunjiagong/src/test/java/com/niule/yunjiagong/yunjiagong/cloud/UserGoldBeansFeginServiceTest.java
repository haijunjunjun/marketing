package com.niule.yunjiagong.yunjiagong.cloud;

import com.netflix.discovery.converters.Auto;
import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.model.cloud.SystemPayRequest;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserGoldBeansFeginService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 08 - 30 - 11:03
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class UserGoldBeansFeginServiceTest {

    @Autowired
    private UserGoldBeansFeginService userGoldBeansFeginService;

    @Test
    public void test (){
        DataResponse dataResponse = userGoldBeansFeginService.updateUserGoldBeans(new SystemPayRequest());
        log.info("dataResponse is :"+dataResponse.getData().toString());
    }
}
