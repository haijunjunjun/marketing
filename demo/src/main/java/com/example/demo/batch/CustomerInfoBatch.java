package com.example.demo.batch;

import com.example.demo.dal.mapper.ConfigMapper;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.model.Config;
import com.example.demo.dal.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 03 - 11:58
 */
@Slf4j
@Component
public class CustomerInfoBatch {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private ConfigMapper configMapper;

    @Scheduled(cron = "0 0 1 ? * *")
    public void executeV1() throws Exception {
        log.info("客户信息 跑批  准备进行·····");
        List<CustomerInfo> customerInfoList = customerInfoMapper.fetchCustomerListInfo();
        if (Objects.isNull(customerInfoList)) {
            return;
        }

        Config config = new Config();
        config.setConfigName("invalid_cust_time");
        Config configInfo = configMapper.selectOne(config);

        for (CustomerInfo customerInfo : customerInfoList) {
            if (this.getDidderDate(new Date(), customerInfo.getLastModifyTime() == null ? customerInfo.getModifyTime() : customerInfo.getLastModifyTime()) == configInfo.getConfigValue()) {
                CustomerInfo cust = new CustomerInfo();
                cust.setId(customerInfo.getId());
                cust.setStatus(3);
                customerInfoMapper.updateByPrimaryKeySelective(cust);
            }
        }
        log.info("客户信息跑批完成!");
    }

    public Integer getDidderDate(Date now, Date pre) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String formatNow = sdf.format(now);
        String formatPre = sdf.format(pre);
        long timeNow = sdf.parse(formatNow).getTime();
        long timePre = sdf.parse(formatPre).getTime();
        return (int) ((timeNow - timePre) / (1000 * 60 * 60 * 24));
    }
}
