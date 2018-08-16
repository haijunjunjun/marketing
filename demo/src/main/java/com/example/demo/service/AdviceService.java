package com.example.demo.service;

import com.example.demo.dal.mapper.AdviceRespMapper;
import com.example.demo.dal.model.AdviceResp;
import com.example.demo.util.MessageInfoV1;
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

    public MessageInfoV1 adviceResp(Integer userId, String advice) {
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
        if (StringUtils.isEmpty(advice)) {
            log.info("反馈信息不能为空!");
            messageInfoV1.setContent("反馈信息不能为空");
            return messageInfoV1;
        }
        AdviceResp adviceResp = new AdviceResp();
        adviceResp.setUserId(userId);
        adviceResp.setCreateTime(new Date());
        adviceResp.setAdviceContent(advice);
        int i = adviceRespMapper.insert(adviceResp);
        if (1 != i) {
            log.info("反馈信息提交失败!");
            messageInfoV1.setContent("反馈信息提交失败");
            return messageInfoV1;
        }
        log.info("反馈信息提交成功!");
        messageInfoV1.setContent("反馈信息提交成功");
        return messageInfoV1;
    }
}
