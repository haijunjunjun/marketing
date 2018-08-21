package com.example.demo.config.token;

import com.example.demo.constant.ResultInfo;
import com.example.demo.model.CurOperator;
import com.example.demo.redis.RedisService;
import com.example.demo.util.ResultStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 11:08
 */
public class JwtAuthorizeFilter implements Filter {

    @Autowired
    private JwtInfo jwtInfo;

    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ResultInfo resultInfo = new ResultInfo();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            System.out.println("OPTIONS");
            HttpServletResponse rep = (HttpServletResponse) response;
            //设置允许跨域的配置
            // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
            rep.setHeader("Access-Control-Allow-Origin", "*");
            // 允许的访问方法
            rep.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
            // Access-Control-Max-Age 用于 CORS 相关配置的缓存
            rep.setHeader("Access-Control-Max-Age", "3600");
//            rep.setHeader("Access-Control-Allow-Headers", "*");
            rep.setHeader("Access-Control-Allow-Headers", "ACCESS_TOKEN,Content-Type,");
            chain.doFilter(request, response);
            return;
        }
        String auth = httpServletRequest.getHeader("ACCESS_TOKEN");
        if (auth != null && auth.length() > 7) {
//            String headStr = auth.substring(0, 6).toLowerCase();
//            if (headStr.compareTo("bearer") == 0) {
//                auth = auth.substring(7, auth.length());
            try {
                Claims claims = JwtHelper.parseJwt(auth, jwtInfo.getBase64Secret());
                if (claims != null) {
                    Integer userId = Integer.parseInt(claims.get("userId").toString());
                    if (redisService.exists("token:user_" + userId)&&auth.equals(redisService.get("token:user_"+userId))) {
                        CurOperator operator = new CurOperator();
                        operator.setId(userId);
                        operator.setRoleInfo(claims.get("roleInfo").toString());
                        operator.setAuthInfo(Arrays.asList(claims.get("authInfo").toString()));
//                    operator.setUserType(Integer.parseInt(claims.get("userType").toString()));
                        httpServletRequest.setAttribute("operator", operator);
                        chain.doFilter(request, response);
                        return;
                    }
                }
            } catch (Exception e) {
                //验证不通过
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setCharacterEncoding("UTF-8");
                httpResponse.setContentType("application/json; charset=utf-8");
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.setHeader("Access-Control-Allow-Origin", "*");
                resultInfo.setCode(ResultStatus.FAIL.getCode());
                resultInfo.setMessage(ResultStatus.FAIL.getMessage());
                ObjectMapper objectMapper = new ObjectMapper();
                httpResponse.getOutputStream().write(objectMapper.writeValueAsBytes(resultInfo));
                return;
            }

//            }
        }
        //验证不通过
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        resultInfo.setCode(ResultStatus.FAIL.getCode());
        resultInfo.setMessage(ResultStatus.FAIL.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        httpResponse.getOutputStream().write(objectMapper.writeValueAsBytes(resultInfo));
    }

    @Override
    public void destroy() {

    }
}
