package com.example.demo.controller;

import com.example.demo.dal.model.GoldBeansApply;
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
    public ResponseEntity<MessageInfo<MyList>> getMyListInfo(@Valid @NotNull @RequestParam("id") Integer userId) {
        return ResponseEntity.ok(myService.getMyListInfo(userId));
    }

    @RequestMapping(value = "/marketing/my/personal/info", method = RequestMethod.GET)
    public ResponseEntity<MyPersonalInfo> getMyPersonalInfo(@Valid @NotNull @RequestParam("id") Integer userId) {
        return ResponseEntity.ok(myService.getMyPersonalInfo(userId));
    }

    @RequestMapping(value = "/marketing/my/performance/info", method = RequestMethod.GET)
    public ResponseEntity<PerformanceMessageInfo<List<MyPerformanceModel>>> getMyPerformanceInfo(@Valid @NotNull @RequestParam("id") Integer userId,
                                                                                                 @Valid @NotNull @RequestParam("date") Date date) {
        return ResponseEntity.ok(myService.getMyPerformanceInfo(userId, date));
    }

    @RequestMapping(value = "/marketing/gold/beans/apply", method = RequestMethod.GET)
    public ResponseEntity<List<GoldBeansApply>> getGoldBeansApplyInfo(@Valid @NotNull @RequestParam("id") Integer userId) {
        return ResponseEntity.ok(myService.getGoldBeansApplyInfo(userId));
    }

    @RequestMapping(value = "/marketing/")
    public void goldBeansApply (){

    }
}
