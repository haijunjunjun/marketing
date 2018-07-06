package com.example.demo.service;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.constant.CustomerStatus;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CustomerService {

    private CustomerInfoMapper customerInfoMapper;

    @Autowired
    public CustomerService(CustomerInfoMapper customerInfoMapper) {
        this.customerInfoMapper = customerInfoMapper;
    }

    public MessageInfo<List<CustomerInfo>> getCunstomerInfo(@CurrentUser UserInfo userInfo) {
        MessageInfo<List<CustomerInfo>> customerInfoMessageInfo = new MessageInfo<>();
        if (Objects.isNull(userInfo)) {
            log.info("当前用户已下线!");
            customerInfoMessageInfo.setContent("您已下线，请重新登录!");
            return customerInfoMessageInfo;
        }
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setUserId(userInfo.getId());
        List<CustomerInfo> customerInfoList = customerInfoMapper.select(customerInfo);
        if (Objects.isNull(customerInfoList)) {
            log.info("客户信息异常，请检查数据库信息！");
            customerInfoMessageInfo.setContent("客户信息异常，请检查数据库信息！");
            return customerInfoMessageInfo;
        }
        customerInfoMessageInfo.setData(customerInfoList);
        customerInfoMessageInfo.setContent("success");
        return customerInfoMessageInfo;
    }

    public MessageInfo editCustomerInfo(CustomerInfo customerInfo) {
        MessageInfo messageInfo = new MessageInfo();
        if (Objects.isNull(customerInfo)) {
            log.info("修改信息异常!");
            throw new BizRuntimeException("修改信息异常!");
        }
        customerInfo.setModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (i != 1) {
            log.info("更新失败！");
            throw new BizRuntimeException("更新失败！");
        }
        messageInfo.setContent("更新成功!");
        return messageInfo;
    }

    public MessageInfo removeCustomerInfo(Integer cusId, String reason) {
        MessageInfo messageInfo = new MessageInfo();
        if (StringUtils.isEmpty(cusId.toString()) || StringUtils.isEmpty(reason)) {
            log.info("获取数据异常！");
            throw new BizRuntimeException("获取数据异常！");
        }
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(cusId);
        customerInfo.setStatus(CustomerStatus.ABANDON.getStatus());
        customerInfo.setAbandonReason(reason);
        customerInfo.setModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (i != 1) {
            log.info("修改失败！");
            messageInfo.setContent("修改失败！");
            return messageInfo;
        }
        log.info("修改成功!");
        messageInfo.setContent("修改成功!");
        return messageInfo;
    }


}
