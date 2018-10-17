package com.niule.marketing.controller.controller.config.shiro;

import com.niule.marketing.controller.controller.service.BackgroundUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haijun
 * @create 2018 - 09 - 26 - 10:26
 */
@Slf4j
@Configuration
public class ShiroConfig {

    @Autowired
    private BackgroundUserService backgroundUserService;

    @Bean
    public ShiroFilterFactoryBean shirFilter (SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String,Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("myRolesAuthorizationFilter",new MyRolesAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setLoginUrl("/user/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

////        //游客，开发权限
////        filterChainDefinitionMap.put("/guest/**", "anon");
////        //用户，需要角色权限 “user”
////        filterChainDefinitionMap.put("/user/**", "roles[user]");
////        //管理员，需要角色权限 “admin”
////        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
//
//        Map<String, String> backUserRoleInfo = backgroundUserService.getBackUserRoleInfo();
//        for (Map.Entry m : backUserRoleInfo.entrySet()){
//                filterChainDefinitionMap.put(m.getKey().toString(), "myRolesAuthorizationFilter["+m.getValue().toString()+"]");
//        }
////        filterChainDefinitionMap.put("/market/user/commission/info", "myRolesAuthorizationFilter[super_manage,manage]");
//
//        //开放登陆接口
////        filterChainDefinitionMap.put("/user/login/V1", "anon");
//        filterChainDefinitionMap.put("/user/login", "anon");
//        //其余接口一律拦截
//        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
//        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        log.info("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager (){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public CustomRealm customRealm (){
        return new CustomRealm();
    }
}
