package com.example.demo.config;

import com.example.demo.config.token.AuthInterceptor;
import com.example.demo.config.token.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class AppAuthConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public AuthInterceptor getInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(getInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/market/**");
        // 配置不拦截的路径
//        ir.excludePathPatterns("**/swagger-ui.html");
        // 还可以在这里注册其它的拦截器
//        registry.addInterceptor(new AppAuthInterceptor()).addPathPatterns("/api/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }
}
