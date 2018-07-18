package com.niule.market.controller;

import com.niule.market.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 15:39
 */
@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    //跳转页面
    @ResponseBody
    @RequestMapping(value = "/market/record", method = RequestMethod.POST)
    public void record(HttpServletRequest request,
                       @Valid @NotNull @RequestParam("advertId") Integer advertId,
                       @Valid @NotNull @RequestParam("code") Integer actionCode) {
        recordService.jump(request, advertId, actionCode);
    }
}
