package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ConfigTemplateMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 14:03
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class ConfigTemplateMapperTest {

    @Autowired
    private ConfigTemplateMapper configTemplateMapper;

    @Test
    public void getChangeCountBytypeAndUserstatusTest (){
        List<Integer> changeCountBytypeAndUserstatus = configTemplateMapper.getChangeCountBytypeAndUserstatus(11, 2);
        log.info("changeCountBytypeAndUserstatus is :"+changeCountBytypeAndUserstatus.size());
    }
}
