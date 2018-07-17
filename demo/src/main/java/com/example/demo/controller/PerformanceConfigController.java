package com.example.demo.controller;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.service.PerformanceConfigService;
import com.example.demo.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class PerformanceConfigController {

    @Autowired
    private PerformanceConfigService performanceConfigService;

    @RequestMapping(value = "/marketing/commission/cal", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<Double>> excuteBatch(@Valid @NotNull @CurrentUser UserInfo userInfo,
                                                           @Valid @NotNull @RequestParam("preWeekPerformanceV1") Integer preWeekPerformanceV1,
                                                           @Valid @NotNull @RequestParam("preWeekPerformanceV2") Integer preWeekPerformanceV2) {
        return ResponseEntity.ok(performanceConfigService.calCommission(userInfo.getId(), preWeekPerformanceV1, preWeekPerformanceV2));
    }
}
