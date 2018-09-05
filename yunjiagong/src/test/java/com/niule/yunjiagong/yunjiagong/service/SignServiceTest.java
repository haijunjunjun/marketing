package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.model.SignTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 09 - 03 - 15:50
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class SignServiceTest {

    @Autowired
    private SignService signService;

    @Test
    public void t1 (){
        SignTemplate signTemplate = signService.getSignTemplate();
        log.info("signTemplate is :"+signTemplate);
    }
}
