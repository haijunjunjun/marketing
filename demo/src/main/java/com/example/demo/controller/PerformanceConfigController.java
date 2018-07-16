package com.example.demo.controller;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.service.PerformanceConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerformanceConfigController {

    @Autowired
    private PerformanceConfigService performanceConfigService;

    @RequestMapping(value = "/marketing/batch/execute", method = RequestMethod.POST)
    public void excuteBatch(@CurrentUser UserInfo userInfo) {
        Double aDouble = performanceConfigService.calUserCommission(userInfo.getId());
        performanceConfigService.saveUserCommission(userInfo.getId(), aDouble);
    }
}
