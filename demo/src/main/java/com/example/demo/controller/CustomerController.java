package com.example.demo.controller;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.model.Reason;
import com.example.demo.service.CustomerService;
import com.example.demo.util.MessageInfo;
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
import java.util.List;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 获取客户信息
     */
    @RequestMapping(value = "/marketing/customer/info", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<List<CustomerInfo>>> getCustomerInfo(@Valid @NotNull Integer userId,
                                                                           @Valid @NotNull @RequestParam("status") Integer status) {
        return ResponseEntity.ok(customerService.getCunstomerInfo(userId, status));
    }

    /**
     * 编辑客户信息
     */
    @RequestMapping(value = "/marketing/customer/edit", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> updateCustomerInfo(@Valid @RequestBody(required = true) CustomerInfo customerInfo) {
        return ResponseEntity.ok(customerService.editCustomerInfo(customerInfo));
    }

    /**
     * 放弃用户
     */
    @RequestMapping(value = "/marketing/customer/remove", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> removeCustomerInfo(@Valid @RequestBody(required = true) Reason reason) {
        return ResponseEntity.ok(customerService.removeCustomerInfo(reason.getCustId(), reason.getReason()));
    }

    /**
     * 赠送客户金豆
     */
    @RequestMapping(value = "/marketing/customer/update/beans", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> updateCustGoldBeans(@Valid @NotNull @RequestParam("id") Integer custId,
                                                           @Valid @NotNull @RequestParam("num") Integer goldBeansNum) {
        return ResponseEntity.ok(customerService.donateGoldBeans(custId, goldBeansNum));
    }

    /**
     * 客户信息报备
     */
    @RequestMapping(value = "/marketing/customer/save", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> saveCustomerInfo(@Valid @RequestBody(required = true) CustomerInfo customerInfo) {
        return ResponseEntity.ok(customerService.saveCustomerInfo(customerInfo));
    }

}
