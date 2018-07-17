package com.example.demo.controller;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.model.GoldBeansApply;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.model.Balance;
import com.example.demo.model.MyList;
import com.example.demo.model.MyPerformanceModel;
import com.example.demo.model.MyPersonalInfo;
import com.example.demo.service.MyService;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.PerformanceMessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/marketing/my/list/info", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<MyList>> getMyListInfo(@Valid @NotNull @CurrentUser UserInfo userInfo) {
        return ResponseEntity.ok(myService.getMyListInfo(userInfo.getId()));
    }

    @RequestMapping(value = "/marketing/my/personal/info", method = RequestMethod.GET)
    public ResponseEntity<MyPersonalInfo> getMyPersonalInfo(@Valid @NotNull @CurrentUser UserInfo userInfo) {
        return ResponseEntity.ok(myService.getMyPersonalInfo(userInfo.getId()));
    }

    @RequestMapping(value = "/marketing/my/performance/info", method = RequestMethod.GET)
    public ResponseEntity<PerformanceMessageInfo<List<MyPerformanceModel>>> getMyPerformanceInfo(@Valid @NotNull @CurrentUser UserInfo userInfo,
                                                                                                 @Valid @NotNull @RequestParam("date") Date date) {
        return ResponseEntity.ok(myService.getMyPerformanceInfo(userInfo.getId(), date));
    }

    @RequestMapping(value = "/marketing/gold/beans/apply/info", method = RequestMethod.GET)
    public ResponseEntity<List<GoldBeansApply>> getGoldBeansApplyInfo(@Valid @NotNull @CurrentUser UserInfo userInfo) {
        return ResponseEntity.ok(myService.getGoldBeansApplyInfo(userInfo.getId()));
    }

    @RequestMapping(value = "/marketing/gold/beans/apply", method = RequestMethod.POST)
    public void goldBeansApply(@Valid @NotNull @CurrentUser UserInfo userInfo,
                               @Valid @NotNull @RequestParam("num") Integer applyNum) {
        myService.goldBeanApply(userInfo.getId(), applyNum);
    }

    @RequestMapping(value = "/marketing/gold/beans/edit", method = RequestMethod.POST)
    public void goldBeansEdit(@Valid @NotNull @CurrentUser UserInfo userInfo,
                              @Valid @NotNull @RequestParam("image") String imageUrl,
                              @Valid @NotNull @RequestParam("sex") Integer sex) {
        myService.editPersonalInfo(userInfo.getId(), imageUrl, sex);
    }

    @RequestMapping(value = "/marketing/balance/list", method = RequestMethod.GET)
    public ResponseEntity<Balance> getBalanceListInfo(@Valid @NotNull @CurrentUser UserInfo userInfo) {
        return ResponseEntity.ok(myService.getBalanceList(userInfo.getId()));
    }

}
