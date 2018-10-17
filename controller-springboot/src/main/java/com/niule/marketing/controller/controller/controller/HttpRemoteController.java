package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.service.httpService.HttpRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 18:10
 */
@RestController
public class HttpRemoteController {

    @Autowired
    private HttpRemoteService httpRemoteService;

    @Description("获取注册信息")
    @RequestMapping(value = "/user/get/regist/info", method = RequestMethod.POST)
    public DataResponse getCustRegistInfo(@Valid @NotNull @RequestParam("phone") String phone) throws Exception {
        return DataResponse.success(httpRemoteService.getUserRegistInfo(phone));
    }

    @Description("获取用户金豆详情")
    @RequestMapping(value = "/user/get/gold/info", method = RequestMethod.POST)
    public DataResponse getCustGoldInfo(@Valid @NotNull @RequestParam("phone") String phone,
                                        @Valid @NotNull @RequestParam("pageNum") Integer pageNum,
                                        @Valid @NotNull @RequestParam("pageSize") Integer pageSize) throws Exception {
        return DataResponse.success(httpRemoteService.getUserGoldBeansDetail(phone,pageNum,pageSize));
    }

}
