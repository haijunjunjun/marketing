package com.example.demo.service;

import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.*;
import com.example.demo.model.*;
import com.example.demo.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    private UserCommissionsMapper userCommissionsMapper;
    private SumArrangeMapper sumArrangeMapper;

    @Autowired
    public MyService(UserInfoMapper userInfoMapper,
                     UserAccountMapper userAccountMapper,
                     UserPerformanceMapper userPerformanceMapper,
                     UserGoldBeansMapper userGoldBeansMapper,
                     CashDetailMapper cashDetailMapper,
                     CustomerInfoMapper customerInfoMapper,
                     GoldBeansApplyMapper goldBeansApplyMapper,
                     UserCommissionsMapper userCommissionsMapper,
                     SumArrangeMapper sumArrangeMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userAccountMapper = userAccountMapper;
        this.userPerformanceMapper = userPerformanceMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
        this.cashDetailMapper = cashDetailMapper;
        this.customerInfoMapper = customerInfoMapper;
        this.goldBeansApplyMapper = goldBeansApplyMapper;
        this.userCommissionsMapper = userCommissionsMapper;
        this.sumArrangeMapper = sumArrangeMapper;
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
        double totalPerformance = 0.00;
        for (UserPerformance u : userPerformanceList) {
            totalPerformance = new BigDecimal(totalPerformance).add(new BigDecimal(u.getPerformance())).doubleValue();
        }
        myList.setPerformances(totalPerformance);

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
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setImageUrl(imageUrl);
        userInfo.setSex(sex);
        int i = userInfoMapper.updateByPrimaryKey(userInfo);
        if (i != 1) {
            log.info("数据存储失败!");
        }
    }

    public PerformanceMessageInfo<List<MyPerformanceModel>> getMyPerformanceInfo(Integer userId, String date) {
        PerformanceMessageInfo<List<MyPerformanceModel>> listPerformanceMessageInfo = new PerformanceMessageInfo<>();
        List<MyPerformanceModel> myPerformanceModelList = new ArrayList<>();

        if (Objects.isNull(userId) || StringUtils.isEmpty(date)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常!");
        }
        List<UserPerformance> userPerformanceList = userPerformanceMapper.getUserPerformanceListV1(userId, date);

        listPerformanceMessageInfo.setHasComunication(customerInfoMapper.getHasComunication(userId, date));
        listPerformanceMessageInfo.setHasInterest(customerInfoMapper.getHasInterest(userId, date));
        listPerformanceMessageInfo.setHasCompact(customerInfoMapper.getHasCompact(userId, date));

        double performance = 0;
        if (!Objects.isNull(userPerformanceList)) {
            for (UserPerformance u : userPerformanceList) {
                MyPerformanceModel myPerformanceModel = new MyPerformanceModel();
                if (!Objects.isNull(u.getCreateTime())) {
                    myPerformanceModel.setTime(u.getCreateTime());
                    myPerformanceModel.setTimeV1(DateUtil.dateStrV2(u.getCreateTime()));
                }
                performance = new BigDecimal(performance).add(new BigDecimal(u.getPerformance())).doubleValue();
                myPerformanceModel.setPerformance(u.getPerformance());
                CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(u.getCustId());
                if (Objects.isNull(customerInfo)) {
                    log.info("客户信息查询异常!");
                }
                myPerformanceModel.setCompanyName(customerInfo.getCompanyName());
                myPerformanceModel.setCompanyType(customerInfo.getCompanyType());
                myPerformanceModel.setCustName(customerInfo.getCustName());
                myPerformanceModel.setCustPhone(customerInfo.getCustPhone());
                myPerformanceModelList.add(myPerformanceModel);
            }
        }
        listPerformanceMessageInfo.setData(myPerformanceModelList);
        listPerformanceMessageInfo.setTotalPerformance(performance);
        return listPerformanceMessageInfo;
    }

    public GoldBeansMessageInfo<List<GoldBeansApplyModel>> getGoldBeansApplyInfo(Integer userId) {
        GoldBeansMessageInfo<List<GoldBeansApplyModel>> listGoldBeansMessageInfo = new GoldBeansMessageInfo<>();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("userid 参数信息异常!");
            throw new BizRuntimeException("参数信息异常!");
        }
        List<GoldBeansApply> goldBeansApplyList = goldBeansApplyMapper.getGoldBeansApplyInfo(userId);
        if (Objects.isNull(goldBeansApplyList)) {
            log.info("用户金豆申请列表信息获取异常!");
        }
        List<GoldBeansApplyModel> goldBeansApplyModelList = new ArrayList<>();
        for (GoldBeansApply g : goldBeansApplyList) {
            GoldBeansApplyModel goldBeansApplyModel = new GoldBeansApplyModel();
            BeanUtils.copyProperties(g, goldBeansApplyModel);
            if (!Objects.isNull(g.getApplyTime())) {
                goldBeansApplyModel.setApplyTimeV1(DateUtil.dateStrV2(g.getApplyTime()));
            }
            if (!Objects.isNull(g.getCheckTime())) {
                goldBeansApplyModel.setCheckTimeV1(DateUtil.dateStrV2(g.getCheckTime()));
            }
            goldBeansApplyModelList.add(goldBeansApplyModel);
        }
        listGoldBeansMessageInfo.setData(goldBeansApplyModelList);
        UserGoldBeans userGoldBeans = new UserGoldBeans();
        userGoldBeans.setUserId(userId);
        UserGoldBeans userGoldBeansInfo = userGoldBeansMapper.selectOne(userGoldBeans);
        listGoldBeansMessageInfo.setTotalGoldBeans(userGoldBeansInfo.getGoldBeansNum());
        return listGoldBeansMessageInfo;
    }

    public MessageInfoV1 goldBeanApply(Integer userId, Integer applyNum) {
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
        if (StringUtils.isEmpty(userId.toString()) || StringUtils.isEmpty(applyNum)) {
            log.info("参数信息获取异常!");
        }
        GoldBeansApply goldBeansApply = new GoldBeansApply();
        goldBeansApply.setUserId(userId);
        goldBeansApply.setApplyTime(new Date());
        goldBeansApply.setGoldBeansApplyNum(applyNum);
        goldBeansApply.setStatus(1);
        goldBeansApply.setType(1);
        int i = goldBeansApplyMapper.insert(goldBeansApply);
        if (1 != i) {
            messageInfoV1.setContent("申请失败");
            return messageInfoV1;
        }
        messageInfoV1.setContent("申请成功");
        return messageInfoV1;
    }

    public Balance getBalanceList(Integer userId) {
        double totalCash = 0.00;
        double commission = 0.00;
        Balance balance = new Balance();
        List<BalanceCommission> balanceCommissionList = new ArrayList<>();
        List<BalanceCash> balanceCashList = new ArrayList<>();
        if (StringUtils.isEmpty(userId.toString()) || userId <= 0) {
            log.info("参数信息异常!");
        }
//        CashDetail cashDetail = new CashDetail();
//        cashDetail.setUserId(userId);
//        cashDetail.setCheckStatus(1);
        List<CashDetail> cashDetailList = cashDetailMapper.getCashDetailListInfo(userId);
        for (CashDetail c : cashDetailList) {
            BalanceCash balanceCash = new BalanceCash();
            balanceCash.setType("cash");
            balanceCash.setStatus(c.getCheckStatus());
            balanceCash.setCash(-c.getCash());
            if (!Objects.isNull(c.getCreateTime())) {
                balanceCash.setDates(c.getModifyTime() == null ? c.getCreateTime() : c.getModifyTime());
                balanceCash.setDatesV1(DateUtil.dateStrV2(c.getModifyTime() == null ? c.getCreateTime() : c.getModifyTime()));
            }
            balanceCashList.add(balanceCash);
            totalCash = new BigDecimal(Double.toString(totalCash).toString()).add(new BigDecimal(c.getCash().toString())).doubleValue();
        }
//        UserCommissions userCommissions = new UserCommissions();
//        userCommissions.setUserId(userId);
        List<UserCommissions> userCommissionsList = userCommissionsMapper.getUserCommissions(userId);
        for (UserCommissions u : userCommissionsList) {
            BalanceCommission balanceCommission = new BalanceCommission();
            balanceCommission.setType("commission");
            balanceCommission.setCommission(u.getCommission());
            if (!Objects.isNull(u.getCreateTime())) {
                balanceCommission.setDates(u.getModifyTime() == null ? u.getCreateTime() : u.getModifyTime());
                balanceCommission.setDatesV2(DateUtil.dateStrV2(u.getModifyTime() == null ? u.getCreateTime() : u.getModifyTime()));
            }
            balanceCommissionList.add(balanceCommission);
            commission += u.getCommission();
        }
        balance.setBalanceCashList(balanceCashList);
        balance.setBalanceCommissionList(balanceCommissionList);

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        UserAccount userAccountInfo = userAccountMapper.selectOne(userAccount);
        if (Objects.isNull(userAccountInfo)) {
            log.info("数据查询异常!");
        }
//        double balanceInfo = new BigDecimal(userAccountInfo.getBalance().toString())
//                .add(new BigDecimal(Double.toString(commission)))
//                .subtract(new BigDecimal(Double.toString(totalCash))).doubleValue();
        balance.setBalance(userAccountInfo.getBalance());
        return balance;
    }

    public MessageInfo saveSumArrangeList(Integer userId, SumArranModel sumArranModel) {
        MessageInfo listMessageInfo = new MessageInfo<>();
        if (Objects.isNull(sumArranModel.getTodaySum())) {
            log.info("今日总结不能为空!");
            listMessageInfo.setContent("今日总结不能为空!");
        }
        if (Objects.isNull(sumArranModel.getTomorrowArra())) {
            log.info("明日安排不能为空!");
            listMessageInfo.setContent("明日安排不能为空!");
        }
        SumArrange sumArrange = new SumArrange();
        sumArrange.setUserId(userId);
        sumArrange.setTodaySum(sumArranModel.getTodaySum());
        sumArrange.setTomorrowArrange(sumArranModel.getTomorrowArra());
        sumArrange.setCreateTime(new Date());
        int insert = sumArrangeMapper.insert(sumArrange);
        if (1 != insert) {
            log.info("保存失败!");
            listMessageInfo.setContent("保存失败!");
            return listMessageInfo;
        }
        listMessageInfo.setContent("保存成功!");
        return listMessageInfo;
    }

    public MessageInfo<List<SumArrangeModel>> getSumArraInfo(Integer userId) {
        MessageInfo<List<SumArrangeModel>> listMessageInfo = new MessageInfo<>();
        List<SumArrange> sumArrangeList = sumArrangeMapper.getSumArrangeList(userId);
        if (Objects.isNull(sumArrangeList)) {
            listMessageInfo.setContent("获取信息失败");
            return listMessageInfo;
        }
        List<SumArrangeModel> sumArranModelList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (SumArrange s : sumArrangeList) {
            SumArrangeModel sumArrangeModel = new SumArrangeModel();
            BeanUtils.copyProperties(s, sumArrangeModel);
            if (!Objects.isNull(s.getCreateTime())) {
                sumArrangeModel.setCreateTimeV1(sdf.format(s.getCreateTime()));
            }
            sumArranModelList.add(sumArrangeModel);
        }
        listMessageInfo.setData(sumArranModelList);
        listMessageInfo.setContent("获取信息成功");
        return listMessageInfo;
    }

    public MessageInfo<SumArrangeModel> getSumArraListInfo(Integer userId) {
        MessageInfo<SumArrangeModel> listMessageInfo = new MessageInfo<>();
        List<SumArrange> sumArrangeList = sumArrangeMapper.getSumArrangeList(userId);
        if (Objects.isNull(sumArrangeList)) {
            listMessageInfo.setContent("获取信息失败");
            return listMessageInfo;
        }
//        List<SumArrangeModel> sumArranModelList = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (SumArrange s : sumArrangeList) {
//            SumArrangeModel sumArrangeModel = new SumArrangeModel();
//            BeanUtils.copyProperties(s, sumArrangeModel);
//            sumArrangeModel.setCreateTimeV1(sdf.format(s.getCreateTime()));
//            sumArranModelList.add(sumArrangeModel);
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SumArrangeModel sumArrangeModel = new SumArrangeModel();
        BeanUtils.copyProperties(sumArrangeList.get(0), sumArrangeModel);
        if (!Objects.isNull(sumArrangeModel.getCreateTime())) {
            sumArrangeModel.setCreateTimeV1(sdf.format(sumArrangeModel.getCreateTime()));
        }
        listMessageInfo.setData(sumArrangeModel);
        listMessageInfo.setContent("获取信息成功");
        return listMessageInfo;
    }
}
