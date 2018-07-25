package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ActivityNoticeMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.ActivityNotice;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 15:11
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class ActivityNoticeMapperTest {

    @Autowired
    private ActivityNoticeMapper activityNoticeMapper;

    @Test
    public void getActivityNoticeInfoTest() {
        List<ActivityNotice> activityNoticeInfo = activityNoticeMapper.getActivityNoticeInfo(2);
        log.info("info is :" + activityNoticeInfo.size());
    }
}
