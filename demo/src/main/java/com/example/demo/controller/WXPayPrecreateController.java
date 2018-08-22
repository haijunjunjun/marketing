package com.example.demo.controller;

import com.example.demo.model.CustPriceModel;
import com.example.demo.model.WxPayResponseModel;
import com.example.demo.model.WxRespModel;
import com.example.demo.service.WXPayPrecreateService;
import com.example.demo.util.MessageInfoV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
public class WXPayPrecreateController {

    @Autowired
    private WXPayPrecreateService wxPayPrecreateService;

    @RequestMapping(value = "/marketing/wx/pay", method = RequestMethod.POST)
    public MessageInfoV1 precreate(HttpServletRequest request,
                                   HttpServletResponse response,
                                   @Valid @NotNull @RequestBody(required = true) CustPriceModel custPriceModel) throws Exception {
        return wxPayPrecreateService.precreate(request, response, custPriceModel.getId());
    }

    @RequestMapping(value = "/market/wx/pay/notify", method = RequestMethod.POST)
    public void precreateNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        wxPayPrecreateService.precreateNotify(request, response);
    }

    @Description("支付响应回答")
    @RequestMapping(value = "/marketing/response", method = RequestMethod.POST)
    public ResponseEntity<WxPayResponseModel> response(@Valid @RequestBody(required = true) WxRespModel wxRespModel) {
        return ResponseEntity.ok(wxPayPrecreateService.response(wxRespModel.getTradeNo()));
    }
}
