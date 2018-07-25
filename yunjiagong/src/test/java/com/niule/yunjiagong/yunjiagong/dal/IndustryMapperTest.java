package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.IndustryMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Industry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:34
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class IndustryMapperTest {

    @Autowired
    private IndustryMapper industryMapper;

    @Test
    public void getIndustryInfoTest() {
        List<Industry> industryInfo = industryMapper.getIndustryInfo();
        log.info("info is :" + industryInfo.size());
    }
}
