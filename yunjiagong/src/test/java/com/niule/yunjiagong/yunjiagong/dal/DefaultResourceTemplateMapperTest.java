package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.DefaultResourceTemplateMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.DefaultResourceTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 16:24
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class DefaultResourceTemplateMapperTest {

    @Autowired
    private DefaultResourceTemplateMapper defaultResourceTemplateMapper;

    @Test
    public void getDefaultResourceTemplate() {
        List<DefaultResourceTemplate> defaultResourceTemplate = defaultResourceTemplateMapper.getDefaultResourceTemplate();
        log.info("info is :" + defaultResourceTemplate.get(0).getResourceUrl());
    }
}
