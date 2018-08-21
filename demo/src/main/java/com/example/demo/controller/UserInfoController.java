package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.model.CurOperator;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.DataResponse;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Description("登录")
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<UserRole>> login(@Valid @NotNull @RequestParam("phone") String phone,
                                                       @Valid @NotNull @RequestParam("pass") String passWord) {
        return ResponseEntity.ok(userInfoService.login(phone, passWord));
    }

    @Description("登出")
    @ResponseBody
    @RequestMapping(value = "/marketing/logout", method = RequestMethod.POST)
    public DataResponse logout(@Valid @NotNull @Operator CurOperator curOperator) {
        return userInfoService.logout(curOperator.getId());
    }

    @Description("token测试")
    @ResponseBody
    @RequestMapping(value = "/marketing/test", method = RequestMethod.POST)
    public String test(@Valid @Operator CurOperator curOperator) {
        return userInfoService.getOpeator(curOperator);
    }

    @Description("返回值测试")
    @ResponseBody
    @RequestMapping(value = "/market/tests", method = RequestMethod.GET)
    public String Test() {
        return "success";
    }
}
