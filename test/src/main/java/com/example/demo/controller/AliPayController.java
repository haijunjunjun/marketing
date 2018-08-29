//package com.example.cache.rediscache.controller;
//
//import com.example.cache.rediscache.service.AliPayService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Description;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.Map;
//
///**
// * @author haijun
// * @create 2018 - 08 - 22 - 18:10
// */
//@Controller
//public class AliPayController {
//
//    @Autowired
//    private AliPayService aliPayService;
//
//    @Description("支付宝预支付接口")
//    @RequestMapping(value = "/marketing/ali/pay/precreate", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, String>> precreate() throws Exception {
//        return ResponseEntity.ok(aliPayService.precreate());
//    }
//
//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public ResponseEntity<String> test (){
//        return ResponseEntity.ok("success");
//    }
//}
