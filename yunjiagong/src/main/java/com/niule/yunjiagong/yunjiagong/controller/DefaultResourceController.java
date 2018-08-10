package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.DefaultResourceService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 17:51
 */
@RestController
public class DefaultResourceController {

    @Autowired
    private DefaultResourceService defaultResourceService;

    @Description("获取默认图片")
    @RequestMapping(value = "/user/default/resource", method = RequestMethod.GET)
    public DataResponse getDefaultResource() {
        return DataResponse.success(defaultResourceService.getDefaultResource());
    }
}
