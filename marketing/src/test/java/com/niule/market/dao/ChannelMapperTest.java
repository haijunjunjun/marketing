package com.niule.market.dao;

import com.niule.market.MarketingApplication;
import com.niule.market.dao.mapper.ChannelMapper;
import com.niule.market.dao.model.Channel;
import com.niule.market.service.AdvertService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 07 - 27 - 15:21
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MarketingApplication.class)
public class ChannelMapperTest {

    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private AdvertService advertService;

    @Test
    public void getChannelValue() {
        Channel channel = channelMapper.selectByPrimaryKey(1);
        log.info("info is :" + channel.getValue());
        System.out.println("info is :" + channel.getValue());
    }

    @Test
    public void test() {
        String channel = advertService.getChannel(1);
        log.info("info is :" + channel);
        System.out.println("info is :" + channel);
    }
}
