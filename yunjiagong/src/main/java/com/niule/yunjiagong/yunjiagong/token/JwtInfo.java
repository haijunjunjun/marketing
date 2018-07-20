package com.niule.yunjiagong.yunjiagong.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 10:26
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt.info")
@PropertySource("classpath:/jwt/jwt.properties")
public class JwtInfo {

    private String clientId;
    private String base64Secret;
    private String name;
    private String expiresSecond;
}
