package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void getCustomerInfoTest() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setId(1);
//        MessageInfo<List<CustomerInfo>> cunstomerInfo = customerService.getCunstomerInfo(userInfo);
//        log.info("cunstomerInfo is :" + cunstomerInfo);
    }

    @Test
    public void updateCustomerInfoTest() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(1);
        customerInfo.setUserId(1);
        customerInfo.setCustName("海军-Test");
        MessageInfo messageInfo = customerService.editCustomerInfo(customerInfo);
        log.info("messageInfo is :" + messageInfo);
    }

    @Test
    public void removeCustomerInfoTest() {
        Integer custId = 1;
        String reason = "不满意";
        MessageInfo messageInfo = customerService.removeCustomerInfo(custId, reason);
        log.info("messageInfo is :" + messageInfo);
    }

    @Test
    public void saveCustomerInfo() {
//        CustomerInfo customerInfo = new CustomerInfo();
//        customerInfo.setUserId(6);
//        customerInfo.setCompanyName("test");
//        MessageInfo messageInfo = customerService.saveCustomerInfo(customerInfo);
//        log.info("messageInfo is :" + messageInfo);
    }
}
