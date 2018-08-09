package com.example.demo.config;

import com.example.demo.config.annotation.Operator;
import com.example.demo.model.CurOperator;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author haijun
 * @create 2018 - 07 - 23 - 18:10
 */
public class OperatorMethodArgumentResover implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(CurOperator.class) && parameter.hasParameterAnnotation(Operator.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        CurOperator curOperator = (CurOperator) webRequest.getAttribute("operator", RequestAttributes.SCOPE_REQUEST);
        if (curOperator != null) {
            return curOperator;
        }
        throw new MissingServletRequestPartException("curOperator");
    }
}
