package com.niule.yunjiagong.yunjiagong.config.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author haijun
 * @create 2018 - 08 - 14 - 18:20
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


}
