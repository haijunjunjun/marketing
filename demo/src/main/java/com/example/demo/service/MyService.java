package com.example.demo.service;

import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.*;
import com.example.demo.model.MyList;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Autowired
    public MyService(UserInfoMapper userInfoMapper,
                     UserAccountMapper userAccountMapper,
                     UserPerformanceMapper userPerformanceMapper,
                     UserGoldBeansMapper userGoldBeansMapper,
                     CashDetailMapper cashDetailMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userAccountMapper = userAccountMapper;
        this.userPerformanceMapper = userPerformanceMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
        this.cashDetailMapper = cashDetailMapper;
    }

    public MessageInfo<MyList> getMyListInfo(Integer userId) {
        MessageInfo<MyList> myListMessageInfo = new MessageInfo<>();
        MyList myList = new MyList();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("userid is null !");
            myListMessageInfo.setContent("userId is null !");
            return myListMessageInfo;
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(userInfo)) {
            log.info("用户信息数据查询异常!");
            myListMessageInfo.setContent("数据查询异常!");
            return myListMessageInfo;
        }
        myList.setImagesUrl(userInfo.getImageUrl());
        myList.setRealName(userInfo.getRealName());
        myList.setPhone(userInfo.getPhone());
        // TODO: 2018/7/9 等级计算方法
        myList.setLevel(0);

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        UserAccount userAccounts = userAccountMapper.selectOne(userAccount);
        if (Objects.isNull(userAccounts)) {
            log.info("用户账户数据查询异常!");
            myListMessageInfo.setContent("用户账户数据查询异常!");
            return myListMessageInfo;
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

    public MessageInfo<List<CashDetail>> getMyCashDetail(Integer userId) {
        MessageInfo<List<CashDetail>> listMessageInfo = new MessageInfo<>();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("用户id 参数异常!");
            throw new BizRuntimeException("用户id参数异常!");
        }
        CashDetail cashDetail = new CashDetail();
        cashDetail.setUserId(userId);
        List<CashDetail> cashDetailList = cashDetailMapper.select(cashDetail);
        if (Objects.isNull(cashDetailList)) {
            log.info("查询失败!");
            throw new BizRuntimeException("查询失败");
        }
        listMessageInfo.setData(cashDetailList);
        listMessageInfo.setContent("success");
        return listMessageInfo;
    }
}
