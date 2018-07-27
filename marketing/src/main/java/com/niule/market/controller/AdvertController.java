package com.niule.market.controller;

import com.niule.market.model.AdvertMakeInfo;
import com.niule.market.model.AdvertParamModel;
import com.niule.market.service.AdvertService;
import com.niule.market.util.MessageInfo;
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

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 14:10
 */
@Controller
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @Description("获取广告详细信息")
    @RequestMapping(value = "/market/get/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<AdvertMakeInfo>> getAdvertMakeInfo(@Valid @NotNull @RequestBody(required = true) AdvertParamModel advertParamModel) {
        return ResponseEntity.ok(advertService.makeAdvertV1(advertParamModel.getQq(), advertParamModel.getWorkNo()));
    }

}
