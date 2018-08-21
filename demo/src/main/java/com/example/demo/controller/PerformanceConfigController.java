package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.model.CurOperator;
import com.example.demo.service.PerformanceConfigService;
import com.example.demo.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
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

//    @Description("用户自己计算提成(老算法)")
//    @RequestMapping(value = "/marketing/commission/cal", method = RequestMethod.POST)
//    public ResponseEntity<MessageInfo<Double>> calCommission(@Valid @NotNull @Operator CurOperator curOperator,
//                                                             @Valid @NotNull @RequestParam("preWeekPerformanceV1") Integer preWeekPerformanceV1,
//                                                             @Valid @NotNull @RequestParam("preWeekPerformanceV2") Integer preWeekPerformanceV2) {
//        return ResponseEntity.ok(performanceConfigService.calCommission(curOperator.getId(), preWeekPerformanceV1, preWeekPerformanceV2));
//    }

    @Description("提成测试接口")
    @RequestMapping(value = "/marketing/commission", method = RequestMethod.POST)
    public ResponseEntity<Double> calCommissionV1(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(performanceConfigService.calUserCommission(curOperator.getId()));
    }
}
