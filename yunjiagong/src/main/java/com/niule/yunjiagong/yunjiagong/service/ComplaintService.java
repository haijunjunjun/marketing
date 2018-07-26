package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.ComplaintMapper;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 16:18
 */
@Slf4j
@Service
public class ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;

    public MessageInfo doComplaint() {
        MessageInfo messageInfo = new MessageInfo();



        return messageInfo;
    }
}
