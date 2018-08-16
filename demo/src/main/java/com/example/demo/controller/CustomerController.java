package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.model.*;
import com.example.demo.service.CustomerService;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.MessageInfoV1;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 获取客户信息
     */
    @RequestMapping(value = "/marketing/customer/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<PageInfo<CustomerInfo>>> getCustomerInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                                               @Valid @NotNull @RequestParam("status") Integer status,
                                                                               @Valid @NotNull @RequestParam("pageSize") Integer pageSize,
                                                                               @Valid @NotNull @RequestParam("pageNum") Integer pageNum) {
        return ResponseEntity.ok(customerService.getCunstomerInfo(curOperator.getId(), status, pageNum, pageSize));
    }

    /**
     * 编辑客户信息
     */
    @RequestMapping(value = "/marketing/customer/edit", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> updateCustomerInfo(@Valid @RequestBody(required = true) CustomerInfo customerInfo) {
        return ResponseEntity.ok(customerService.editCustomerInfo(customerInfo));
    }

    /**
     * 放弃用户(放弃删除)
     */
    @RequestMapping(value = "/marketing/customer/remove", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> removeCustomerInfo(@Valid @RequestBody(required = true) Reason reason) {
        return ResponseEntity.ok(customerService.removeCustomerInfo(reason.getCustId(), reason.getStatus(), reason.getReason()));
    }

    /**
     * 赠送客户金豆
     */
    @RequestMapping(value = "/marketing/customer/donate/beans", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> donateCustGoldBeans(@Valid @NotNull @Operator CurOperator curOperator,
                                                           @Valid @NotNull @RequestBody(required = true) DonateGoldBeansModel donateGoldBeansModel) {
        return ResponseEntity.ok(customerService.donateGoldBeans(curOperator.getId(), donateGoldBeansModel.getCustId(), donateGoldBeansModel.getGoldBeansNum()));
    }

    /**
     * 获取赠送客户的金豆数量
     */
    @RequestMapping(value = "/marketing/customer/donate/beans/num", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<Integer>> getCustGoldBeans() {
        return ResponseEntity.ok(customerService.getCustGoldBeans());
    }

    /**
     * 客户信息报备
     */
    @RequestMapping(value = "/marketing/customer/save", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> saveCustomerInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                        @Valid @RequestBody(required = true) CustomerInfo customerInfo) {
        return ResponseEntity.ok(customerService.saveCustomerInfo(curOperator.getId(), customerInfo));
    }

    /**
     * 保存签约价格
     */
    @RequestMapping(value = "/marketing/customer/price", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> updateCustomerPrice(@Valid @NotNull @RequestBody(required = true) CustPriceModel custPriceModel) {
        return ResponseEntity.ok(customerService.updateCustomerPrice(custPriceModel.getId(), custPriceModel.getPrice()));
    }

    /**
     * 编辑信息时获取客户信息
     */
    @RequestMapping(value = "/marketing/cust/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<CustInfoModel>> getCustInfo(@Valid @NotNull @RequestParam("custId") Integer custId) {
        return ResponseEntity.ok(customerService.getCustInfo(custId));
    }
}
