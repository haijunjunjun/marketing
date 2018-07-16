package com.example.demo.service;

import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.*;
import com.example.demo.model.MyList;
import com.example.demo.model.MyPerformanceModel;
import com.example.demo.model.MyPersonalInfo;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.PerformanceMessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class MyService {

    private UserInfoMapper userInfoMapper;
    private UserAccountMapper userAccountMapper;
    private UserPerformanceMapper userPerformanceMapper;
    private UserGoldBeansMapper userGoldBeansMapper;
    private CashDetailMapper cashDetailMapper;
    private CustomerInfoMapper customerInfoMapper;
    private GoldBeansApplyMapper goldBeansApplyMapper;

    @Autowired
    public MyService(UserInfoMapper userInfoMapper,
                     UserAccountMapper userAccountMapper,
                     UserPerformanceMapper userPerformanceMapper,
                     UserGoldBeansMapper userGoldBeansMapper,
                     CashDetailMapper cashDetailMapper,
                     CustomerInfoMapper customerInfoMapper,
                     GoldBeansApplyMapper goldBeansApplyMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userAccountMapper = userAccountMapper;
        this.userPerformanceMapper = userPerformanceMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
        this.cashDetailMapper = cashDetailMapper;
        this.customerInfoMapper = customerInfoMapper;
        this.goldBeansApplyMapper = goldBeansApplyMapper;
    }

    public MessageInfo<MyList> getMyListInfo(Integer userId) {
        MessageInfo<MyList> myListMessageInfo = new MessageInfo<>();
        MyList myList = new MyList();
        if (StringUtils.isEmpty(userId.toString()) || userId <= 0) {
            log.info("userid 参数信息异常 !");
            throw new BizRuntimeException("userId 参数信息异常!");
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(userInfo)) {
            log.info("用户信息数据查询异常!");
            throw new BizRuntimeException("用户信息数据查询异常!");
        }
        myList.setImagesUrl(userInfo.getImageUrl());
        myList.setRealName(userInfo.getRealName());
        myList.setPhone(userInfo.getPhone());
        myList.setLevel(userInfo.getLevel());
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        UserAccount userAccounts = userAccountMapper.selectOne(userAccount);
        if (Objects.isNull(userAccounts)) {
            log.info("用户账户数据查询异常!");
            throw new BizRuntimeException("用户账户数据查询异常!");
        }
        myList.setBalance(userAccounts.getBalance());

        UserPerformance userPerformance = new UserPerformance();
        userPerformance.setUserId(userId);
        List<UserPerformance> userPerformanceList = userPerformanceMapper.select(userPerformance);
        Integer totalPerformance = 0;
        for (UserPerformance u : userPerformanceList) {
            totalPerformance += u.getPerformance();
        }
        myList.setPerformance(totalPerformance);

        UserGoldBeans userGoldBeans = new UserGoldBeans();
        userGoldBeans.setUserId(userId);
        UserGoldBeans userGoldBeansInfo = userGoldBeansMapper.selectOne(userGoldBeans);
        if (Objects.isNull(userGoldBeansInfo)) {
            log.info("用户金豆数据查询异常！");
            myListMessageInfo.setContent("用户金豆数量查询异常");
            return myListMessageInfo;
        }
        myList.setGoldBeansNum(userGoldBeansInfo.getGoldBeansNum());

        myListMessageInfo.setContent("success");
        myListMessageInfo.setData(myList);
        return myListMessageInfo;
    }

    public MyPersonalInfo getMyPersonalInfo(Integer userId) {
        MyPersonalInfo myPersonalInfo = new MyPersonalInfo();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("userid参数信息异常！");
            throw new BizRuntimeException("userid 参数信息异常！");
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(userInfo)) {
            log.info("用户信息查询异常!");
            throw new BizRuntimeException("用户信息查询异常!");
        }
        myPersonalInfo.setImageUrl(userInfo.getImageUrl());
        myPersonalInfo.setPhone(userInfo.getPhone());
        myPersonalInfo.setRealName(userInfo.getRealName());
        myPersonalInfo.setSex(userInfo.getSex());
        return myPersonalInfo;
    }

    public void editPersonalInfo(Integer userId, String imageUrl, Integer sex) {
        if (StringUtils.isEmpty(userId.toString()) || StringUtils.isEmpty(imageUrl) || StringUtils.isEmpty(sex.toString())) {
            log.info("参数信息有误!");
            throw new BizRuntimeException("参数信息有误!");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setImageUrl(imageUrl);
        userInfo.setSex(sex);
        int i = userInfoMapper.updateByPrimaryKey(userInfo);
        if (i != 1) {
            log.info("数据存储失败!");
            throw new BizRuntimeException("数据存储失败!");
        }
    }

    public PerformanceMessageInfo<List<MyPerformanceModel>> getMyPerformanceInfo(Integer userId, Date date) {
        PerformanceMessageInfo<List<MyPerformanceModel>> listPerformanceMessageInfo = new PerformanceMessageInfo<>();
        List<MyPerformanceModel> myPerformanceModelList = new ArrayList<>();
        MyPerformanceModel myPerformanceModel = new MyPerformanceModel();
        if (Objects.isNull(userId) || Objects.isNull(date)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常!");
        }
        UserPerformance userPerformance = new UserPerformance();
        userPerformance.setUserId(userId);
        List<UserPerformance> userPerformanceList = userPerformanceMapper.select(userPerformance);
        if (Objects.isNull(userPerformanceList)) {
            log.info("查询信息异常!");
            throw new BizRuntimeException("查询信息异常!");
        }
        int performance = 0;
        for (UserPerformance u : userPerformanceList) {
            myPerformanceModel.setTime(u.getCreateTime());
            performance += u.getPerformance();
            myPerformanceModel.setPerformance(u.getPerformance());
            CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(u.getCustId());
            if (Objects.isNull(customerInfo)) {
                log.info("客户信息查询异常!");
                throw new BizRuntimeException("客户信息查询异常！");
            }
            myPerformanceModel.setCompanyName(customerInfo.getCompanyName());
            myPerformanceModel.setCompanyType(customerInfo.getCompanyType());
            myPerformanceModel.setCustName(customerInfo.getCustName());
            myPerformanceModel.setCustPhone(customerInfo.getCustPhone());
            myPerformanceModelList.add(myPerformanceModel);
        }
        listPerformanceMessageInfo.setData(myPerformanceModelList);
        listPerformanceMessageInfo.setTotalPerformance(performance);
        return listPerformanceMessageInfo;
    }

    public List<GoldBeansApply> getGoldBeansApplyInfo(Integer userId) {
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("userid 参数信息异常!");
            throw new BizRuntimeException("参数信息异常!");
        }
        GoldBeansApply goldBeansApply = new GoldBeansApply();
        goldBeansApply.setUserId(userId);
        List<GoldBeansApply> goldBeansApplyList = goldBeansApplyMapper.select(goldBeansApply);
        if (Objects.isNull(goldBeansApplyList)) {
            log.info("用户金豆申请列表信息获取异常!");
            throw new BizRuntimeException("用户金豆申请列表信息获取异常!");
        }
        return goldBeansApplyList;
    }

    public void goldBeanApply(Integer userId, Integer applyNum) {
        if (StringUtils.isEmpty(userId.toString()) || StringUtils.isEmpty(applyNum)) {
            log.info("参数信息获取异常!");
            throw new BizRuntimeException("参数信息获取异常");
        }
        GoldBeansApply goldBeansApply = new GoldBeansApply();
        goldBeansApply.setUserId(userId);
        goldBeansApply.setApplyTime(new Date());
        goldBeansApply.setGoldBeansApplyNum(applyNum);
        goldBeansApply.setStatus(1);
        goldBeansApply.setType(1);
        goldBeansApplyMapper.insert(goldBeansApply);
    }

}
