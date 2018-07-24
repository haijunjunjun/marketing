package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ProvinceMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 24 - 18:17
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class ProvinceMapperTest {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Test
    public void getProvinceTest() {
        List<Province> province = provinceMapper.getProvince();
        log.info("info is :" + province.size());
    }
}
