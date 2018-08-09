package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.ComplaintMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Complaint;
import com.niule.yunjiagong.yunjiagong.model.ComplaintModel;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 16:18
 */
@Slf4j
@Service
public class ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;

    public MessageInfo doComplaint(ComplaintModel complaintModel) {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        MessageInfo messageInfo = new MessageInfo();
        if (Objects.isNull(userBaseInfo.getId())) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常！");
        }
        if (Objects.isNull(complaintModel.getTargetId())) {
            messageInfo.setContent("targetId is null !");
            return messageInfo;
        }
        if (StringUtils.isEmpty(complaintModel.getContent())) {
            messageInfo.setContent("投诉内容不能为空!");
            return messageInfo;
        }
        if (StringUtils.isEmpty(complaintModel.getOrderNo())) {
            messageInfo.setContent("订单号不能为空!");
            return messageInfo;
        }
        if (StringUtils.isEmpty(complaintModel.getRemark())) {
            messageInfo.setContent("备注不能为空！");
            return messageInfo;
        }
        complaintModel.setUserId(userBaseInfo.getId().intValue());
        Complaint complaint = new Complaint();
        BeanUtils.copyProperties(complaintModel, complaint);
        complaint.setCreateTime(new Date());
        int i = complaintMapper.insertSelective(complaint);
        if (1 == i) {
            messageInfo.setContent("投诉成功,请等待审核!");
            return messageInfo;
        }
        messageInfo.setContent("投诉失败，系统异常!");
        return messageInfo;
    }
}
