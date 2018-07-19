package com.niule.yunjiagong.yunjiagong.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haijun
 * @create 2018 - 07 - 19 - 18:05
 */
@Slf4j
public class AuthTokenFilter extends AbstractAuthenticationProcessingFilter {

    @Value("${token.header}")
    private String tokenHeader;
    @Value("${token.name}")
    private String tokenName;

    public AuthTokenFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String authToken = request.getHeader(tokenHeader);
        if (StringUtils.isEmpty(authToken)) {
            authToken = request.getParameter(tokenName);
        }
        log.info("start to check token");
        if (authToken == null) {
            throw new AuthenticationCredentialsNotFoundException("Access Token is not provided");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authToken, null);
        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String message;
        if (failed.getCause() != null) {
            message = failed.getCause().getMessage();
        } else {
            message = failed.getMessage();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes = objectMapper.writeValueAsBytes(message);
        response.getOutputStream().write(bytes);
    }


}
