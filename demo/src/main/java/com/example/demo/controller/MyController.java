package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.model.*;
import com.example.demo.service.MyService;
import com.example.demo.util.GoldBeansMessageInfo;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.MessageInfoV1;
import com.example.demo.util.PerformanceMessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
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

    @Description("针对当前操作用户的业绩信息")
    @RequestMapping(value = "/marketing/my/performance/info", method = RequestMethod.GET)
    public ResponseEntity<PerformanceMessageInfo<List<MyPerformanceModel>>> getMyPerformanceInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                                                                 @Valid @NotNull @RequestParam("dates") String date) {
        return ResponseEntity.ok(myService.getMyPerformanceInfo(curOperator.getId(), date));
    }

    @Description("针对经理查看销售人员时的业绩信息")
    @RequestMapping(value = "/marketing/manage/performance/info", method = RequestMethod.POST)
    public ResponseEntity<PerformanceMessageInfo<List<MyPerformanceModel>>> getManagePerformanceInfo(@Valid @NotNull @RequestBody(required = true) ManagePerformanceModel managePerformanceModel) {
        return ResponseEntity.ok(myService.getMyPerformanceInfo(managePerformanceModel.getUserId(), managePerformanceModel.getDates()));
    }

    @RequestMapping(value = "/marketing/gold/beans/apply/info", method = RequestMethod.GET)
    public ResponseEntity<GoldBeansMessageInfo<List<GoldBeansApplyModel>>> getGoldBeansApplyInfo(@Valid @NotNull @Operator CurOperator curOperator) {
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
    public ResponseEntity<MessageInfo<List<SumArrangeModel>>> getSumArrangeList(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getSumArraInfo(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/sum/info/single", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<SumArrangeModel>> getSumArrangeInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(myService.getSumArraListInfo(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/sum/arra", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> saveSumArra(@Valid @NotNull @Operator CurOperator curOperator,
                                                   @Valid @NotNull @RequestBody(required = true) SumArranModel sumArranModel) {
        return ResponseEntity.ok(myService.saveSumArrangeList(curOperator.getId(), sumArranModel));
    }

}
