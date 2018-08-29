package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.CityMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.City;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 9:22
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void getCityTest() {
        List<City> city = cityMapper.getCity(1);
        log.info("info si :" + city.size());
    }

    @Test
    public void getCityByNameTest() {
        City city = cityMapper.getCityByName("临汾");
        log.info("city is :" + city.getCity());
    }
}
