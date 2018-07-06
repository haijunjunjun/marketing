package com.example.demo.config.token;

import com.example.demo.config.annotation.IgnoreSecurity;
import com.example.demo.dal.model.TokenInfo;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String requestPath = request.getRequestURI();
        if (requestPath.contains("/v2/api-docs") || requestPath.contains("/swagger") || requestPath.contains("/configuration/ui")) {
            return true;
        }
        if (requestPath.contains("/error")) {
            return true;
        }
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }
        String accessToken = request.getHeader("ACCESS_TOKEN");
        if (StringUtils.isEmpty(accessToken)) {
            log.info("access token is null !");
            throw new BizRuntimeException("access token is null !");
        }
        TokenInfo tokenInfo = userInfoService.getTokenInfo(accessToken);
        if (!Objects.isNull(tokenInfo) && System.currentTimeMillis() - tokenInfo.getExpiredTime().getTime() > 0) {
            log.info("token 已过期，请重新登录");
            throw new BizRuntimeException("token 已过期，请重新登录");
        }

        UserInfo userInfo = userInfoService.getUserInfo(accessToken);
        request.setAttribute("currentUser", userInfo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
