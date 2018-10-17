package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.ReleaseService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 10 - 10 - 14:30
 */
@RestController
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @Description("发布类型说明")
    @RequestMapping(value = "/fetch/release/type", method = RequestMethod.POST)
    public DataResponse fetchReleaseType() {
        return DataResponse.success(releaseService.getReleaseTypeInfo());
    }
}
