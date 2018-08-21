package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.GoldBeansApplyMapper;
import com.example.demo.dal.model.GoldBeansApply;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 20 - 11:07
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class GoldBeansApplyMapperTest {

    @Autowired
    private GoldBeansApplyMapper goldBeansApplyMapper;

    @Test
    public void getGoldBeansApplyInfo() {
        List<GoldBeansApply> goldBeansApplyInfo = goldBeansApplyMapper.getGoldBeansApplyInfo(1);
        log.info("goldBeansApplyInfo info is :" + goldBeansApplyInfo);
    }
}
