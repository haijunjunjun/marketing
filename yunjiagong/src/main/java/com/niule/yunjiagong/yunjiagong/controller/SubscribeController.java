package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.PageModel;
import com.niule.yunjiagong.yunjiagong.model.SubModel;
import com.niule.yunjiagong.yunjiagong.service.SubscribeService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/market/get/subscribe", method = RequestMethod.POST)
    public DataResponse getSubscribe(@Valid @NotNull @RequestBody(required = true)PageModel pageModel) {
        return DataResponse.success(subscribeService.getSubscribe(pageModel.getPageNum(), pageModel.getPageSize()));
    }

    @RequestMapping(value = "/market/add/subscribe", method = RequestMethod.POST)
    public DataResponse addSubscribe(@Valid @NotNull @RequestBody(required = true)SubModel subModel) {
        return DataResponse.success(subscribeService.addSubscribe(subModel.getMobile(), subModel.getSubscribeName()));
    }

    @RequestMapping(value = "/market/delete/subscribe", method = RequestMethod.POST)
    public DataResponse deleteSubscribe(@Valid @NotNull @RequestBody(required = true) SubModel subModel) {
        return DataResponse.success(subscribeService.deleteSubscribe(subModel.getSubscribeId()));
    }
}
