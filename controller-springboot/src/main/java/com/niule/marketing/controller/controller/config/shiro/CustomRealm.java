package com.niule.marketing.controller.controller.config.shiro;

import com.niule.marketing.controller.controller.dal.mapper.BackgroundUserInfoMapper;
import com.niule.marketing.controller.controller.service.BackgroundUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author haijun
 * @create 2018 - 09 - 26 - 10:44
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private BackgroundUserInfoMapper backgroundUserInfoMapper;
    @Autowired
    private BackgroundUserService backgroundUserService;

    /**
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("开始进行权限认证");
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> roleNameList = backgroundUserService.getRoleNameList(userName);
        Set<String> set = new HashSet<>();
        if (!Objects.isNull(roleNameList) && roleNameList.size() != 0){
            roleNameList.forEach(s -> {
                set.add(s);
            });
        }
        simpleAuthorizationInfo.setRoles(set);
        return simpleAuthorizationInfo;
    }


    /**
     * 获取身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("开始进行身份认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userPassword = backgroundUserService.getUserPassword(token.getUsername());
        if (userPassword == null) {
            throw new AccountException("用户名不正确");
        }
        if (!userPassword.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), userPassword, getName());
    }
}
