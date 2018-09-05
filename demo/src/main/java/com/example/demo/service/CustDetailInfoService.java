package com.example.demo.service;

import com.example.demo.constant.ActionStatus;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.UserActionMapper;
import com.example.demo.dal.mapper.UserInfoMapper;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserAction;
import com.example.demo.model.CustDetailInfo;
import com.example.demo.model.CustDetailModel;
import com.example.demo.model.UserActionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 17:10
 */
@Slf4j
@Service
public class CustDetailInfoService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserActionMapper userActionMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    public CustDetailModel getCustDetailInfo(Integer custId) {
        assert custId != null : "custId 不能为空";

        CustDetailModel custDetailModel = new CustDetailModel();
        CustDetailInfo custDetailInfo = new CustDetailInfo();

        List<UserActionModel> userActionModelList = new ArrayList<>();

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        CustomerInfo customerInfoV1 = customerInfoMapper.selectOne(customerInfo);
        custDetailInfo.setPhone(customerInfoV1.getCustPhone());
        custDetailInfo.setCustName(customerInfoV1.getCustName());
        custDetailInfo.setCompanyName(customerInfoV1.getCompanyName());
        custDetailInfo.setCompanyAddr(customerInfoV1.getCompanyAddr());
        custDetailInfo.setMark(customerInfoV1.getMark());
        custDetailInfo.setType(customerInfoV1.getCompanyType());
        custDetailInfo.setId(custId);
        custDetailModel.setCustDetailInfo(custDetailInfo);

        UserAction userAction = new UserAction();
        userAction.setCustId(custId);
        List<UserAction> userActionList = userActionMapper.select(userAction);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        for (UserAction userActionV1 : userActionList) {
            UserActionModel userActionModel = new UserActionModel();
            userActionModel.setUserName(userInfoMapper.selectByPrimaryKey(userActionV1.getUserId()).getRealName());
            userActionModel.setAction(userActionV1.getAction());
            userActionModel.setActionTime(sdf.format(userActionV1.getCreateTime()));
            userActionModelList.add(userActionModel);
        }
        custDetailModel.setUserActionModelList(userActionModelList);
        return custDetailModel;
    }

    public String insertAction(Integer userId, Integer custId, Integer actionType, String mark) {

        assert (actionType != null) : "actionType 不能为空";

        UserAction userAction = new UserAction();
        userAction.setUserId(userId);
        userAction.setCustId(custId);
        if (ActionStatus.VISIT.getCode() == actionType) {
            userAction.setAction(ActionStatus.VISIT.getDesc());
        }
        if (ActionStatus.PHONE.getCode() == actionType) {
            userAction.setAction(ActionStatus.PHONE.getDesc());
        }
        userAction.setCreateTime(new Date());
        userAction.setMark(mark);
        int i = userActionMapper.insert(userAction);
        if (1 != i) {
            log.info("fail");
            return "fail!";
        }
        return "success";
    }
}
