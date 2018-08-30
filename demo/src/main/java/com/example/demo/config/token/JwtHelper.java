package com.example.demo.config.token;

import com.example.demo.redis.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 10:48
 */
@Service
public class JwtHelper {

    @Autowired
    private RedisService redisService;

    /**
     * parse token
     */
    public static Claims parseJwt(String jsonWebToken, String base64Security) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                .parseClaimsJws(jsonWebToken).getBody();
        return claims;
    }

    /**
     * create token
     *
     * @param name           keyId
     * @param userId
     * @param roleInfo
     * @param authInfo
     * @param audience       接收者
     * @param issuer         发行者
     * @param TTLMillis      过期时间(毫秒)
     * @param base64Security
     * @author haijun
     * @date 2016年10月18日 下午2:51:38
     */
    public String createJwt(String name, Integer userId, String roleInfo, List<String> authInfo,
                            String audience, String issuer, long TTLMillis, String base64Security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("name", name)
                .claim("userId", userId)
                .claim("roleInfo", roleInfo)
                .claim("authInfo", authInfo)
//                .claim("userType", userType)
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey)
                .setExpiration(DateUtils.addSeconds(new Date(), 60000));
        //添加Token过期时间
        long expMillis = nowMillis + TTLMillis;
        Date exp = new Date(expMillis);
//        if (TTLMillis >= 0) {
//            builder.setExpiration(exp).setNotBefore(now);
////            builder.setExpiration(exp);
//        }
        String token = builder.compact();
        redisService.set("token:user_" + userId.toString(), token, TTLMillis);
        return token;
    }

}
