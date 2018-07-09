package com.example.demo.service;

import com.example.demo.dal.mapper.AdviceRespMapper;
import com.example.demo.dal.model.AdviceResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Slf4j
@Service
public class AdviceService {

    @Autowired
    private AdviceRespMapper adviceRespMapper;

    public String adviceResp(Integer userId, String advice) {
        if (StringUtils.isEmpty(advice)) {
            log.info("反馈信息不能为空!");
            return "反馈信息不能为空!";
        }
        AdviceResp adviceResp = new AdviceResp();
        adviceResp.setUserId(userId);
        adviceResp.setCreateTime(new Date());
        adviceResp.setAdviceContent(advice);
        int i = adviceRespMapper.insert(adviceResp);
        if (1 != i) {
            log.info("反馈信息提交失败");
            return "反馈信息提交失败";
        }
        log.info("反馈信息提交成功");
        return "反馈信息提交成功";
    }
}
