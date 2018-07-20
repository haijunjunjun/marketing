package com.niule.yunjiagong.yunjiagong.token;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 11:40
 */
@Configuration
public class JwtConfig {

    @Bean
    public FilterRegistrationBean basicFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtAuthorizeFilter filter = new JwtAuthorizeFilter();
        registrationBean.setFilter(filter);

        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/user/*");

        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;

    }
}