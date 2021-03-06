package com.niule.market.controller;

import com.niule.market.model.AdvertParamModel;
import com.niule.market.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
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
@Description("动作记录")
@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    //跳转页面
    @Description("动作记录")
    @ResponseBody
    @RequestMapping(value = "/market/record", method = RequestMethod.POST)
    public void record(HttpServletRequest request,
                       @Valid @NotNull @RequestParam("advertId") Integer advertId,
                       @Valid @NotNull @RequestParam("code") Integer actionCode,
                       @Valid @NotNull @RequestParam("authNoId") Integer authNoId) {
        recordService.jump(request, advertId, actionCode, authNoId);
    }

    @RequestMapping(value = "/market/param", method = RequestMethod.GET)
    public ResponseEntity<AdvertParamModel> getParam(@Valid @NotNull @RequestParam("authNoId") Integer authNoId) {
        return ResponseEntity.ok(recordService.getParam(authNoId));
    }
}
