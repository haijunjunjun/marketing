package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.model.http.HttpDonateUserGoldBeansResponseModel;
import com.example.demo.service.httpService.DanateUserGoldBeans;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 15:21
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DanateUserGoldBeansTest {

    @Autowired
    private DanateUserGoldBeans danateUserGoldBeans;

    @Test
    public void t1 () throws Exception {
        String str[] = new String[]{};
        List<String> stringList = Arrays.asList(str);
        for (int i = 0;i<stringList.size();i++){
            HttpDonateUserGoldBeansResponseModel httpDonateUserGoldBeansResponseModel = danateUserGoldBeans.donateUserGoldBeans(stringList.get(i), 6);
            log.info("赠送结果:"+httpDonateUserGoldBeansResponseModel.getSuccess());
        }

    }
}
