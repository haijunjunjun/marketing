package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CustomerInfoMapperTest {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Test
    public void getMonthNumTest() {
        Integer monthNum = customerInfoMapper.getMonthNum(1, "201807");
        log.info("monthNum is :" + monthNum);
    }

    @Test
    public void getWeekNumTest() {
        Integer weekNum = customerInfoMapper.getWeekNum(1, "20180709", "20180715");
        log.info("weekNum is :" + weekNum);
    }

    @Test
    public void getHasComunicationTest() {
        Integer hasComunication = customerInfoMapper.getHasComunication(1);
        log.info("hasComunication is :" + hasComunication);
    }

    @Test
    public void getHasInterestTest() {
        Integer hasInterest = customerInfoMapper.getHasInterest(1);
        log.info("hasInterest is :" + hasInterest);
    }

    @Test
    public void getHasCompact() {
        Integer hasCompact = customerInfoMapper.getHasCompact(1);
        log.info("hasCompact is :" + hasCompact);
    }

    @Test
    public void getCustomerInfo() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setUserId(2);
        customerInfo.setStatus(1);
        List<CustomerInfo> customerInfoList = customerInfoMapper.select(customerInfo);

    }

    @Test
    public void custInfoCTest() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setUserId(33);
        customerInfo.setCompanyName("testtestetststst");
        customerInfo.setCustPhone("15964544466");
        int insert = customerInfoMapper.insert(customerInfo);
        log.info("insert is :" + insert);
    }

    @Test
    public void test1() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(76);
        customerInfo.setCompanyName("啊啊啊啊啊啊啊啊啊啊啊啊");
        customerInfo.setModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        log.info("info is :" + i);
    }
}
