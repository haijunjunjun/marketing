package com.niule.yunjiagong.yunjiagong.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niule.yunjiagong.yunjiagong.config.ResultStatus;
import com.niule.yunjiagong.yunjiagong.constants.ResultInfo;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 11:08
 */
public class JwtAuthorizeFilter implements Filter {

    @Autowired
    private JwtInfo jwtInfo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ResultInfo resultInfo = new ResultInfo();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String auth = httpServletRequest.getHeader("Authorization");
        if (auth != null && auth.length() > 7) {
            String headStr = auth.substring(0, 6).toLowerCase();
            if (headStr.compareTo("bearer") == 0) {
                auth = auth.substring(7, auth.length());
                Claims claims = JwtHelper.parseJwt(auth, jwtInfo.getBase64Secret());
                if (claims != null) {
                    CurOperator operator = new CurOperator();
                    operator.setUserId(claims.get("userId").toString());
                    operator.setRole(claims.get("role").toString());
                    httpServletRequest.setAttribute("operator", operator);
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        //验证不通过
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        resultInfo.setCode(ResultStatus.FAIL.getCode());
        resultInfo.setMessage(ResultStatus.FAIL.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        httpResponse.getOutputStream().write(objectMapper.writeValueAsBytes(resultInfo));
    }

    @Override
    public void destroy() {

    }
}
