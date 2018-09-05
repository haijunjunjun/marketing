package com.example.demo.config.aliPay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 18:01
 */
@Data
@ConfigurationProperties(prefix = "alipay")
@Component
public class AliPayConfig {

    private String appId;

    private String pid;

    private String merchantId;

    private String rsaPrivate;

    private String aliPayPublic;

    private String url;

    private String signType;

    private String format;

    private String charset;
}
