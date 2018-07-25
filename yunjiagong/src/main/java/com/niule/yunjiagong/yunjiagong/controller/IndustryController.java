package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.dal.model.Industry;
import com.niule.yunjiagong.yunjiagong.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:29
 */
@Description("工种信息")
@Controller
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @Description("获取工种信息")
    @RequestMapping(value = "/user/industry", method = RequestMethod.GET)
    public ResponseEntity<List<Industry>> getIndustry() {
        return ResponseEntity.ok(industryService.getIndustryInfo());
    }
}
