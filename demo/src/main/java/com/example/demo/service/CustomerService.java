package com.example.demo.service;

import com.example.demo.constant.CustomerStatus;
import com.example.demo.dal.mapper.ConfigMapper;
import com.example.demo.dal.mapper.CustGoldBeansMapper;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.UserGoldBeansMapper;
import com.example.demo.dal.model.Config;
import com.example.demo.dal.model.CustGoldBeans;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserGoldBeans;
import com.example.demo.model.CustInfoModel;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.CustomerUtil;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.MessageInfoV1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    private ConfigMapper configMapper;

    @Autowired
    public CustomerService(CustomerInfoMapper customerInfoMapper,
                           CustGoldBeansMapper custGoldBeansMapper,
                           UserGoldBeansMapper userGoldBeansMapper,
                           ConfigMapper configMapper) {
        this.customerInfoMapper = customerInfoMapper;
        this.custGoldBeansMapper = custGoldBeansMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
        this.configMapper = configMapper;
    }

    public MessageInfo<PageInfo<CustomerInfo>> getCunstomerInfo(Integer userId, Integer status, Integer pageNum, Integer pageSize) {
        MessageInfo<PageInfo<CustomerInfo>> customerInfoMessageInfo = new MessageInfo<>();
        if (Objects.isNull(userId) || Objects.isNull(status)) {
            log.info("参数信息有误！");
            customerInfoMessageInfo.setContent("参数信息有误！");
            return customerInfoMessageInfo;
        }
//        CustomerInfo customerInfo = new CustomerInfo();
//        customerInfo.setUserId(userId);
//        customerInfo.setStatus(status);
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerInfo> customerInfoList = customerInfoMapper.getCustomerInfoList(userId, status);
        if (Objects.isNull(customerInfoList)) {
            log.info("客户信息异常，请检查数据库信息！");
            customerInfoMessageInfo.setContent("客户信息异常，请检查数据库信息！");
            return customerInfoMessageInfo;
        }
        PageInfo<CustomerInfo> customerInfoPageInfo = new PageInfo<>(customerInfoList);
        customerInfoMessageInfo.setData(customerInfoPageInfo);
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
        if (1 == customerInfo.getIsCompact()) {
            CustomerInfo customerInfoV1 = new CustomerInfo();
            customerInfoV1.setId(customerInfo.getId());
            customerInfoV1.setStatus(CustomerStatus.FINISH.getStatus());
            customerInfoMapper.updateByPrimaryKeySelective(customerInfoV1);
        }
        messageInfo.setContent("更新成功!");
        return messageInfo;
    }

    public MessageInfo removeCustomerInfo(Integer cusId, Integer status, String reason) {
        MessageInfo messageInfo = new MessageInfo();
        if (StringUtils.isEmpty(cusId.toString()) || StringUtils.isEmpty(reason)) {
            log.info("获取数据异常！");
            throw new BizRuntimeException("获取数据异常！");
        }
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(cusId);
        if (status == CustomerStatus.ABANDON.getStatus()) {
            customerInfo.setStatus(CustomerStatus.ABANDON.getStatus());
            customerInfo.setAbandonReason(reason);
            customerInfo.setAbandonTime(new Date());
        } else {
            customerInfo.setStatus(CustomerStatus.DELETE.getStatus());
            customerInfo.setDeleteReason(reason);
            customerInfo.setDeleteTime(new Date());
        }
        customerInfo.setModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (i != 1) {
            if (status == CustomerStatus.ABANDON.getStatus()) {
                log.info("放弃失败！");
                messageInfo.setContent("放弃失败！");
                return messageInfo;
            }
            if (status == CustomerStatus.DELETE.getStatus()) {
                log.info("删除失败！");
                messageInfo.setContent("删除失败！");
                return messageInfo;
            }
        }
        if (status == CustomerStatus.ABANDON.getStatus()) {
            log.info("放弃成功！");
            messageInfo.setContent("放弃成功！");
            return messageInfo;
        }
        if (status == CustomerStatus.DELETE.getStatus()) {
            log.info("删除成功！");
            messageInfo.setContent("删除成功！");
            return messageInfo;
        }
        return null;
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
        if (userGoldBeansV1.getGoldBeansNum() <= 0) {
            log.info("您的金豆数为0，目前不能赠送");
            messageInfo.setContent("您的金豆数为0，目前不能赠送");
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

        //判断该客户是否可以再次进行报备
        CustomerInfo customerInfoV1 = new CustomerInfo();
        customerInfoV1.setCustPhone(customerInfo.getCustPhone());
        List<CustomerInfo> customerInfoList = customerInfoMapper.select(customerInfoV1);
        for (CustomerInfo customerInfo1 : customerInfoList) {
            if (customerInfo1.getStatus() == 1) {
                messageInfo.setContent("报备失败!该客户目前处于待跟进状态中!");
                return messageInfo;
            } else if (customerInfo1.getStatus() == 2) {
                messageInfo.setContent("报备失败!该客户目前已经签约!!");
                return messageInfo;
            }
        }


        customerInfo.setUserId(userId);
        if (customerInfo.getIsCompact() == 0) {
            customerInfo.setStatus(1);
        } else {
            customerInfo.setStatus(1);
            customerInfo.setIsCompactCheck(2);
        }
        customerInfo.setRepoTime(new Date());
        customerInfo.setModifyTime(new Date());
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

    public MessageInfoV1 updateCustomerPrice(Integer id, double price) {
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(id);
        customerInfo.setPrice(price);
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (1 != i) {
            log.info("签约价更新失败");
            messageInfoV1.setContent("签约价更新失败");
            return messageInfoV1;
        }
        messageInfoV1.setContent("签约价更新成功");
        return messageInfoV1;
    }

    public MessageInfo<CustInfoModel> getCustInfo(Integer custId) {
        MessageInfo<CustInfoModel> messageInfo = new MessageInfo<>();
        if (Objects.isNull(custId)) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常！");
        }
        CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(custId);
        if (Objects.isNull(customerInfo)) {
            log.info("数据库信息异常！");
            throw new BizRuntimeException("数据库信息异常！");
        }
        CustInfoModel custInfoModel = new CustInfoModel();
        BeanUtils.copyProperties(customerInfo, custInfoModel);
        messageInfo.setData(custInfoModel);
        messageInfo.setContent("success");
        return messageInfo;
    }

    public MessageInfo<Integer> getCustGoldBeans() {
        MessageInfo<Integer> messageInfo = new MessageInfo<>();
        Config config = new Config();
        config.setConfigName(CustomerUtil.DONATE_CUST_GOLD_BEANS.getName());
        Config configInfo = configMapper.selectOne(config);
        if (Objects.isNull(configInfo)) {
            log.info("配置信息异常！");
            messageInfo.setContent("配置信息异常!");
            return messageInfo;
        }
        messageInfo.setData(configInfo.getConfigValue());
        messageInfo.setContent("success");
        return messageInfo;
    }
}
