package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.SignService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 9:19
 */
@Controller
public class SignController {

    @Autowired
    private SignService signService;

    @Description("用户签到")
    @RequestMapping(value = "/user/sign", method = RequestMethod.POST)
    public DataResponse doSign(@Valid @NotNull @RequestParam("signDate") String signDate) throws ParseException {

        return DataResponse.success(signService.doSign(signDate));
    }

    @RequestMapping(value = "/user/check/sign", method = RequestMethod.POST)
    public DataResponse checkSign(@Valid @NotNull @RequestParam("signDate") String signDate) throws ParseException {
        return DataResponse.success(signService.checkSign(signDate));
    }
}
