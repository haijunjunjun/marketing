package com.example.demo.controller;

import com.example.demo.model.http.HttpDataModel;
import com.example.demo.service.httpService.ValidUserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 17:38
 */
@RestController
public class ValidUserRegistController {

    @Autowired
    private ValidUserRegistService validUserRegistService;

    @RequestMapping(value = "/user/valid/regist", method = RequestMethod.POST)
    public HttpDataModel valiUserRegist(@Valid @NotNull @RequestParam("phone") String phone) throws Exception {
        return validUserRegistService.validUserRegist(phone);
    }
}
