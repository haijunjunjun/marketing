package com.niule.marketing.controller.controller.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.marketing.controller.controller.constant.PageConstant;
import com.niule.marketing.controller.controller.dal.mapper.*;
import com.niule.marketing.controller.controller.dal.mapper.define.FinanceCountResponseMapper;
import com.niule.marketing.controller.controller.dal.mapper.define.UserCashDetailResponseMapper;
import com.niule.marketing.controller.controller.dal.mapper.define.UserCommissionResponseMapper;
import com.niule.marketing.controller.controller.dal.model.*;
import com.niule.marketing.controller.controller.dal.model.define.FinanceCountResponse;
import com.niule.marketing.controller.controller.dal.model.define.UserCashDetailResponse;
import com.niule.marketing.controller.controller.dal.model.define.UserCommissionResponse;
import com.niule.marketing.controller.controller.model.*;
import com.niule.marketing.controller.controller.util.ListPageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 10:31
 */
@Slf4j
@Service
public class UserFinanceService {

    @Autowired
    private CashDetailMapper cashDetailMapper;
    @Autowired
    private UserCashDetailResponseMapper userCashDetailResponseMapper;
    @Autowired
    private UserCommissionResponseMapper userCommissionResponseMapper;
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private FinanceCountResponseMapper financeCountResponseMapper;
    @Autowired
    private PayRecordFinalMapper payRecordFinalMapper;
    @Autowired
    private PayRecordMapper payRecordMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserCommissionsMapper userCommissionsMapper;
    @Autowired
    private UserCommissionCountMapper userCommissionCountMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private AreaCityMapper areaCityMapper;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    public PageInfo<UserCashDetailResponseModel> getUserCashDetailInfo(UserCashDetailRequestModel userCashDetailRequestModel) {
        List<UserCashDetailResponseModel> userCashDetailResponseModelList = new ArrayList<>();

        UserCashDetailRequestModel userCashDetailRequestModelV1 = new UserCashDetailRequestModel();
        if (!StringUtils.isEmpty(userCashDetailRequestModel.getUserRealName()) && userCashDetailRequestModel.getUserRealName().length() != 0) {
            userCashDetailRequestModelV1.setUserRealName(userCashDetailRequestModel.getUserRealName());
        }
        if (!StringUtils.isEmpty(userCashDetailRequestModel.getUserPhone()) && userCashDetailRequestModel.getUserPhone().length() != 0) {
            userCashDetailRequestModelV1.setUserPhone(userCashDetailRequestModel.getUserPhone());
        }
        if (!StringUtils.isEmpty(userCashDetailRequestModel.getStartTime()) && userCashDetailRequestModel.getStartTime().length() != 0) {
            userCashDetailRequestModelV1.setStartTime(userCashDetailRequestModel.getStartTime());
        }
        if (!StringUtils.isEmpty(userCashDetailRequestModel.getEndTime()) && userCashDetailRequestModel.getEndTime().length() != 0) {
            userCashDetailRequestModelV1.setEndTime(userCashDetailRequestModel.getEndTime());
        }
        if (!Objects.isNull(userCashDetailRequestModel.getStatus()) && userCashDetailRequestModel.getStatus() != 99) {
            userCashDetailRequestModelV1.setStatus(userCashDetailRequestModel.getStatus());
        }
        PageHelper.startPage(userCashDetailRequestModel.getPageNum() == null ? 1 : userCashDetailRequestModel.getPageNum(), userCashDetailRequestModel.getPageSize() == null ? 10 : userCashDetailRequestModel.getPageSize());
        List<UserCashDetailResponse> userCashDetailResponses = userCashDetailResponseMapper.searchUserCashDetail(userCashDetailRequestModelV1);
        PageInfo userCashDetailResponsePageInfo = new PageInfo<>(userCashDetailResponses);
        if (!Objects.isNull(userCashDetailResponses) && userCashDetailResponses.size() != 0) {
            userCashDetailResponses.forEach(userCashDetailResponse -> {
                UserCashDetailResponseModel userCashDetailResponseModel = new UserCashDetailResponseModel();
                BeanUtils.copyProperties(userCashDetailResponse, userCashDetailResponseModel);
                userCashDetailResponseModelList.add(userCashDetailResponseModel);
            });
        }
        userCashDetailResponsePageInfo.setList(userCashDetailResponseModelList);
        return userCashDetailResponsePageInfo;
    }

    public List<UserCommissionResponseModel> getUserCommissionInfo(UserCommissionRequestModel userCommissionRequestModel) {
        List<UserCommissionResponseModel> userCommissionResponseModelList = new ArrayList<>();

        UserCommissionRequestModel userCommissionRequestModelV1 = new UserCommissionRequestModel();
        if (!StringUtils.isEmpty(userCommissionRequestModel.getCity()) && userCommissionRequestModel.getCity().length() != 0) {
            userCommissionRequestModelV1.setCity(userCommissionRequestModel.getCity());
        }
        if (!StringUtils.isEmpty(userCommissionRequestModel.getRealName()) && userCommissionRequestModel.getRealName().length() != 0) {
            userCommissionRequestModelV1.setRealName(userCommissionRequestModel.getRealName());
        }
        if (!StringUtils.isEmpty(userCommissionRequestModel.getSearchTime()) && userCommissionRequestModel.getSearchTime().length() != 0) {
            userCommissionRequestModelV1.setSearchTime(userCommissionRequestModel.getSearchTime());
        }
        List<UserCommissionResponse> userCommissionResponses = userCommissionResponseMapper.searchUserCommission(userCommissionRequestModelV1);
        if (!Objects.isNull(userCommissionResponses) && userCommissionResponses.size() != 0) {
            userCommissionResponses.forEach(userCommissionResponse -> {
                UserCommissionResponseModel userCommissionResponseModel = new UserCommissionResponseModel();
                BeanUtils.copyProperties(userCommissionResponse, userCommissionResponseModel);
                userCommissionResponseModelList.add(userCommissionResponseModel);
            });
        }
        return userCommissionResponseModelList;
    }

    public String userCashCheck(UserCashCheckRequestModel userCashCheckRequestModel) {
        CashDetailExample cashDetailExample = new CashDetailExample();
        cashDetailExample.createCriteria().andIdEqualTo(userCashCheckRequestModel.getId());
        List<CashDetail> cashDetails = cashDetailMapper.selectByExample(cashDetailExample);
        if (!Objects.isNull(cashDetails) && cashDetails.size() != 0) {
            CashDetail cashDetail = cashDetails.get(0);
            if (1 == userCashCheckRequestModel.getStatus()) {
                CashDetail cashDetailV1 = new CashDetail();
                cashDetailV1.setId(cashDetail.getId());
                cashDetailV1.setCheckStatus(1);
                cashDetailV1.setModifyTime(new Date());
                int i = cashDetailMapper.updateByPrimaryKeySelective(cashDetailV1);
                if (1 != i) {
                    log.info(cashDetail.getUserId() + "状态更新失败!");
                    return "系统异常!";
                }
            }
            if (2 == userCashCheckRequestModel.getStatus()) {
                CashDetail cashDetailV2 = new CashDetail();
                cashDetailV2.setId(cashDetail.getId());
                cashDetailV2.setCheckStatus(2);
                cashDetailV2.setModifyTime(new Date());
                cashDetailV2.setRefuseReason(userCashCheckRequestModel.getRefuseReason());
                int i = cashDetailMapper.updateByPrimaryKeySelective(cashDetailV2);
                if (1 != i) {
                    log.info(cashDetail.getUserId() + "状态更新失败!");
                    return "系统异常!";
                }
                UserAccount userAccountInfo = this.getUserAccountInfo(cashDetail.getUserId());
                if (!Objects.isNull(userAccountInfo)) {
                    Double balance = userAccountInfo.getBalance();
                    double v = new BigDecimal(balance.toString()).add(new BigDecimal(cashDetail.getCash().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    UserAccountExample userAccountExample = new UserAccountExample();
                    userAccountExample.createCriteria().andUserIdEqualTo(cashDetail.getUserId());
                    UserAccount userAccount = new UserAccount();
                    userAccount.setBalance(v);
                    userAccount.setModifyTime(new Date());
                    int i1 = userAccountMapper.updateByExampleSelective(userAccount, userAccountExample);
                    if (1 != i1) {
                        log.info("账户更新失败!");
                        return "系统异常!";
                    }
                }
            }
        }
        return "审核成功";
    }

    public UserCashDetailResponseModel userCashCheckEditInfo(IdModel idModel) {
        UserCashDetailResponseModel userCashDetailResponseModel = new UserCashDetailResponseModel();

        UserCashDetailResponse userCashDetailResponses = userCashDetailResponseMapper.userCashCheckEditInfo(idModel.getId());
        if (!Objects.isNull(userCashDetailResponses)) {
            BeanUtils.copyProperties(userCashDetailResponses, userCashDetailResponseModel);
            return userCashDetailResponseModel;
        }
        return null;
    }

    public String userMoneyCheck(UserMoneyCheckRequestModel userMoneyCheckRequestModel) {
        if (3 == userMoneyCheckRequestModel.getIsMoneyStatus()) {
            CashDetail cashDetail = new CashDetail();
            cashDetail.setId(userMoneyCheckRequestModel.getId());

            cashDetail.setMoneyCertificate(userMoneyCheckRequestModel.getMoneyCertificateImg());
            cashDetail.setCheckStatus(3);
            cashDetail.setModifyTime(new Date());
            int i = cashDetailMapper.updateByPrimaryKeySelective(cashDetail);
            if (1 != i) {
                log.info("打款失败!");
                return "打款失败!";
            }
        }
        if (4 == userMoneyCheckRequestModel.getIsMoneyStatus()) {
            CashDetail cashDetail = new CashDetail();
            cashDetail.setId(userMoneyCheckRequestModel.getId());

            cashDetail.setCheckStatus(4);
            cashDetail.setRefuseMoneyReason(userMoneyCheckRequestModel.getRefuseMoneyReason());
            cashDetail.setModifyTime(new Date());
            int i = cashDetailMapper.updateByPrimaryKeySelective(cashDetail);
            if (1 != i) {
                log.info("更新失败!");
                return "更新失败!";
            }
        }
        return "打款审核成功!";
    }

    public ListPageUtil<FinanceCountResponseModel> searchFinanceCount(FinanceCountRequestModel financeCountRequestModel) {
        List<FinanceCountResponseModel> financeCountResponseModelSuccessList = new ArrayList<>();
        List<FinanceCountResponseModel> financeCountResponseModelFailList = new ArrayList<>();
        List<FinanceCountResponseModel> financeCountResponseModelWaitList = new ArrayList<>();
        List<FinanceCountResponseModel> financeCountResponseModelAllList = new ArrayList<>();

        FinanceCountRequestModel financeCountRequestModelV1 = new FinanceCountRequestModel();
        if (!StringUtils.isEmpty(financeCountRequestModel.getCustName()) && financeCountRequestModel.getCustName().length() != 0) {
            financeCountRequestModelV1.setCustName(financeCountRequestModel.getCustName());
        }
        if (!StringUtils.isEmpty(financeCountRequestModel.getStartTime()) && financeCountRequestModel.getStartTime().length() != 0) {
            financeCountRequestModelV1.setStartTime(financeCountRequestModel.getStartTime());
        }
        if (!StringUtils.isEmpty(financeCountRequestModel.getEndTime()) && financeCountRequestModel.getEndTime().length() != 0) {
            financeCountRequestModelV1.setEndTime(financeCountRequestModel.getEndTime());
        }
        if (!Objects.isNull(financeCountRequestModel.getPayStatus())) {
            financeCountRequestModelV1.setPayStatus(financeCountRequestModel.getPayStatus());
        }
        List<FinanceCountResponse> financeCountResponseList = financeCountResponseMapper.searchFinanceCount(financeCountRequestModelV1);
        if (!Objects.isNull(financeCountResponseList) && financeCountResponseList.size() != 0) {
            financeCountResponseList.forEach(financeCountResponse -> {
                PayRecordExample payRecordExample = new PayRecordExample();
                payRecordExample.createCriteria().andCustIdEqualTo(financeCountResponse.getId());
                int count = payRecordMapper.countByExample(payRecordExample);
                FinanceCountResponseModel financeCountResponseModel = new FinanceCountResponseModel();
                financeCountResponseModel.setAmount(financeCountResponse.getAmount());
                financeCountResponseModel.setCustName(financeCountResponse.getCustName());
                financeCountResponseModel.setCustPhone(financeCountResponse.getCustPhone());
                financeCountResponseModel.setFeeItem("合同付款");
                financeCountResponseModel.setId(financeCountResponse.getId());
                financeCountResponseModel.setPayTime(financeCountResponse.getPayTime());
                financeCountResponseModel.setPayType("微信支付");
                financeCountResponseModel.setUserRealName(financeCountResponse.getUserRealName());
                if (99 == financeCountRequestModel.getPayStatus()) {
                    if (count == 0) {
                        financeCountResponseModel.setPayStatus("暂无");
                    }
                    if (count > 0 && financeCountResponse.getReturnMsg() == null && financeCountResponse.getPayResult() == null) {
                        financeCountResponseModel.setPayStatus("待支付");
                    }
                    if ("success_pay".equals(financeCountResponse.getReturnMsg()) && "success".equals(financeCountResponse.getPayResult())) {
                        financeCountResponseModel.setPayStatus("支付成功");
                    }
                    if (count > 0 && !"success_pay".equals(financeCountResponse.getReturnMsg()) && !"success".equals(financeCountResponse.getPayResult())) {
                        financeCountResponseModel.setPayStatus("支付失败");
                    }
                    financeCountResponseModelAllList.add(financeCountResponseModel);
                }
                if (1 == financeCountRequestModel.getPayStatus()) {
                    if ("success_pay".equals(financeCountResponse.getReturnMsg()) && "success".equals(financeCountResponse.getPayResult())) {
                        financeCountResponseModel.setPayStatus("支付成功");
                        financeCountResponseModelSuccessList.add(financeCountResponseModel);
                    }
                }
                if (2 == financeCountRequestModel.getPayStatus()) {
                    if (count > 0 && financeCountResponse.getReturnMsg() == null && financeCountResponse.getPayResult() == null) {
                        financeCountResponseModel.setPayStatus("待支付");
                        financeCountResponseModelWaitList.add(financeCountResponseModel);
                    }
                }
                if (3 == financeCountRequestModel.getPayStatus() && financeCountResponse.getReturnMsg() != null && financeCountResponse.getPayResult() != null) {
                    if (count > 0 && !"success_pay".equals(financeCountResponse.getReturnMsg()) && !"success".equals(financeCountResponse.getPayResult())) {
                        financeCountResponseModel.setPayStatus("支付失败");
                        financeCountResponseModelFailList.add(financeCountResponseModel);
                    }
                }
            });
        }
        if (99 == financeCountRequestModel.getPayStatus() && !Objects.isNull(financeCountResponseModelAllList) && financeCountResponseModelAllList.size() != 0) {
            ListPageUtil pageInfo = new PageConstant<FinanceCountResponseModel>()
                    .getPageInfo(financeCountResponseModelAllList, financeCountRequestModel.getPageNum(), financeCountRequestModel.getPageSize());
            return pageInfo;
        }
        if (1 == financeCountRequestModel.getPayStatus() && !Objects.isNull(financeCountResponseModelSuccessList) && financeCountResponseModelSuccessList.size() != 0) {
            ListPageUtil pageInfo = new PageConstant<FinanceCountResponseModel>()
                    .getPageInfo(financeCountResponseModelSuccessList, financeCountRequestModel.getPageNum(), financeCountRequestModel.getPageSize());
            return pageInfo;
        }
        if (2 == financeCountRequestModel.getPayStatus() && !Objects.isNull(financeCountResponseModelWaitList) && financeCountResponseModelWaitList.size() != 0) {
            ListPageUtil pageInfo = new PageConstant<FinanceCountResponseModel>()
                    .getPageInfo(financeCountResponseModelWaitList, financeCountRequestModel.getPageNum(), financeCountRequestModel.getPageSize());
            return pageInfo;
        }
        if (3 == financeCountRequestModel.getPayStatus() && !Objects.isNull(financeCountResponseModelFailList) && financeCountResponseModelFailList.size() != 0) {
            ListPageUtil pageInfo = new PageConstant<FinanceCountResponseModel>()
                    .getPageInfo(financeCountResponseModelFailList, financeCountRequestModel.getPageNum(), financeCountRequestModel.getPageSize());
            return pageInfo;
        }
        return null;
    }

    public String userCommissionCountAdd(MarketUserCommissionEditModel marketUserCommissionEditModel) {
        UserCommissionCount userCommissionCount = new UserCommissionCount();
        if (!Objects.isNull(marketUserCommissionEditModel.getUserId())) {
            userCommissionCount.setUserId(marketUserCommissionEditModel.getUserId());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getCity()) && marketUserCommissionEditModel.getCity().length() != 0) {
            userCommissionCount.setCity(marketUserCommissionEditModel.getCity());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getMonth()) && marketUserCommissionEditModel.getMonth().length() != 0) {
            userCommissionCount.setMonth(marketUserCommissionEditModel.getMonth());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getYear()) && marketUserCommissionEditModel.getYear().length() != 0) {
            userCommissionCount.setYear(marketUserCommissionEditModel.getYear());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getUserRealName()) && marketUserCommissionEditModel.getUserRealName().length() != 0) {
            userCommissionCount.setRealName(marketUserCommissionEditModel.getUserRealName());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getBaseSalary())) {
            userCommissionCount.setBaseSalary(marketUserCommissionEditModel.getBaseSalary());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getCommission())) {
            userCommissionCount.setCommission(marketUserCommissionEditModel.getCommission());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getPersonalTax())) {
            userCommissionCount.setPersonalTax(marketUserCommissionEditModel.getPersonalTax());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getOtherFee())) {
            userCommissionCount.setOtherFee(marketUserCommissionEditModel.getOtherFee());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getSocialInsurance())) {
            userCommissionCount.setSocialInsurance(marketUserCommissionEditModel.getSocialInsurance());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getTotalAmount())) {
            userCommissionCount.setCountTotal(marketUserCommissionEditModel.getTotalAmount());
        }
        userCommissionCount.setCreateTime(new Date());
        int insert = userCommissionCountMapper.insert(userCommissionCount);
        if (1 != insert) {
            log.info("添加失败!");
            return "系统信息异常";
        }
        return "添加成功";
    }

    public MarketUserCommissionEditModel getMarketUserCommissionEditInfo(IdModel idModel) {
        MarketUserCommissionEditModel marketUserCommissionEditModel = new MarketUserCommissionEditModel();
        UserCommissionCountExample userCommissionCountExample = new UserCommissionCountExample();
        userCommissionCountExample.createCriteria().andIdEqualTo(idModel.getId());
        List<UserCommissionCount> userCommissionCounts = userCommissionCountMapper.selectByExample(userCommissionCountExample);
        if (!Objects.isNull(userCommissionCounts) && userCommissionCounts.size() != 0) {
            UserCommissionCount userCommissionCount = userCommissionCounts.get(0);
            if (!Objects.isNull(userCommissionCount)) {
                if (!StringUtils.isEmpty(userCommissionCount.getCity()) && userCommissionCount.getCity().length() != 0) {
                    marketUserCommissionEditModel.setCity(userCommissionCount.getCity());
                }
                if (!StringUtils.isEmpty(userCommissionCount.getMonth()) && userCommissionCount.getCity().length() != 0) {
                    marketUserCommissionEditModel.setMonth(userCommissionCount.getMonth());
                }
                if (!StringUtils.isEmpty(userCommissionCount.getRealName()) && userCommissionCount.getRealName().length() != 0) {
                    marketUserCommissionEditModel.setUserRealName(userCommissionCount.getRealName());
                }
                if (!StringUtils.isEmpty(userCommissionCount.getYear()) && userCommissionCount.getYear().length() != 0) {
                    marketUserCommissionEditModel.setYear(userCommissionCount.getYear());
                }
                if (!Objects.isNull(userCommissionCount.getCountTotal())) {
                    marketUserCommissionEditModel.setTotalAmount(userCommissionCount.getCountTotal());
                }
                if (!Objects.isNull(userCommissionCount.getBaseSalary())) {
                    marketUserCommissionEditModel.setBaseSalary(userCommissionCount.getBaseSalary());
                }
                if (!Objects.isNull(userCommissionCount.getCommission())) {
                    marketUserCommissionEditModel.setCommission(userCommissionCount.getCommission());
                }
                if (!Objects.isNull(userCommissionCount.getId())) {
                    marketUserCommissionEditModel.setId(userCommissionCount.getId());
                }
                if (!Objects.isNull(userCommissionCount.getOtherFee())) {
                    marketUserCommissionEditModel.setOtherFee(userCommissionCount.getOtherFee());
                }
                if (!Objects.isNull(userCommissionCount.getPersonalTax())) {
                    marketUserCommissionEditModel.setPersonalTax(userCommissionCount.getPersonalTax());
                }
                if (!Objects.isNull(userCommissionCount.getSocialInsurance())) {
                    marketUserCommissionEditModel.setSocialInsurance(userCommissionCount.getSocialInsurance());
                }
                if (!Objects.isNull(userCommissionCount.getUserId())) {
                    marketUserCommissionEditModel.setUserId(userCommissionCount.getUserId());
                    UserInfoExample userInfoExample = new UserInfoExample();
                    userInfoExample.createCriteria().andIdEqualTo(userCommissionCount.getUserId());
                    List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
                    if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
                        UserInfo userInfo = userInfos.get(0);
                        if (!Objects.isNull(userInfo) && !StringUtils.isEmpty(userInfo.getPhone())) {
                            marketUserCommissionEditModel.setPhone(userInfo.getPhone());
                        }
                    }
                }
            }
        }
        return marketUserCommissionEditModel;
    }

    public String userCommissionCountEdit(MarketUserCommissionEditModel marketUserCommissionEditModel) {
        UserCommissionCount userCommissionCount = new UserCommissionCount();
        userCommissionCount.setId(marketUserCommissionEditModel.getId());
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getCity()) && marketUserCommissionEditModel.getCity().length() != 0) {
            userCommissionCount.setCity(marketUserCommissionEditModel.getCity());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getMonth()) && marketUserCommissionEditModel.getMonth().length() != 0) {
            userCommissionCount.setMonth(marketUserCommissionEditModel.getMonth());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getYear()) && marketUserCommissionEditModel.getYear().length() != 0) {
            userCommissionCount.setYear(marketUserCommissionEditModel.getYear());
        }
        if (!StringUtils.isEmpty(marketUserCommissionEditModel.getUserRealName()) && marketUserCommissionEditModel.getUserRealName().length() != 0) {
            userCommissionCount.setRealName(marketUserCommissionEditModel.getUserRealName());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getBaseSalary())) {
            userCommissionCount.setBaseSalary(marketUserCommissionEditModel.getBaseSalary());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getCommission())) {
            userCommissionCount.setCommission(marketUserCommissionEditModel.getCommission());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getPersonalTax())) {
            userCommissionCount.setPersonalTax(marketUserCommissionEditModel.getPersonalTax());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getOtherFee())) {
            userCommissionCount.setOtherFee(marketUserCommissionEditModel.getOtherFee());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getSocialInsurance())) {
            userCommissionCount.setSocialInsurance(marketUserCommissionEditModel.getSocialInsurance());
        }
        if (!Objects.isNull(marketUserCommissionEditModel.getTotalAmount())) {
            userCommissionCount.setCountTotal(marketUserCommissionEditModel.getTotalAmount());
        }
        int i = userCommissionCountMapper.updateByPrimaryKeySelective(userCommissionCount);
        if (1 != i) {
            log.info("更新失败");
            return "系统信息异常";
        }
        return "更新成功";
    }

    public PageInfo<MarketUserCommissionResponseModel> userCommissionCountResponse(MarketUserCommissionRequestModel marketUserCommissionRequestModel) {
        List<MarketUserCommissionResponseModel> marketUserCommissionResponseModelList = new ArrayList<>();
        MarketUserCommissionRequestModel marketUserCommissionRequestModelV1 = new MarketUserCommissionRequestModel();
        if (!StringUtils.isEmpty(marketUserCommissionRequestModel.getCity()) && marketUserCommissionRequestModel.getCity().length() != 0) {
            marketUserCommissionRequestModelV1.setCity(marketUserCommissionRequestModel.getCity());
        }
        if (!StringUtils.isEmpty(marketUserCommissionRequestModel.getRealName()) && marketUserCommissionRequestModel.getRealName().length() != 0) {
            marketUserCommissionRequestModelV1.setRealName(marketUserCommissionRequestModel.getRealName());
        }
        if (!StringUtils.isEmpty(marketUserCommissionRequestModel.getTime()) && marketUserCommissionRequestModel.getTime().length() != 0) {
            marketUserCommissionRequestModelV1.setTime(marketUserCommissionRequestModel.getTime());
        }
        PageHelper.startPage(marketUserCommissionRequestModel.getPageNum() == null ? 1 : marketUserCommissionRequestModel.getPageNum(), marketUserCommissionRequestModel.getPageSize() == null ? 10 : marketUserCommissionRequestModel.getPageSize());
        List<UserCommissionCount> userCommissionCounts = userCommissionCountMapper.fetchUserCommissionInfo(marketUserCommissionRequestModelV1);
        PageInfo userCommissionCountPageInfo = new PageInfo<>(userCommissionCounts);
        if (!Objects.isNull(userCommissionCounts) && userCommissionCounts.size() != 0) {
            userCommissionCounts.forEach(userCommissionCount -> {
                MarketUserCommissionResponseModel marketUserCommissionResponseModel = new MarketUserCommissionResponseModel();
                if (!Objects.isNull(userCommissionCount.getCountTotal())) {
                    marketUserCommissionResponseModel.setAmount(userCommissionCount.getCountTotal());
                }
                marketUserCommissionResponseModel.setCity(userCommissionCount.getCity());
                marketUserCommissionResponseModel.setCreateTime(userCommissionCount.getCreateTime());
                marketUserCommissionResponseModel.setId(userCommissionCount.getId());
                UserInfo userInfo = this.getUserInfo(userCommissionCount.getUserId());
                if (!Objects.isNull(userInfo)) {
                    marketUserCommissionResponseModel.setUserPhone(userInfo.getPhone());
                    marketUserCommissionResponseModel.setUserRealName(userInfo.getRealName());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    String format = sdf.format(userCommissionCount.getCreateTime());
                    marketUserCommissionResponseModel.setYearMonth(format);
                }
                marketUserCommissionResponseModelList.add(marketUserCommissionResponseModel);
            });
        }
        userCommissionCountPageInfo.setList(marketUserCommissionResponseModelList);
        return userCommissionCountPageInfo;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------

    private UserInfo getUserInfo(Integer userId) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andIdEqualTo(userId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
            UserInfo userInfo = userInfos.get(0);
            if (!Objects.isNull(userInfo)) {
                return userInfo;
            }
        }
        return null;
    }

    private UserAccount getUserAccountInfo(Integer userId) {
        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andUserIdEqualTo(userId);
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);
        if (!Objects.isNull(userAccounts) && userAccounts.size() != 0) {
            UserAccount userAccount = userAccounts.get(0);
            if (!Objects.isNull(userAccount)) {
                return userAccount;
            }
        }
        return null;
    }

    private PayRecordFinal getPayRecordFinal(Integer custId) {
        PayRecordFinalExample payRecordFinalExample = new PayRecordFinalExample();
        payRecordFinalExample.createCriteria().andCustIdEqualTo(custId);
        List<PayRecordFinal> payRecordFinals = payRecordFinalMapper.selectByExample(payRecordFinalExample);
        if (!Objects.isNull(payRecordFinals) && payRecordFinals.size() != 0) {
            PayRecordFinal payRecordFinal = payRecordFinals.get(0);
            if (!Objects.isNull(payRecordFinal)) {
                return payRecordFinal;
            }
        }
        return null;
    }

    private PayRecord getPayRecord(Integer custId) {
        PayRecordExample payRecordExample = new PayRecordExample();
        payRecordExample.createCriteria().andCustIdEqualTo(custId);
        payRecordExample.setOrderByClause("create_time desc");
        List<PayRecord> payRecords = payRecordMapper.selectByExample(payRecordExample);
        if (!Objects.isNull(payRecords) && payRecords.size() != 0) {
            PayRecord payRecord = payRecords.get(0);
            if (!Objects.isNull(payRecord)) {
                return payRecord;
            }
        }
        return null;
    }

    public List<UInfoModel> fetchUserRealName(String city) {
        List<UInfoModel> uInfoModelList = new ArrayList<>();

        Map<String, String> mapData = new HashMap<>();
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andCityEqualTo(city);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
            userInfos.forEach(userInfo -> {
                UInfoModel uInfoModel = new UInfoModel();
                uInfoModel.setUserId(userInfo.getId());
                uInfoModel.setUserPhone(userInfo.getPhone());
                uInfoModel.setUserRealName(userInfo.getRealName());
                uInfoModelList.add(uInfoModel);
            });
        }
        return uInfoModelList;
    }

    public double fetchUserCommission(CommissionModel commissionModel) {
        double total = 0.00;
        CommissionModel commissionModelV1 = new CommissionModel();
        if (!Objects.isNull(commissionModel.getUserId())) {
            commissionModelV1.setUserId(commissionModel.getUserId());
        }
        if (!StringUtils.isEmpty(commissionModel.getTime()) && commissionModel.getTime().length() != 0) {
            commissionModelV1.setTime(commissionModel.getTime());
        }
        List<UserCommissions> userCommissions = userCommissionsMapper.fetchUserCommission(commissionModelV1);
        if (!Objects.isNull(userCommissions) && userCommissions.size() != 0) {
            for (UserCommissions u : userCommissions) {
                total = new BigDecimal(Double.toString(total)).add(new BigDecimal(u.getCommission().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }
        return total;
    }

    public List<AreaCityInfoModel> getAreaCityInfo() {
        List<AreaCityInfoModel> areaCityInfoModelList = new ArrayList<>();

        AreaExample areaExample = new AreaExample();
        areaExample.createCriteria();
        List<Area> areas = areaMapper.selectByExample(areaExample);
        if (!Objects.isNull(areas) && areas.size() != 0) {
            areas.forEach(area -> {
                List<String> cityList = new ArrayList<>();
                AreaCityInfoModel areaCityInfoModel = new AreaCityInfoModel();
                areaCityInfoModel.setArea(area.getAreaName());
                AreaCityExample areaCityExample = new AreaCityExample();
                areaCityExample.createCriteria().andAreaNoEqualTo(area.getAreaNo());
                List<AreaCity> areaCities = areaCityMapper.selectByExample(areaCityExample);
                if (!Objects.isNull(areaCities) && areaCities.size() != 0) {
                    areaCities.forEach(areaCity -> {
                        cityList.add(areaCity.getCityName());
                    });
                }
                areaCityInfoModel.setCity(cityList);
                areaCityInfoModelList.add(areaCityInfoModel);
            });
        }
        return areaCityInfoModelList;
    }
}
