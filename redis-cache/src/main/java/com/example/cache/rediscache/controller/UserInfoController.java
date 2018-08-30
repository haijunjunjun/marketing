package com.example.cache.rediscache.controller;

import com.example.cache.rediscache.model.UserInfo;
import com.example.cache.rediscache.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 11:22
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserInfo> getUserInfo() {
        return ResponseEntity.ok(userInfoService.getUserInfo());
    }

//    @RequestMapping(value = "/user/data", method = RequestMethod.GET)
//    public ResponseEntity<List<UserInfo>> getUserListInfo() {
//        return ResponseEntity.ok(userInfoService.getUserListInfo());
//    }
}
