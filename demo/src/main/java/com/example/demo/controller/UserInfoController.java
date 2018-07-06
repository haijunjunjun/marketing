package com.example.demo.controller;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<UserRole>> login(@Valid @NotNull @RequestParam("phone") String phone,
                                                       @Valid @NotNull @RequestParam("pass") String passWord) {
        return ResponseEntity.ok(userInfoService.login(phone, passWord));
    }

    @ResponseBody
    @RequestMapping(value = "/market/test", method = RequestMethod.POST)
    public String test(@Valid @CurrentUser UserInfo userInfo) {
        return userInfoService.getOpeator(userInfo);
    }
}
