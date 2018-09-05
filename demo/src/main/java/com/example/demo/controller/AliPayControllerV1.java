package com.example.demo.controller;

import com.example.demo.model.AliPayResponseModel;
import com.example.demo.model.AliRespModel;
import com.example.demo.model.CustPriceModel;
import com.example.demo.service.AliPayServiceV1;
import com.example.demo.util.AliPayMessageInfo;
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

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 14:55
 */
@RestController
public class AliPayControllerV1 {

    @Autowired
    private AliPayServiceV1 aliPayServiceV1;

    @Description("支付宝预支付接口")
    @RequestMapping(value = "/marketing/ali/pay", method = RequestMethod.POST)
    public ResponseEntity<AliPayMessageInfo<String>> aliPay(@Valid @NotNull @RequestBody(required = true) CustPriceModel custPriceModel) throws Exception {
        return ResponseEntity.ok(aliPayServiceV1.aliPayPrecreate(custPriceModel.getId()));
    }

    @Description("支付宝回调接口")
    @RequestMapping(value = "/market/ali/pay/notify", method = RequestMethod.POST)
    public ResponseEntity<String> aliNotify(HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        return ResponseEntity.ok(aliPayServiceV1.aliPayNotify(request, response));
    }

    @Description(("支付宝响应信息对应前端的"))
    @RequestMapping(value = "/marketing/ali/pay/response", method = RequestMethod.POST)
    public ResponseEntity<AliPayResponseModel> aliPayResponse(@Valid @NotNull @RequestBody(required = true) AliRespModel aliRespModel) {
        return ResponseEntity.ok(aliPayServiceV1.aliPayResponse(aliRespModel.getOutTradeNo()));
    }
}
