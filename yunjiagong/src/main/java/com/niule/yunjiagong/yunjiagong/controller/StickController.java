package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.StickModel;
import com.niule.yunjiagong.yunjiagong.service.StickService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 16:57
 */
@RestController
public class StickController {

    @Autowired
    private StickService stickService;

    @Description("获取置顶价格")
    @RequestMapping(value = "/user/stick/price", method = RequestMethod.POST)
    public DataResponse getStickPrice(@Valid @NotNull @RequestBody(required = true) StickModel stickModel) {
        return DataResponse.success(stickService.getPrice(stickModel.getAddressDetail(), stickModel.getAddress()));
    }
}
