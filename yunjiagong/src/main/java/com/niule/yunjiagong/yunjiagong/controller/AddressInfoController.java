package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.AddressInfoService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 17:48
 */
@RestController
public class AddressInfoController {

    @Autowired
    private AddressInfoService addressInfoService;

    @Description("获取城市信息列表(热门城市等)")
    @RequestMapping(value = "/market/address/info/list", method = RequestMethod.POST)
    public DataResponse getAddressInfo() {
        return DataResponse.success(addressInfoService.getAddressInfo());
    }

    @Description("判断城市信息列表是否发生改变")
    @RequestMapping(value = "/market/address/info/change", method = RequestMethod.GET)
    public DataResponse getIsChange() {
        return DataResponse.success(addressInfoService.getIsChange());
    }
}
