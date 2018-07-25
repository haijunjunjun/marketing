package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SortTypeMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.SortType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:53
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class SortTypeMapperTest {

    @Autowired
    private SortTypeMapper sortTypeMapper;

    @Test
    public void getSortTypeTest() {
        List<SortType> sortType = sortTypeMapper.getSortType();
        log.info("info is :" + sortType.size());
    }
}
