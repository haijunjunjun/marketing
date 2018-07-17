package com.example.demo.batch;

import com.example.demo.dal.model.UserInfo;
import com.example.demo.service.PerformanceConfigService;
import com.example.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CommissionBatch {

    @Autowired
    private PerformanceConfigService performanceConfigService;
    @Autowired
    private UserInfoService userInfoService;

    //每周二晚上9点49执行跑批任务 （计算提成）
    @Scheduled(cron = "0 49 09 ? * TUE")
    public void executeV1() {
        log.info("prepare execute commission");
        List<UserInfo> userInfo = userInfoService.getUserInfo();
        for (UserInfo u : userInfo) {
            performanceConfigService.saveUserCommission(u.getId());
        }
        log.info("prepare execute commission");
    }
}
