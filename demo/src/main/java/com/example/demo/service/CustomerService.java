package com.example.demo.service;

import com.example.demo.constant.CustomerStatus;
import com.example.demo.dal.mapper.CustGoldBeansMapper;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.UserGoldBeansMapper;
import com.example.demo.dal.model.CustGoldBeans;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserGoldBeans;
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
    private CustGoldBeansMapper custGoldBeansMapper;
    private UserGoldBeansMapper userGoldBeansMapper;

    @Autowired
    public CustomerService(CustomerInfoMapper customerInfoMapper,
                           CustGoldBeansMapper custGoldBeansMapper,
                           UserGoldBeansMapper userGoldBeansMapper) {
        this.customerInfoMapper = customerInfoMapper;
        this.custGoldBeansMapper = custGoldBeansMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
    }

    public MessageInfo<List<CustomerInfo>> getCunstomerInfo(Integer userId, Integer status) {
        MessageInfo<List<CustomerInfo>> customerInfoMessageInfo = new MessageInfo<>();
        if (Objects.isNull(userId) || Objects.isNull(status)) {
            log.info("参数信息有误！");
            customerInfoMessageInfo.setContent("参数信息有误！");
            return customerInfoMessageInfo;
        }
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setUserId(userId);
        customerInfo.setStatus(status);
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
            log.info("系统异常!");
            throw new BizRuntimeException("系统异常!");
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


    public MessageInfo donateGoldBeans(Integer userId, Integer custId, Integer goldBeansNum) {
        MessageInfo messageInfo = new MessageInfo();
        UserGoldBeans userGoldBeans = new UserGoldBeans();
        userGoldBeans.setUserId(userId);
        UserGoldBeans userGoldBeansV1 = userGoldBeansMapper.selectOne(userGoldBeans);
        if (Objects.isNull(userGoldBeansV1)) {
            log.info("数据库信息异常!");
            throw new BizRuntimeException("数据库信息异常!");
        }
        if (StringUtils.isEmpty(custId.toString()) || custId <= 0) {
            log.info("参数异常!");
            messageInfo.setContent("参数异常!");
            return messageInfo;
        }
        if (goldBeansNum <= 0) {
            log.info("赠送的金豆数量必须大于0");
            messageInfo.setContent("赠送的金豆数量必须大于0");
            return messageInfo;
        }
        int i = custGoldBeansMapper.updateCustGoldBeans(custId, goldBeansNum);
        if (i != 1) {
            log.info("更新失败!");
            messageInfo.setContent("更新失败!");
            return messageInfo;
        }
        userGoldBeansMapper.updateGoldBeansNum(-goldBeansNum, userId);
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        customerInfo.setIsGoldBeans(1);
        int isGoldBeansUpdate = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (1 != isGoldBeansUpdate) {
            log.info("客户信息更新异常!");
            throw new BizRuntimeException("客户信息更新异常!");
        }
        messageInfo.setContent("赠送成功！");
        return messageInfo;
    }

    public MessageInfo saveCustomerInfo(Integer userId, CustomerInfo customerInfo) {
        MessageInfo messageInfo = new MessageInfo();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("userId 参数信息异常!");
            throw new BizRuntimeException("userId 参数信息异常!");
        }
        if (Objects.isNull(customerInfo)) {
            log.info("报备信息异常!");
            messageInfo.setContent("报备信息异常!");
            return messageInfo;
        }
        customerInfo.setUserId(userId);
        int i = customerInfoMapper.insert(customerInfo);
        if (i != 1) {
            log.info("报备失败！");
            messageInfo.setContent("报备失败!");
            return messageInfo;
        }
        CustGoldBeans custGoldBeans = new CustGoldBeans();
        custGoldBeans.setCustId(customerInfo.getId());
        custGoldBeans.setGoldBeansNum(0);
        custGoldBeans.setCreateTime(new Date());
        int insert = custGoldBeansMapper.insert(custGoldBeans);
        if (1 != insert) {
            log.info("客户金豆初始化失败");
            throw new BizRuntimeException("客户金豆初始化失败！");
        }

        log.info("报备成功");
        messageInfo.setContent("报备成功!");
        return messageInfo;
    }

}
