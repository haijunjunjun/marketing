package com.example.cache.rediscache.controller;

import com.example.cache.rediscache.service.AliPayServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 08 - 28 - 14:02
 */
@RestController
public class AliPayControllerV1 {

    @Autowired
    private AliPayServiceV1 aliPayServiceV1;

    @RequestMapping(value = "/alipay/precreate", method = RequestMethod.POST)
    public ResponseEntity<String> aliPayPrecreate() throws Exception {
        return ResponseEntity.ok(aliPayServiceV1.aliPayPrecreate());
    }
}
