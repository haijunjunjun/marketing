package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.BannerMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Banner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:34
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class BannerMapperTest {

    @Autowired
    private BannerMapper bannerMapper;

    @Test
    public void getBannerTest() {
        List<Banner> banner = bannerMapper.getBanner(1);
        log.info("info is :" + banner.size());
    }
}
