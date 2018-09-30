package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.UnitService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 14:31
 */
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @Description("获取单位")
    @RequestMapping(value = "/fetch/unit", method = RequestMethod.POST)
    public DataResponse fetchUnitInfo() {
        return DataResponse.success(unitService.getUnitInfo());
    }
}
