package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.dal.model.GoldBeansApply;
import com.example.demo.dal.model.SumArrange;
import com.example.demo.model.*;
import com.example.demo.service.MyService;
import com.example.demo.util.GoldBeansMessageInfo;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.MessageInfoV1;
import com.example.demo.util.PerformanceMessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/marketing/my/list/info", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<MyList>> getMyListInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getMyListInfo(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/my/personal/info", method = RequestMethod.GET)
    public ResponseEntity<MyPersonalInfo> getMyPersonalInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getMyPersonalInfo(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/my/performance/info", method = RequestMethod.GET)
    public ResponseEntity<PerformanceMessageInfo<List<MyPerformanceModel>>> getMyPerformanceInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                                                                 @Valid @NotNull @RequestParam("dates") String date) {
        return ResponseEntity.ok(myService.getMyPerformanceInfo(curOperator.getId(), date));
    }

    @RequestMapping(value = "/marketing/gold/beans/apply/info", method = RequestMethod.GET)
    public ResponseEntity<GoldBeansMessageInfo<List<GoldBeansApply>>> getGoldBeansApplyInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getGoldBeansApplyInfo(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/gold/beans/apply", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> goldBeansApply(@Valid @NotNull @Operator CurOperator curOperator,
                                                        @Valid @NotNull @RequestParam("num") Integer applyNum) {
        return ResponseEntity.ok(myService.goldBeanApply(curOperator.getId(), applyNum));
    }

    @RequestMapping(value = "/marketing/gold/beans/edit", method = RequestMethod.POST)
    public void goldBeansEdit(@Valid @NotNull @Operator CurOperator curOperator,
                              @Valid @NotNull @RequestParam("image") String imageUrl,
                              @Valid @NotNull @RequestParam("sex") Integer sex) {
        myService.editPersonalInfo(curOperator.getId(), imageUrl, sex);
    }

    @RequestMapping(value = "/marketing/balance/list", method = RequestMethod.GET)
    public ResponseEntity<Balance> getBalanceListInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getBalanceList(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/sum/info", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<List<SumArrange>>> getSumArrangeList(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getSumArraListInfo(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/sum/arra", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> saveSumArra(@Valid @NotNull @Operator CurOperator curOperator,
                                                   @Valid @NotNull @RequestBody(required = true) SumArranModel sumArranModel) {
        return ResponseEntity.ok(myService.saveSumArrangeList(curOperator.getId(), sumArranModel));
    }

}
