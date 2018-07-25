package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AreaMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Area;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 9:52
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class AreaMapperTest {

    @Autowired
    private AreaMapper areaMapper;

    @Test
    public void getAreaTest() {
        List<Area> area = areaMapper.getArea(1);
        log.info("info is :" + area.size());
    }
}
