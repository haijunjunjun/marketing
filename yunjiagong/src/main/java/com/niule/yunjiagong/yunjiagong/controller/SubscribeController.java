package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.SubscribeService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 9:18
 */
@Description("订阅信息的增删查")
@RestController
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @RequestMapping(value = "/market/get/subscribe", method = RequestMethod.GET)
    public DataResponse getSubscribe(@Valid @RequestParam("pageNum") Integer pageNum,
                                     @Valid @RequestParam("pageSize") Integer pageSize) {
        return DataResponse.success(subscribeService.getSubscribe(pageNum, pageSize));
    }

    @RequestMapping(value = "/market/add/subscribe", method = RequestMethod.POST)
    public DataResponse addSubscribe(@Valid @NotNull @RequestParam("mobile") String mobile,
                                                    @Valid @NotNull @RequestParam("subscribeName") String subscribeName) {
        return DataResponse.success(subscribeService.addSubscribe(mobile, subscribeName));
    }

    @RequestMapping(value = "/market/delete/subscribe", method = RequestMethod.POST)
    public DataResponse deleteSubscribe(@Valid @NotNull @RequestParam("subscribeId") Integer subscribeId) {
        return DataResponse.success(subscribeService.deleteSubscribe(subscribeId));
    }
}
