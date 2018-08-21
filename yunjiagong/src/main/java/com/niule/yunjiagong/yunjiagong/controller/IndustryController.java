package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.IndustryService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:29
 */
@Description("工种信息")
@RestController
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @Description("获取工种信息前三条")
    @RequestMapping(value = "/user/industry", method = RequestMethod.GET)
    public DataResponse getIndustry() {
        return DataResponse.success(industryService.getIndustryInfo());
    }

    @Description("获取所有公众信息")
    @RequestMapping(value = "/user/industry/all", method = RequestMethod.GET)
    public DataResponse getAllIndustry() {
        return DataResponse.success(industryService.getAllIndustryInfo());
    }
}
