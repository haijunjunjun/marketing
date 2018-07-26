package com.niule.market.controller;

import com.niule.market.model.AdvertMakeInfo;
import com.niule.market.service.AdvertService;
import com.niule.market.util.MessageV1;
import org.springframework.beans.factory.annotation.Autowired;
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

    //生成广告
    @RequestMapping(value = "/market/make", method = RequestMethod.POST)
    public ResponseEntity<MessageV1> makeAdvert(@Valid @NotNull @RequestBody(required = true) AdvertMakeInfo advertMakeInfo) {
        return ResponseEntity.ok(advertService.makeAdvert(advertMakeInfo));
    }
}
