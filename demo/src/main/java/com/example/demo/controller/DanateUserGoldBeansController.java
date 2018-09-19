package com.example.demo.controller;

import com.example.demo.service.httpService.DanateUserGoldBeans;
import com.example.demo.util.DataResponseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 18:21
 */
@RestController
public class DanateUserGoldBeansController {

    @Autowired
    private DanateUserGoldBeans danateUserGoldBeans;

    @Description("通过手机号赠送用户金豆")
    @RequestMapping(value = "/donate/user/gold/bean", method = RequestMethod.POST)
    public DataResponseV1 donateUserGoldBeans(@Valid @NotNull @RequestParam("mobile") String mobile,
                                              @Valid @NotNull @RequestParam("goldBean") Integer goldBeans) throws Exception {
        return DataResponseV1.success(danateUserGoldBeans.donateUserGoldBeans(mobile,goldBeans));
    }
}
