package com.example.demo.service;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.constant.CustomerStatus;
import com.example.demo.dal.mapper.CustGoldBeansMapper;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.model.CustGoldBeans;
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
    private CustGoldBeansMapper custGoldBeansMapper;

    @Autowired
    public CustomerService(CustomerInfoMapper customerInfoMapper, CustGoldBeansMapper custGoldBeansMapper) {
        this.customerInfoMapper = customerInfoMapper;
        this.custGoldBeansMapper = custGoldBeansMapper;
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


    public MessageInfo donateGoldBeans(Integer custId, Integer goldBeansNum) {
        MessageInfo messageInfo = new MessageInfo();
        if (StringUtils.isEmpty(custId.toString()) || StringUtils.isEmpty(goldBeansNum)) {
            log.info("参数异常!");
            messageInfo.setContent("参数异常!");
            return messageInfo;
        }
        CustGoldBeans cgb = new CustGoldBeans();
        cgb.setCustId(custId);
        CustGoldBeans custGoldBeansInfo = custGoldBeansMapper.selectOne(cgb);

        CustGoldBeans custGoldBeans = new CustGoldBeans();
        custGoldBeans.setId(custGoldBeansInfo.getId());
        custGoldBeans.setCustId(custId);
        custGoldBeans.setGoldBeansNum(goldBeansNum);
        int i = custGoldBeansMapper.updateByPrimaryKeySelective(custGoldBeans);
        if (i != 1) {
            log.info("更新失败!");
            messageInfo.setContent("更新失败!");
            return messageInfo;
        }
        messageInfo.setContent("更新成功！");
        return messageInfo;
    }

    public MessageInfo saveCustomerInfo(CustomerInfo customerInfo) {
        MessageInfo messageInfo = new MessageInfo();
        if (Objects.isNull(customerInfo)) {
            log.info("报备信息异常!");
            messageInfo.setContent("报备信息异常!");
            return messageInfo;
        }
        int i = customerInfoMapper.insert(customerInfo);
        if (i != 1) {
            log.info("报备失败！");
            messageInfo.setContent("报备失败!");
            return messageInfo;
        }
        CustGoldBeans custGoldBeans = new CustGoldBeans();
        custGoldBeans.setCustId(customerInfo.getId());
        custGoldBeans.setGoldBeansNum(0);
        int insert = custGoldBeansMapper.insert(custGoldBeans);
        if (1 != insert) {
            log.info("客户金豆初始化失败");
            throw new BizRuntimeException("客户金豆初始化失败！");
        }

        log.info("报备成功");
        messageInfo.setContent("报备成功!");
        return messageInfo;
    }

    // TODO: 2018/7/6 收款方法

    // TODO: 2018/7/6 合同图片存服务器
}
