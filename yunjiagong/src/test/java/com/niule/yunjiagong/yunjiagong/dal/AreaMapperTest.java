package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AreaMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Area;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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

    @Test
    public void updateTest() {
        List<Area> areas = areaMapper.selectAll();
        for (Area a : areas) {
            String area = a.getArea();
            String str1 = area.substring(area.trim().length() - 1, area.trim().length());
            if ("区".equals(str1)) {
                Area areaV1 = new Area();
                areaV1.setId(a.getId());
                areaV1.setIsShow("0");
                int i = areaMapper.updateByPrimaryKeySelective(areaV1);
                if (1 != i) {
                    log.info(a.getId() + "---报错");
                    throw new BizRuntimeException(a.getId() + ":报错");
                }
            }
        }
    }

    @Test
    public void getAreaByCityIdsTest() {
        List<Integer> cityIds = new ArrayList<>();
        cityIds.add(110100);
        cityIds.add(120100);
        cityIds.add(130100);
        Integer countCity = areaMapper.getAreaByCityIds(cityIds, "市辖区");
        log.info("countCity is :" + countCity);
    }

    @Test
    public void getAreaByCityIdTest() {
        Integer countCity = areaMapper.getAreaByCityId(110100, "市辖区");
        log.info("countCity is :" + countCity);
    }
}
