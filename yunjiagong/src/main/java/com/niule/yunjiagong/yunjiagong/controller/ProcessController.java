package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.ProcessBreakRequestModel;
import com.niule.yunjiagong.yunjiagong.service.ProcessService;
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
 * @create 2018 - 10 - 08 - 17:13
 */
@RestController
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @Description("获取取消原因")
    @RequestMapping(value = "/fetch/break/reason", method = RequestMethod.POST)
    public DataResponse fetchBreakReason(@Valid @NotNull @RequestBody(required = true) ProcessBreakRequestModel processBreakRequestModel) {
        return DataResponse.success(processService.getProcessBreakConfig(processBreakRequestModel));
    }
}
