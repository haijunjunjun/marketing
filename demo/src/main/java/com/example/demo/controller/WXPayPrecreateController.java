package com.example.demo.controller;

import com.example.demo.service.WXPayPrecreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Controller
@RequestMapping("/wxpay/precreate")
public class WXPayPrecreateController {

    @Autowired
    private WXPayPrecreateService wxPayPrecreateService;

    @RequestMapping(value = "/marketing/wx/pay", method = RequestMethod.POST)
    public void precreate(HttpServletRequest request, HttpServletResponse response, @Valid @NotNull @RequestParam("id") Integer custId) throws Exception {
        wxPayPrecreateService.precreate(request, response, custId);
    }

    @RequestMapping(value = "/marketing/wx/pay/notify", method = RequestMethod.POST)
    public void precreateNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        wxPayPrecreateService.precreateNotify(request, response);
    }
}
