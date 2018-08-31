package com.example.cache.rediscache.mq;

import com.example.cache.rediscache.config.MqProducerConfig;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author haijun
 * @create 2018 - 08 - 30 - 10:40
 */
@Component
public class MqProducer {

    @Autowired
    private MqProducerConfig mqProducerConfig;

    @Bean
    public DefaultMQProducer defaultMQProducer () throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
        defaultMQProducer.setProducerGroup(mqProducerConfig.getGroupName());
        defaultMQProducer.setNamesrvAddr(mqProducerConfig.getNamesrvAddr());
        defaultMQProducer.start();
    }
}
