package com.niule.marketing.controller.controller.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.marketing.controller.controller.dal.mapper.*;
import com.niule.marketing.controller.controller.dal.mapper.define.*;
import com.niule.marketing.controller.controller.dal.model.*;
import com.niule.marketing.controller.controller.dal.model.define.*;
import com.niule.marketing.controller.controller.model.*;
import com.niule.marketing.controller.controller.util.CashStatusEnum;
import com.niule.marketing.controller.controller.util.MarketLevelStatusEnum;
import com.niule.marketing.controller.controller.util.MessageInfo;
import com.niule.marketing.controller.controller.util.RoleNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 16:38
 */
@Slf4j
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserPerformanceMapper userPerformanceMapper;
    @Autowired
    private UserResponseMapper userResponseMapper;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private AccountBankMapper accountBankMapper;
    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private UserGoldBeansMapper userGoldBeansMapper;
    @Autowired
    private UserActionMapper userActionMapper;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserActionResponseMapper userActionResponseMapper;
    @Autowired
    private UserPerformanceResponseMapper userPerformanceResponseMapper;
    @Autowired
    private PayRecordMapper payRecordMapper;
    @Autowired
    private GoldBeansApplyMapper goldBeansApplyMapper;
    @Autowired
    private SumArrangeMapper sumArrangeMapper;
    @Autowired
    private CompactCheckResponseMapper compactCheckResponseMapper;
    @Autowired
    private ReceiptApplyResponseMapper receiptApplyResponseMapper;
    @Autowired
    private PayRecordFinalMapper payRecordFinalMapper;
    @Autowired
    private UserReceiptApplyMapper userReceiptApplyMapper;
    @Autowired
    private CashDetailMapper cashDetailMapper;
    @Autowired
    private UserCommissionCountMapper userCommissionCountMapper;

    public List<UserResponseModel> getUserInfo() {
        List<UserResponseModel> userResponseModelList = new ArrayList<>();

        UserInfoExample userInfoExample = new UserInfoExample();
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
            userInfos.forEach(userInfo -> {
                UserResponseModel userResponseModel = new UserResponseModel();
                userResponseModel.setUserId(userInfo.getId());
                userResponseModel.setArea(userInfo.getArea());
                userResponseModel.setCity(userInfo.getCity());
                userResponseModel.setEntryTime(userInfo.getCreateTime());
                userResponseModel.setManageLevel(userInfo.getManageLevel());
                userResponseModel.setMarketLevel(MarketLevelStatusEnum.getNameByCode(userInfo.getLevel().trim()));
                userResponseModel.setPhone(userInfo.getPhone());
                userResponseModel.setRealName(userInfo.getRealName());
                userResponseModel.setRole(RoleNameEnum.getNameByCode(userInfo.getRoleId()));
                userResponseModel.setSex(userInfo.getSex());
                userResponseModel.setStatusName(userInfo.getStatus() == 1 ? "开启" : "禁用");

                UserPerformanceExample userPerformanceExample = new UserPerformanceExample();
                userPerformanceExample.createCriteria().andUserIdEqualTo(userInfo.getId());
                double totalPerformance = 0.00;
                List<UserPerformance> userPerformances = userPerformanceMapper.selectByExample(userPerformanceExample);
                if (!Objects.isNull(userPerformances) && userPerformances.size() != 0) {
                    for (UserPerformance userPerformance : userPerformances) {
                        totalPerformance = new BigDecimal(Double.toString(totalPerformance)).add(new BigDecimal(userPerformance.getPerformance().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    }
                }
                userResponseModel.setTotalPerformance(totalPerformance);
                userResponseModelList.add(userResponseModel);
            });
        }
        return userResponseModelList;
    }

    public List<UserResponseModel> searchUserInfo(UserSearchRequestModel userSearchRequestModel) {
        List<UserResponseModel> userResponseModelList = new ArrayList<>();
        UserSearchRequestModel userSearchRequestModelV1 = new UserSearchRequestModel();
        if (userSearchRequestModel.getUserPhone() != null && userSearchRequestModel.getUserPhone().length() != 0) {
            userSearchRequestModelV1.setUserPhone(userSearchRequestModel.getUserPhone());
        }
        if (userSearchRequestModel.getUserRealName() != null && userSearchRequestModel.getUserRealName().length() != 0) {
            userSearchRequestModelV1.setUserRealName(userSearchRequestModel.getUserRealName());
        }
        if (userSearchRequestModel.getRoleName() != null && userSearchRequestModel.getRoleName() != 99 && userSearchRequestModel.getRoleName() != 0) {
            userSearchRequestModelV1.setRoleName(userSearchRequestModel.getRoleName());
        }
        List<UserResponse> userResponses = userResponseMapper.searchUserInfo(userSearchRequestModelV1);
        if (!Objects.isNull(userResponses) && userResponses.size() != 0) {
            for (UserResponse userResponse : userResponses) {
                UserResponseModel userResponseModel = new UserResponseModel();
                userResponseModel.setUserId(userResponse.getUserId());
                userResponseModel.setStatusName(userResponse.getStatus() == 1 ? "开启" : "禁用");
                userResponseModel.setSex(userResponse.getSex());
                userResponseModel.setRole(RoleNameEnum.getNameByCode(userResponse.getRole()));
                userResponseModel.setRealName(userResponse.getRealName());
                userResponseModel.setPhone(userResponse.getPhone());
                userResponseModel.setMarketLevel(MarketLevelStatusEnum.getNameByCode(userResponse.getMarketLevel().trim()));
                userResponseModel.setManageLevel(userResponse.getManageLevel());
                userResponseModel.setEntryTime(userResponse.getEntryTime());
                userResponseModel.setCity(userResponse.getCity() == null ? "空值" : userResponse.getCity());
                userResponseModel.setArea(userResponse.getArea() == null ? "空值" : userResponse.getArea());

                UserPerformanceExample userPerformanceExample = new UserPerformanceExample();
                userPerformanceExample.createCriteria().andUserIdEqualTo(userResponse.getUserId());
                double totalPerformance = 0.00;
                List<UserPerformance> userPerformances = userPerformanceMapper.selectByExample(userPerformanceExample);
                if (!Objects.isNull(userPerformances) && userPerformances.size() != 0) {
                    for (UserPerformance userPerformance : userPerformances) {
                        totalPerformance = new BigDecimal(Double.toString(totalPerformance)).add(new BigDecimal(userPerformance.getPerformance().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    }
                }
                userResponseModel.setTotalPerformance(totalPerformance);
                userResponseModelList.add(userResponseModel);
            }
        }
        return userResponseModelList;
    }

    public String addUserInfo(UserAddRequestModel userAddRequestModel) {
//        UserAddRequestModel userAddRequestModelV1 = new UserAddRequestModel();
//        if (userAddRequestModel.getArea() != null && userAddRequestModel.getArea().length() != 0){
//            userAddRequestModelV1.setArea(userAddRequestModel.getArea());
//        }
//        if (userAddRequestModel.getCardNo() != null && userAddRequestModel.getCardNo().length() !=0){
//            userAddRequestModelV1.setCardNo(userAddRequestModel.getCardNo());
//        }
//        if (userAddRequestModel.getCity() != null && userAddRequestModel.getCity().length() != 0){
//            userAddRequestModelV1.setCity(userAddRequestModel.getCity());
//        }
//        if (userAddRequestModel.getManageLevel() != null && userAddRequestModel.getManageLevel().length() != 0){
//            userAddRequestModelV1.setManageLevel(userAddRequestModel.getManageLevel());
//        }
//        if (userAddRequestModel.getMarketLevel() != null && userAddRequestModel.getMarketLevel().length() != 0){
//            userAddRequestModelV1.setMarketLevel(userAddRequestModel.getMarketLevel());
//        }
//        if (userAddRequestModel.getRoleName() != null && userAddRequestModel.getRoleName() != 0){
//            userAddRequestModelV1.setRoleName(userAddRequestModel.getRoleName());
//        }
//        if (userAddRequestModel.getSex() != null && userAddRequestModel.getSex() != 0){
//            userAddRequestModelV1.setSex(userAddRequestModel.getSex());
//        }
//        if (userAddRequestModel.getUserPhone() != null && userAddRequestModel.getUserPhone().length() != 0){
//            userAddRequestModelV1.setUserPhone(userAddRequestModel.getUserPhone());
//        }
//        if (userAddRequestModel.getUserRealName() != null && userAddRequestModel.getUserRealName().length() != 0){
//            userAddRequestModelV1.setUserRealName(userAddRequestModel.getUserRealName());
//        }
//        if (userAddRequestModel.getPassword() != null && userAddRequestModel.getPassword().length() != 0){
//            userAddRequestModelV1.setPassword(userAddRequestModel.getPassword());
//        }
//        if (userAddRequestModel.getAwater() != null && userAddRequestModel.getAwater().length() != 0){
//            userAddRequestModelV1.setAwater(userAddRequestModel.getAwater());
//        }
//        if (userAddRequestModel.getCardPositive() != null && userAddRequestModel.getCardPositive().length() != 0){
//            userAddRequestModelV1.setCardPositive(userAddRequestModel.getCardPositive());
//        }
//        if (userAddRequestModel.getCardOppositive() != null && userAddRequestModel.getCardOppositive().length() != 0){
//            userAddRequestModelV1.setCardOppositive(userAddRequestModel.getCardOppositive());
//        }
        UserInfo userInfo = new UserInfo();
        userInfo.setRealName(userAddRequestModel.getUserRealName());
        userInfo.setPhone(userAddRequestModel.getUserPhone());
        userInfo.setArea(userAddRequestModel.getArea());
        userInfo.setAwaterImgUrl((userAddRequestModel.getAwater() == null || userAddRequestModel.getAwater().length() == 0) ? "" : userAddRequestModel.getAwater());
        userInfo.setCardOppositiveImgUrl((userAddRequestModel.getCardOppositive() == null || userAddRequestModel.getCardOppositive().length() == 0) ? "" : userAddRequestModel.getCardOppositive());
        userInfo.setCardPositiveImgUrl((userAddRequestModel.getCardPositive() == null || userAddRequestModel.getCardPositive().length() == 0) ? "" : userAddRequestModel.getCardPositive());
        userInfo.setCardNo(userAddRequestModel.getCardNo());
        userInfo.setCity(userAddRequestModel.getCity());
        userInfo.setCreateTime(new Date());
        userInfo.setImageUrl("http://106.15.37.191/images/awater/default.jpg");
        userInfo.setLevel(MarketLevelStatusEnum.getCodeByName(userAddRequestModel.getMarketLevel().trim()));
        userInfo.setLoginCount(0);
        userInfo.setManageId(userAddRequestModel.getManageId());
        userInfo.setManageLevel(userAddRequestModel.getManageLevel());
        userInfo.setPassword(userAddRequestModel.getPassword());
        userInfo.setRoleId(userAddRequestModel.getRoleName());
        userInfo.setSex(userAddRequestModel.getSex());
        userInfo.setStatus(userAddRequestModel.getStatus());
        userInfo.setJobStatus(userAddRequestModel.getJobStatus());
        int i = userInfoMapper.insert(userInfo);
        if (1 == i) {
            return "success";
        }

        return "fail";
    }

    public List<RoleInfo> getRoleInfo() {
        RoleInfoExample roleInfoExample = new RoleInfoExample();
        List<RoleInfo> roleInfos = roleInfoMapper.selectByExample(roleInfoExample);
        if (!Objects.isNull(roleInfos) && roleInfos.size() != 0) {
            return roleInfos;
        }
        return null;
    }

    public MessageInfo<String> fileUpload(FileUploadRequestModel fileUploadRequestModel) {
        MessageInfo<String> messageInfo = fileUploadService.uploadFile(fileUploadRequestModel.getUserPhone(), fileUploadRequestModel.getBase64());
        if (!Objects.isNull(messageInfo)) {
            return messageInfo;
        }
        return null;
    }

    public List<UserAddBranchResponseModel> fetchBranchManageInfo() {
        List<UserAddBranchResponseModel> userAddBranchResponseModelList = new ArrayList<>();
        List<UserInfo> userInfos = userInfoMapper.fetchUserInfoByStatus();
        if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
            userInfos.forEach(userInfo -> {
                UserAddBranchResponseModel userAddBranchResponseModel = new UserAddBranchResponseModel();
                userAddBranchResponseModel.setUserId(userInfo.getId());
                userAddBranchResponseModel.setUserRealName(userInfo.getRealName());
                userAddBranchResponseModel.setRoleName(RoleNameEnum.getNameByCode(userInfo.getRoleId()));
                userAddBranchResponseModelList.add(userAddBranchResponseModel);
            });
        }
        return userAddBranchResponseModelList;
    }

    public Boolean deleteMarketUser(UserModel userModel) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userModel.getUserId());
        userInfo.setStatus(userModel.getStatus());
        int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (1 == i) {
            if (1 == userModel.getStatus()) {
                log.info("开启成功");
                return true;
            }
            if (0 == userModel.getStatus()) {
                log.info("禁用成功");
                return true;
            }
        }
        return false;
    }

    public UserDetailResponseModel getUserDetailInfo(Integer userId) {
        assert (userId != null) : "userId 不能为空!";

        UserDetailResponseModel userDetailResponseModel = new UserDetailResponseModel();
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        UserAccountInfo userAccountInfo = new UserAccountInfo();
        UserPersonalInfo userPersonalInfo = new UserPersonalInfo();

        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andIdEqualTo(userId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
            UserInfo userInfo = userInfos.get(0);
            if (!StringUtils.isEmpty(userInfo.getArea()) && userInfo.getArea().length() != 0) {
                userBasicInfo.setArea(userInfo.getArea());
            }
            if (!StringUtils.isEmpty(userInfo.getAwaterImgUrl()) && userInfo.getAwaterImgUrl().length() != 0) {
                userBasicInfo.setAwaterImageUrl(userInfo.getImageUrl());
            }
            if (!StringUtils.isEmpty(userInfo.getCity()) && userInfo.getCity().length() != 0) {
                userBasicInfo.setCity(userInfo.getCity());
            }
            if (!Objects.isNull(userInfo.getJobStatus())) {
                userBasicInfo.setJobStatus(userInfo.getJobStatus());
            }
            if (!StringUtils.isEmpty(userInfo.getManageLevel()) && userInfo.getManageLevel().length() != 0) {
                userBasicInfo.setManageLevel(userInfo.getManageLevel());
            }
            if (!StringUtils.isEmpty(userInfo.getLevel()) && userInfo.getLevel().length() != 0) {
                userBasicInfo.setMarketLevel(MarketLevelStatusEnum.getNameByCode(userInfo.getLevel()));
            }
            if (!StringUtils.isEmpty(userInfo.getPassword()) && userInfo.getPassword().length() != 0) {
                userBasicInfo.setPassword(userInfo.getPassword());
            }
            if (!StringUtils.isEmpty(userInfo.getRealName()) && userInfo.getRealName().length() != 0) {
                userBasicInfo.setRealName(userInfo.getRealName());
            }
            if (!Objects.isNull(userInfo.getRoleId())) {
                userBasicInfo.setRoleName(RoleNameEnum.getNameByCode(userInfo.getRoleId()));
            }
            if (!Objects.isNull(userInfo.getSex())) {
                userBasicInfo.setSex(userInfo.getSex());
            }
            if (!Objects.isNull(userInfo.getStatus())) {
                userBasicInfo.setStatus(userInfo.getStatus());
            }
            if (!Objects.isNull(userInfo.getManageId())) {
                userBasicInfo.setSuperior(this.getRealNameByUserId(userInfo.getManageId()));
            }
            userBasicInfo.setTotalPerformance(this.getTotalPerformance(userId));
            if (!StringUtils.isEmpty(userInfo.getPhone()) && userInfo.getPhone().length() != 0) {
                userBasicInfo.setUserPhone(userInfo.getPhone());
            }
            if (!Objects.isNull(userInfo.getCreateTime())) {
                userBasicInfo.setEntryTime(userInfo.getCreateTime());
            }
            if (!StringUtils.isEmpty(userInfo.getCardNo()) && userInfo.getCardNo().length() != 0) {
                userPersonalInfo.setCardNo(userInfo.getCardNo());
            }
            if (!StringUtils.isEmpty(userInfo.getCardPositiveImgUrl()) && userInfo.getCardPositiveImgUrl().length() != 0) {
                userPersonalInfo.setCardPositiveImageUrl(userInfo.getCardPositiveImgUrl());
            }
            if (!StringUtils.isEmpty(userInfo.getCardOppositiveImgUrl()) && userInfo.getCardOppositiveImgUrl().length() != 0) {
                userPersonalInfo.setCardOppositiveImageUrl(userInfo.getCardOppositiveImgUrl());
            }
        }

        UserAccountExample userAccountExample = new UserAccountExample();
        userAccountExample.createCriteria().andUserIdEqualTo(userId);
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(userAccountExample);
        if (!Objects.isNull(userAccounts) && userAccounts.size() != 0) {
            UserAccount userAccount = userAccounts.get(0);
            if (!Objects.isNull(userAccount.getBalance())) {
                userAccountInfo.setBalance(userAccount.getBalance());
            }
        }

        UserGoldBeansExample userGoldBeansExample = new UserGoldBeansExample();
        userGoldBeansExample.createCriteria().andUserIdEqualTo(userId);
        List<UserGoldBeans> userGoldBeans = userGoldBeansMapper.selectByExample(userGoldBeansExample);
        if (!Objects.isNull(userGoldBeans) && userGoldBeans.size() != 0) {
            UserGoldBeans userGoldBeansV1 = userGoldBeans.get(0);
            if (!Objects.isNull(userGoldBeansV1.getGoldBeansNum())) {
                userAccountInfo.setGoldBeansNum(userGoldBeansV1.getGoldBeansNum());
            }
        }

        AccountBankExample accountBankExample = new AccountBankExample();
        accountBankExample.createCriteria().andUserIdEqualTo(userId);
        List<AccountBank> accountBanks = accountBankMapper.selectByExample(accountBankExample);
        if (!Objects.isNull(accountBanks) && accountBanks.size() != 0) {
            AccountBank accountBank = accountBanks.get(0);
            if (!StringUtils.isEmpty(accountBank.getAccountBankName()) && accountBank.getAccountBankName().length() != 0) {
                userAccountInfo.setAccountBank(accountBank.getAccountBankName());
            }
            if (!StringUtils.isEmpty(accountBank.getAccountHolder()) && accountBank.getAccountHolder().length() != 0) {
                userAccountInfo.setAccountHolder(accountBank.getAccountHolder());
            }
            if (!StringUtils.isEmpty(accountBank.getBankNo()) && accountBank.getBankNo().length() != 0) {
                userAccountInfo.setBankNo(accountBank.getBankNo());
            }
        }

        userDetailResponseModel.setUserBasicInfo(userBasicInfo);
        userDetailResponseModel.setUserAccountInfo(userAccountInfo);
        userDetailResponseModel.setUserPersonalInfo(userPersonalInfo);

        return userDetailResponseModel;
    }

    public List<UserActionResponseModel> viewUserActionInfo(Integer userId) {
        assert (userId != null) : "userId 不能为空!";

        List<UserActionResponseModel> userActionResponseModelList = new ArrayList<>();
        UserActionExample userActionExample = new UserActionExample();
        userActionExample.createCriteria().andUserIdEqualTo(userId);
        List<UserAction> userActions = userActionMapper.selectByExample(userActionExample);
        if (!Objects.isNull(userActions) && userActions.size() != 0) {
            userActions.forEach(userAction -> {
                UserActionResponseModel userActionResponseModel = new UserActionResponseModel();
                UserInfo userInfoV1 = this.getUserInfoV1(userId);
                if (!Objects.isNull(userInfoV1) && !StringUtils.isEmpty(userInfoV1.getRealName()) && userInfoV1.getRealName().length() != 0) {
                    userActionResponseModel.setUserRealName(userInfoV1.getRealName());
                }
                CustomerInfo customerInfoV1 = this.getCustomerInfoV1(userAction.getCustId());
                if (!Objects.isNull(customerInfoV1)) {
                    if (!StringUtils.isEmpty(customerInfoV1.getCustName()) && customerInfoV1.getCustName().length() != 0) {
                        userActionResponseModel.setCustName(customerInfoV1.getCustName());
                    }
                    if (!StringUtils.isEmpty(customerInfoV1.getCompanyName()) && customerInfoV1.getCompanyName().length() != 0) {
                        userActionResponseModel.setCompanyName(customerInfoV1.getCompanyName());
                    }
                    if (!StringUtils.isEmpty(customerInfoV1.getCompanyType()) && customerInfoV1.getCompanyType().length() != 0) {
                        userActionResponseModel.setCompanyType(customerInfoV1.getCompanyType());
                    }
                    if (!StringUtils.isEmpty(customerInfoV1.getCustPhone()) && customerInfoV1.getCustPhone().length() != 0) {
                        userActionResponseModel.setCustPhone(customerInfoV1.getCustPhone());
                    }
                }
                if (!Objects.isNull(userAction.getCreateTime())) {
                    userActionResponseModel.setCreateTime(userAction.getCreateTime());
                }
                if (!StringUtils.isEmpty(userAction.getAction()) && userAction.getAction().length() != 0) {
                    userActionResponseModel.setAction(userAction.getAction());
                }
                userActionResponseModel.setId(userAction.getId());
                userActionResponseModelList.add(userActionResponseModel);
            });
        }
        return userActionResponseModelList;
    }

    public PageInfo<List<UserActionResponseModel>> searchUserActionInfo(UserActionRequestModel userActionRequestModel) {
        UserActionRequestModel userActionRequestModelV1 = new UserActionRequestModel();
        userActionRequestModelV1.setUserId(userActionRequestModel.getUserId());
        if (userActionRequestModel.getCustName() != null && userActionRequestModel.getCustName().length() != 0) {
            userActionRequestModelV1.setCustName(userActionRequestModel.getCustName());
        }
        List<String> actions = new ArrayList<>();
        if (!StringUtils.isEmpty(userActionRequestModel.getIsCompact()) && !"0".equals(userActionRequestModel.getIsCompact())) {
            actions.add(userActionRequestModel.getIsCompact().trim());
        }
        if (!StringUtils.isEmpty(userActionRequestModel.getIsCompactCheck()) && !"0".equals(userActionRequestModel.getIsCompactCheck())) {
            actions.add(userActionRequestModel.getIsCompactCheck().trim());
        }
        if (!StringUtils.isEmpty(userActionRequestModel.getIsGoldBeans()) && !"0".equals(userActionRequestModel.getIsGoldBeans())) {
            actions.add(userActionRequestModel.getIsGoldBeans().trim());
        }
        if (!StringUtils.isEmpty(userActionRequestModel.getIsInterestCust()) && !"0".equals(userActionRequestModel.getIsInterestCust())) {
            actions.add(userActionRequestModel.getIsInterestCust().trim());
        }
        if (!StringUtils.isEmpty(userActionRequestModel.getIsMoney()) && !"0".equals(userActionRequestModel.getIsMoney())) {
            actions.add(userActionRequestModel.getIsMoney().trim());
        }
        if (!StringUtils.isEmpty(userActionRequestModel.getIsPhone()) && !"0".equals(userActionRequestModel.getIsPhone())) {
            actions.add(userActionRequestModel.getIsPhone().trim());
        }
        if (!StringUtils.isEmpty(userActionRequestModel.getIsVisit()) && !"0".equals(userActionRequestModel.getIsVisit())) {
            actions.add(userActionRequestModel.getIsVisit().trim());
        }
        if (!Objects.isNull(userActionRequestModel.getStartTime()) && userActionRequestModel.getStartTime().length() != 0) {
            userActionRequestModelV1.setStartTime(userActionRequestModel.getStartTime().trim());
        }
        if (!Objects.isNull(userActionRequestModel.getEndTime()) && userActionRequestModel.getEndTime().length() != 0) {
            userActionRequestModelV1.setEndTime(userActionRequestModel.getEndTime().trim());
        }
        PageHelper.startPage(userActionRequestModel.getPageNum() == null ? 1 : userActionRequestModel.getPageSize(), userActionRequestModel.getPageSize() == null ? 10 : userActionRequestModel.getPageSize());
        List<UserActionResponse> userActionResponseList = userActionResponseMapper.searchUserActionInfo(userActionRequestModelV1.getUserId(), userActionRequestModelV1.getCustName(), userActionRequestModelV1.getStartTime(), userActionRequestModelV1.getEndTime(), actions);
        PageInfo userActionResponsePageInfo = new PageInfo<>(userActionResponseList);
        List<UserActionResponseModel> userActionResponseModelList = new ArrayList<>();
        if (!Objects.isNull(userActionResponseList) && userActionResponseList.size() != 0) {
            for (UserActionResponse u : userActionResponseList) {
                UserActionResponseModel userActionResponseModel = new UserActionResponseModel();
                BeanUtils.copyProperties(u, userActionResponseModel);
                userActionResponseModelList.add(userActionResponseModel);
            }
            userActionResponsePageInfo.setList(userActionResponseModelList);
            return userActionResponsePageInfo;
        }
        return null;
    }

    public PageInfo<List<UserPerformanceResponseModel>> searchUserPerformanceInfo(DateRequestModel dateRequestModel) {
        List<UserPerformanceResponseModel> userPerformanceResponseModelList = new ArrayList<>();
        DateRequestModel dateRequestModelV1 = new DateRequestModel();
        if (!StringUtils.isEmpty(dateRequestModel.getStartTime()) && dateRequestModel.getStartTime().length() != 0) {
            dateRequestModelV1.setStartTime(dateRequestModel.getStartTime());
        }
        if (!StringUtils.isEmpty(dateRequestModel.getEndTime()) && dateRequestModel.getEndTime().length() != 0) {
            dateRequestModelV1.setEndTime(dateRequestModel.getEndTime());
        }
        dateRequestModelV1.setUserId(dateRequestModel.getUserId());
        PageHelper.startPage(dateRequestModel.getPageNum(), dateRequestModel.getPageSize());
        List<UserPerformanceResponse> userPerformanceResponses = userPerformanceResponseMapper.searchUserActionInfo(dateRequestModelV1);
        PageInfo userPerformanceResponsePageInfo = new PageInfo<>(userPerformanceResponses);
        if (!Objects.isNull(userPerformanceResponses) && userPerformanceResponses.size() != 0) {
            for (UserPerformanceResponse u : userPerformanceResponses) {
                UserPerformanceResponseModel userPerformanceResponseModel = new UserPerformanceResponseModel();
                BeanUtils.copyProperties(u, userPerformanceResponseModel);
                String s = this.validPayResult(u.getCustId());
                if ("true".equals(s)) {
                    userPerformanceResponseModel.setStatusName("已付款");
                    userPerformanceResponseModelList.add(userPerformanceResponseModel);
                }
//                if ("false".equals(s)){
//                    userPerformanceResponseModel.setStatusName("待支付");
//                }
//                if ("no_record".equals(s)){
//                    userPerformanceResponseModel.setStatusName("暂无支付记录");
//                }
//                userPerformanceResponseModelList.add(userPerformanceResponseModel);
            }
        }
        userPerformanceResponsePageInfo.setList(userPerformanceResponseModelList);
        return userPerformanceResponsePageInfo;
    }

    public PageInfo<List<UserGoldDetailResponseModel>> getUserGoldDetailInfo(UserModel userModel) {
        List<UserGoldDetailResponseModel> userGoldDetailResponseModelList = new ArrayList<>();
        GoldBeansApplyExample goldBeansApplyExample = new GoldBeansApplyExample();
        goldBeansApplyExample.createCriteria().andUserIdEqualTo(userModel.getUserId()).andStatusEqualTo(2);
        PageHelper.startPage(userModel.getPageNum() == null ? 1 : userModel.getPageNum(), userModel.getPageSize() == null ? 10 : userModel.getPageSize());
        List<GoldBeansApply> goldBeansApplies = goldBeansApplyMapper.selectByExample(goldBeansApplyExample);
        PageInfo goldBeansApplyPageInfo = new PageInfo<>(goldBeansApplies);
        if (!Objects.isNull(goldBeansApplies) && goldBeansApplies.size() != 0) {
            for (GoldBeansApply goldBeansApply : goldBeansApplies) {
                UserGoldDetailResponseModel userGoldDetailResponseModel = new UserGoldDetailResponseModel();
                userGoldDetailResponseModel.setId(goldBeansApply.getId());
                userGoldDetailResponseModel.setGoldNum(goldBeansApply.getGoldBeansApplyNum());
                userGoldDetailResponseModel.setOperateTime(goldBeansApply.getCheckTime());
                userGoldDetailResponseModel.setPhone(this.getUserInfoV1(userModel.getUserId()).getPhone());
                userGoldDetailResponseModel.setRealName(this.getUserInfoV1(userModel.getUserId()).getRealName());
                userGoldDetailResponseModel.setAction(goldBeansApply.getType() == 1 ? "申请金豆" : "赠送");
                userGoldDetailResponseModelList.add(userGoldDetailResponseModel);
            }
        }
        goldBeansApplyPageInfo.setList(userGoldDetailResponseModelList);
        return goldBeansApplyPageInfo;
    }

    public PageInfo<List<UserTeamResponseModel>> getUserTeamInfo(UserModel userModel) {
        List<UserTeamResponseModel> userTeamResponseModelList = new ArrayList<>();

        PageHelper.startPage(userModel.getPageNum() == null ? 1 : userModel.getPageNum(), userModel.getPageSize() == null ? 10 : userModel.getPageSize());
        List<UserInfo> userTeamInfo = userInfoMapper.getUserTeamInfo(userModel.getUserId());
        PageInfo userInfoPageInfo = new PageInfo<>(userTeamInfo);
        if (!Objects.isNull(userTeamInfo) && userTeamInfo.size() != 0) {
            userTeamInfo.forEach(userInfo -> {
                UserTeamResponseModel userTeamResponseModel = new UserTeamResponseModel();
                userTeamResponseModel.setId(userInfo.getId());
                userTeamResponseModel.setRoleName(RoleNameEnum.getNameByCode(userInfo.getRoleId()));
                userTeamResponseModel.setRealName(userInfo.getRealName());
                userTeamResponseModel.setCreateTime(userInfo.getCreateTime());
                userTeamResponseModel.setPhone(userInfo.getPhone());
                userTeamResponseModelList.add(userTeamResponseModel);
            });
        }
        userInfoPageInfo.setList(userTeamResponseModelList);
        return userInfoPageInfo;
    }

    public MessageInfo<PageInfo<List<UserGoldCheckResponseModel>>> getUserGoldBeansApplyInfo(UserModel userModel) {
        MessageInfo<PageInfo<List<UserGoldCheckResponseModel>>> dataMessage = new MessageInfo<>();
        List<UserGoldCheckResponseModel> userGoldCheckResponseModelList = new ArrayList<>();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userModel.getUserId());
        if (!Objects.isNull(userInfo)) {
            if (1 != userInfo.getRoleId()) {
                UserInfoExample userInfoExampleV1 = new UserInfoExample();
                userInfoExampleV1.createCriteria().andManageIdEqualTo(userInfo.getId());
                List<UserInfo> userInfos1 = userInfoMapper.selectByExample(userInfoExampleV1);
                if (!Objects.isNull(userInfos1) && userInfos1.size() != 0) {
                    for (UserInfo u : userInfos1) {
                        GoldBeansApplyExample goldBeansApplyExample = new GoldBeansApplyExample();
                        goldBeansApplyExample.createCriteria().andUserIdEqualTo(u.getId()).andTypeEqualTo(1);
                        PageHelper.startPage(userModel.getPageNum(), userModel.getPageSize());
                        List<GoldBeansApply> goldBeansApplies = goldBeansApplyMapper.selectByExample(goldBeansApplyExample);
                        PageInfo goldBeansApplyPageInfo = new PageInfo<>(goldBeansApplies);
                        if (!Objects.isNull(goldBeansApplies) && goldBeansApplies.size() != 0) {
                            goldBeansApplies.forEach(goldBeansApply -> {
                                UserGoldCheckResponseModel userGoldCheckResponseModel = new UserGoldCheckResponseModel();
                                userGoldCheckResponseModel.setId(goldBeansApply.getId());
                                userGoldCheckResponseModel.setGoldApplyNum(goldBeansApply.getGoldBeansApplyNum());
                                if (!Objects.isNull(goldBeansApply.getCheckTime())) {
                                    userGoldCheckResponseModel.setOperateTime(goldBeansApply.getCheckTime());
                                } else {
                                    userGoldCheckResponseModel.setOperateTime(goldBeansApply.getApplyTime());
                                }
                                userGoldCheckResponseModel.setPhone(this.getUserInfoV1(goldBeansApply.getUserId()).getPhone());
                                userGoldCheckResponseModel.setRealName(this.getUserInfoV1(goldBeansApply.getUserId()).getRealName());
                                if (1 == goldBeansApply.getStatus()) {
                                    userGoldCheckResponseModel.setStatusName("待审核");
                                }
                                if (2 == goldBeansApply.getStatus()) {
                                    userGoldCheckResponseModel.setStatusName("已成功");
                                }
                                if (3 == goldBeansApply.getStatus()) {
                                    userGoldCheckResponseModel.setStatusName("已拒绝");
                                    userGoldCheckResponseModel.setRefuseReason(goldBeansApply.getRefuseReason());
                                }
                                userGoldCheckResponseModelList.add(userGoldCheckResponseModel);
                            });
                        }
                        goldBeansApplyPageInfo.setList(userGoldCheckResponseModelList);
                        dataMessage.setData(goldBeansApplyPageInfo);
                        dataMessage.setResult("success");
                        return dataMessage;
                    }
                }
            } else {
                dataMessage.setResult("用户  " + userInfo.getRealName() + "  的等级为销售人员，暂无需要审核的信息");
                return dataMessage;
            }
        }
        return null;
    }

    public PageInfo<List<SumArrangeModel>> getUserSumArange(UserModel userModel) {
        List<SumArrangeModel> sumArrangeModelList = new ArrayList<>();

        SumArrangeExample sumArrangeExample = new SumArrangeExample();
        sumArrangeExample.createCriteria().andUserIdEqualTo(userModel.getUserId());
        PageHelper.startPage(userModel.getPageNum() == null ? 1 : userModel.getPageNum(), userModel.getPageSize() == null ? 10 : userModel.getPageSize());
        List<SumArrange> sumArranges = sumArrangeMapper.selectByExample(sumArrangeExample);
        PageInfo sumArrangePageInfo = new PageInfo<>(sumArranges);
        if (!Objects.isNull(sumArranges) && sumArranges.size() != 0) {
            sumArranges.forEach(sumArrange -> {
                SumArrangeModel sumArrangeModel = new SumArrangeModel();
                sumArrangeModel.setId(sumArrange.getId());
                sumArrangeModel.setCreateTime(sumArrange.getCreateTime());
                if (!StringUtils.isEmpty(sumArrange.getTodaySum())) {
                    sumArrangeModel.setTodaySum(sumArrange.getTodaySum());
                }
                if (!StringUtils.isEmpty(sumArrange.getTomorrowArrange())) {
                    sumArrangeModel.setTomorrowArrange(sumArrange.getTomorrowArrange());
                }
                sumArrangeModel.setUserRealName(this.getUserInfoV1(userModel.getUserId()).getRealName());
                sumArrangeModelList.add(sumArrangeModel);
            });
        }
        sumArrangePageInfo.setList(sumArrangeModelList);
        return sumArrangePageInfo;
    }

    public String editUserInfo(UserEditRequestModel userEditRequestModel) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userEditRequestModel.getUserId());
        if (!Objects.isNull(userEditRequestModel.getRoleName())) {
            userInfo.setRoleId(userEditRequestModel.getRoleName());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getUserRealName()) && userEditRequestModel.getUserRealName().length() != 0) {
            userInfo.setRealName(userEditRequestModel.getUserRealName());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getCardNo()) && userEditRequestModel.getCardNo().length() != 0) {
            userInfo.setCardNo(userEditRequestModel.getCardNo());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getUserPhone()) && userEditRequestModel.getUserPhone().length() != 0) {
            userInfo.setPhone(userEditRequestModel.getUserPhone());
        }
        if (!Objects.isNull(userEditRequestModel.getJobStatus())) {
            userInfo.setJobStatus(userEditRequestModel.getJobStatus());
        }
        if (!Objects.isNull(userEditRequestModel.getStatus())) {
            userInfo.setStatus(userEditRequestModel.getStatus());
        }
        if (!Objects.isNull(userEditRequestModel.getSex())) {
            userInfo.setSex(userEditRequestModel.getSex());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getPassword()) && userEditRequestModel.getPassword().length() != 0) {
            userInfo.setPassword(userEditRequestModel.getPassword());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getManageLevel()) && userEditRequestModel.getManageLevel().length() != 0) {
            userInfo.setManageLevel(userEditRequestModel.getManageLevel());
        }
        if (!Objects.isNull(userEditRequestModel.getManageId())) {
            userInfo.setManageId(userEditRequestModel.getManageId());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getMarketLevel()) && userEditRequestModel.getMarketLevel().length() != 0) {
            userInfo.setLevel(userEditRequestModel.getMarketLevel());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getCity()) && userEditRequestModel.getCity().length() != 0) {
            userInfo.setCity(userEditRequestModel.getCity());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getArea()) && userEditRequestModel.getArea().length() != 0) {
            userInfo.setArea(userEditRequestModel.getArea());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getAwater()) && userEditRequestModel.getAwater().length() != 0) {
            userInfo.setAwaterImgUrl(userEditRequestModel.getAwater());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getCardPositive()) && userEditRequestModel.getCardPositive().length() != 0) {
            userInfo.setCardPositiveImgUrl(userEditRequestModel.getCardPositive());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getCardOppositive()) && userEditRequestModel.getCardOppositive().length() != 0) {
            userInfo.setCardOppositiveImgUrl(userEditRequestModel.getCardOppositive());
        }
        int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (1 != i) {
            return "用户基本信息和身份信息更新失败!";
        }

        UserGoldBeans userGoldBeans = new UserGoldBeans();
        if (!Objects.isNull(userEditRequestModel.getGoldBeansNum())) {
            userGoldBeans.setGoldBeansNum(userEditRequestModel.getGoldBeansNum());
            userGoldBeans.setModifyTime(new Date());
            UserGoldBeansExample userGoldBeansExample = new UserGoldBeansExample();
            userGoldBeansExample.createCriteria().andUserIdEqualTo(userEditRequestModel.getUserId());
            int i1 = userGoldBeansMapper.updateByExampleSelective(userGoldBeans, userGoldBeansExample);
            if (1 != i1) {
                return "用户金豆更新失败!";
            }
        }
        AccountBank accountBank = new AccountBank();
        if (!StringUtils.isEmpty(userEditRequestModel.getAccountBankName()) && userEditRequestModel.getAccountBankName().length() != 0) {
            accountBank.setAccountBankName(userEditRequestModel.getAccountBankName());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getAccountHolder()) && userEditRequestModel.getAccountHolder().length() != 0) {
            accountBank.setAccountHolder(userEditRequestModel.getAccountHolder());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getAccountBankCardNo()) && userEditRequestModel.getAccountBankCardNo().length() != 0) {
            accountBank.setBankNo(userEditRequestModel.getAccountBankCardNo());
        }
        if (!StringUtils.isEmpty(userEditRequestModel.getAccountBankName()) && !StringUtils.isEmpty(userEditRequestModel.getAccountHolder()) && !StringUtils.isEmpty(userEditRequestModel.getAccountBankCardNo())) {
            accountBank.setModifyTime(new Date());
            AccountBankExample accountBankExample = new AccountBankExample();
            accountBankExample.createCriteria().andUserIdEqualTo(userEditRequestModel.getUserId());
            int i2 = accountBankMapper.updateByExampleSelective(accountBank, accountBankExample);
            if (1 != i2) {
                return "用户银行信息更新失败!";
            }
        }
        return "更新成功!";
    }

    public PageInfo<List<CompactCheckResponseModel>> searchUserToCustCompactCheckInfo(CompactCheckRequestModel compactCheckRequestModel) {
        List<CompactCheckResponseModel> compactCheckResponseModelList = new ArrayList<>();

        CompactCheckRequestModel compactCheckRequestModelV1 = new CompactCheckRequestModel();
        if (!StringUtils.isEmpty(compactCheckRequestModel.getCustName()) && compactCheckRequestModel.getCustName().length() != 0) {
            compactCheckRequestModelV1.setCustName(compactCheckRequestModel.getCustName());
        }
        if (!StringUtils.isEmpty(compactCheckRequestModel.getCustPhone()) && compactCheckRequestModel.getCustPhone().length() != 0) {
            compactCheckRequestModelV1.setCustPhone(compactCheckRequestModel.getCustPhone());
        }
        if (!StringUtils.isEmpty(compactCheckRequestModel.getUserPhone()) && compactCheckRequestModel.getUserPhone().length() != 0) {
            compactCheckRequestModelV1.setUserPhone(compactCheckRequestModel.getUserPhone());
        }
        if (!StringUtils.isEmpty(compactCheckRequestModel.getUserRealName()) && compactCheckRequestModel.getUserRealName().length() != 0) {
            compactCheckRequestModelV1.setUserRealName(compactCheckRequestModel.getUserRealName());
        }
        if (!Objects.isNull(compactCheckRequestModel.getStatus()) && compactCheckRequestModel.getStatus() != 99) {
            compactCheckRequestModelV1.setStatus(compactCheckRequestModel.getStatus());
        }
        PageHelper.startPage(compactCheckRequestModel.getPageNum() == null ? 1 : compactCheckRequestModel.getPageNum(), compactCheckRequestModel.getPageSize() == null ? 10 : compactCheckRequestModel.getPageSize());
        List<CompactCheckResponse> compactCheckResponses = compactCheckResponseMapper.searchCompactCheckInfo(compactCheckRequestModelV1);
        PageInfo compactCheckResponsePageInfo = new PageInfo<>(compactCheckResponses);
        if (!Objects.isNull(compactCheckResponses) && compactCheckResponses.size() != 0) {
            compactCheckResponses.forEach(compactCheckResponse -> {
                CompactCheckResponseModel compactCheckResponseModel = new CompactCheckResponseModel();
                BeanUtils.copyProperties(compactCheckResponse, compactCheckResponseModel);
                compactCheckResponseModelList.add(compactCheckResponseModel);
            });
        }
        compactCheckResponsePageInfo.setList(compactCheckResponseModelList);
        return compactCheckResponsePageInfo;
    }

    public PageInfo<List<ReceiptApplyResponseModel>> getUserReceiptApplyInfo(ReceiptApplyRequestModel receiptApplyRequestModel) {
        List<ReceiptApplyResponseModel> receiptApplyResponseModelList = new ArrayList<>();

        ReceiptApplyRequestModel receiptApplyRequestModelV1 = new ReceiptApplyRequestModel();
        if (!StringUtils.isEmpty(receiptApplyRequestModel.getApplyUserName()) && receiptApplyRequestModel.getApplyUserName().length() != 0) {
            receiptApplyRequestModelV1.setApplyUserName(receiptApplyRequestModel.getApplyUserName());
        }
        if (!StringUtils.isEmpty(receiptApplyRequestModel.getApplyUserPhone()) && receiptApplyRequestModel.getApplyUserPhone().length() != 0) {
            receiptApplyRequestModelV1.setApplyUserPhone(receiptApplyRequestModel.getApplyUserPhone());
        }
        if (!StringUtils.isEmpty(receiptApplyRequestModel.getStartTime()) && receiptApplyRequestModel.getStartTime().length() != 0) {
            receiptApplyRequestModelV1.setStartTime(receiptApplyRequestModel.getStartTime());
        }
        if (!StringUtils.isEmpty(receiptApplyRequestModel.getEndTime()) && receiptApplyRequestModel.getEndTime().length() != 0) {
            receiptApplyRequestModelV1.setEndTime(receiptApplyRequestModel.getEndTime());
        }
        if (!Objects.isNull(receiptApplyRequestModel.getStatus()) && receiptApplyRequestModel.getStatus() != 99) {
            receiptApplyRequestModelV1.setStatus(receiptApplyRequestModel.getStatus());
        }
        PageHelper.startPage(receiptApplyRequestModel.getPageNum() == null ? 1 : receiptApplyRequestModel.getPageNum(), receiptApplyRequestModel.getPageSize() == null ? 10 : receiptApplyRequestModel.getPageSize());
        List<ReceiptApplyResponse> receiptApplyResponses = receiptApplyResponseMapper.searchReceiptInfo(receiptApplyRequestModelV1);
        PageInfo receiptApplyResponsePageInfo = new PageInfo<>(receiptApplyResponses);
        if (!Objects.isNull(receiptApplyResponses) && receiptApplyResponses.size() != 0) {
            receiptApplyResponses.forEach(receiptApplyResponse -> {
                ReceiptApplyResponseModel receiptApplyResponseModel = new ReceiptApplyResponseModel();
                BeanUtils.copyProperties(receiptApplyResponse, receiptApplyResponseModel);
                receiptApplyResponseModelList.add(receiptApplyResponseModel);
            });
        }
        receiptApplyResponsePageInfo.setList(receiptApplyResponseModelList);
        return receiptApplyResponsePageInfo;
    }

    public CompactCheckEditInfoResponseModel editCustCompactInfo(Integer custId) {
        CompactCheckEditInfoResponseModel compactCheckEditInfoResponseModel = new CompactCheckEditInfoResponseModel();

        CustomerInfoExample customerInfoExample = new CustomerInfoExample();
        customerInfoExample.createCriteria().andIdEqualTo(custId);
        List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
        if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
            CustomerInfo customerInfo = customerInfos.get(0);
            if (!StringUtils.isEmpty(customerInfo.getCustName()) && customerInfo.getCustName().length() != 0) {
                compactCheckEditInfoResponseModel.setCustName(customerInfo.getCustName());
            }
            if (!StringUtils.isEmpty(customerInfo.getCustPhone()) && customerInfo.getCustPhone().length() != 0) {
                compactCheckEditInfoResponseModel.setCustPhone(customerInfo.getCustPhone());
            }
            if (!StringUtils.isEmpty(customerInfo.getCompactImg()) && customerInfo.getCompactImg().length() != 0) {
                compactCheckEditInfoResponseModel.setCompactImgUrl(customerInfo.getCompactImg());
            }
            if (!Objects.isNull(customerInfo.getPrice())) {
                compactCheckEditInfoResponseModel.setPrice(customerInfo.getPrice());
            }
            if (!Objects.isNull(customerInfo.getIsCompactCheck())) {
                compactCheckEditInfoResponseModel.setStatus(customerInfo.getIsCompactCheck());
            }
            if (!StringUtils.isEmpty(customerInfo.getCheckRefuseReason()) && customerInfo.getCheckRefuseReason().length() != 0) {
                compactCheckEditInfoResponseModel.setRefuseReason(customerInfo.getCheckRefuseReason());
            }
            if (!StringUtils.isEmpty(customerInfo.getCompactNo()) && customerInfo.getCompactNo().length() != 0) {
                compactCheckEditInfoResponseModel.setCompactNo(customerInfo.getCompactNo());
            }
        }
        return compactCheckEditInfoResponseModel;
    }

    public String editCustCompactInfo(CompactCheckEditInfoRequestModel compactCheckEditInfoRequestModel) {
        UserPerformance userPerformance = new UserPerformance();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(compactCheckEditInfoRequestModel.getCustId());
        if (1 == compactCheckEditInfoRequestModel.getStatus()) {
            customerInfo.setIsCompactCheck(1);
            customerInfo.setStatus(2);
            customerInfo.setCheckTime(new Date());
            customerInfo.setModifyTime(new Date());
            customerInfo.setLastModifyTime(new Date());
            int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
            if (1 != i) {
                log.info("客户信息更新异常!");
                return "系统信息异常!";
            }

            CustomerInfoExample customerInfoExample = new CustomerInfoExample();
            customerInfoExample.createCriteria().andIdEqualTo(compactCheckEditInfoRequestModel.getCustId());
            List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
            if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
                CustomerInfo customerInfoV1 = customerInfos.get(0);
                userPerformance.setCustId(compactCheckEditInfoRequestModel.getCustId());
                userPerformance.setCreateTime(new Date());
                userPerformance.setPerformance(customerInfoV1.getPrice());
                userPerformance.setUserId(customerInfoV1.getUserId());
                int insert = userPerformanceMapper.insert(userPerformance);
                if (1 != insert) {
                    log.info("业绩插入失败!");
                    return "系统信息异常!";
                }
            }
        } else if (0 == compactCheckEditInfoRequestModel.getStatus()) {
            customerInfo.setIsCompactCheck(0);
            customerInfo.setCheckTime(new Date());
            customerInfo.setModifyTime(new Date());
            customerInfo.setLastModifyTime(new Date());
            customerInfo.setCheckRefuseReason(compactCheckEditInfoRequestModel.getRefuseReason());
            int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
            if (1 != i) {
                log.info("客户信息更新异常!");
                return "系统信息异常!";
            }
        }
        log.info("更新成功!");
        return "更新成功!";
    }

    public ReceiptCheckEditInfoResponseModel getEditUserReceiptApplyInfo(IdModel idModel) {
        ReceiptCheckEditInfoResponseModel receiptCheckEditInfoResponseModel = new ReceiptCheckEditInfoResponseModel();

        UserReceiptApplyExample userReceiptApplyExample = new UserReceiptApplyExample();
        userReceiptApplyExample.createCriteria().andIdEqualTo(idModel.getId());
        List<UserReceiptApply> userReceiptApplies = userReceiptApplyMapper.selectByExample(userReceiptApplyExample);
        if (!Objects.isNull(userReceiptApplies) && userReceiptApplies.size() != 0) {
            UserReceiptApply userReceiptApply = userReceiptApplies.get(0);
            if (!StringUtils.isEmpty(userReceiptApply.getApplyUserName()) && userReceiptApply.getApplyUserName().length() != 0) {
                receiptCheckEditInfoResponseModel.setApplyName(userReceiptApply.getApplyUserName());
            }
            if (!StringUtils.isEmpty(userReceiptApply.getApplyUserPhone()) && userReceiptApply.getApplyUserPhone().length() != 0) {
                receiptCheckEditInfoResponseModel.setPhone(userReceiptApply.getApplyUserPhone());
            }
            if (!StringUtils.isEmpty(userReceiptApply.getCertificateNo()) && userReceiptApply.getCertificateNo().length() != 0) {
                receiptCheckEditInfoResponseModel.setCertificateNo(userReceiptApply.getCertificateNo());
            }
            if (!StringUtils.isEmpty(userReceiptApply.getCompanyName()) && userReceiptApply.getCompanyName().length() != 0) {
                receiptCheckEditInfoResponseModel.setCompanyName(userReceiptApply.getCompanyName());
            }
            if (!StringUtils.isEmpty(userReceiptApply.getDutyParagraph()) && userReceiptApply.getDutyParagraph().length() != 0) {
                receiptCheckEditInfoResponseModel.setDutyParagraph(userReceiptApply.getDutyParagraph());
            }
            if (!StringUtils.isEmpty(userReceiptApply.getReceiptTitle()) && userReceiptApply.getReceiptTitle().length() != 0) {
                receiptCheckEditInfoResponseModel.setReceiptTitle(userReceiptApply.getReceiptTitle());
            }
            if (!StringUtils.isEmpty(userReceiptApply.getRefuseReason()) && userReceiptApply.getRefuseReason().length() != 0) {
                receiptCheckEditInfoResponseModel.setRefuseReason(userReceiptApply.getRefuseReason());
            }
            if (!Objects.isNull(userReceiptApply.getApplyTime())) {
                receiptCheckEditInfoResponseModel.setApplyTime(userReceiptApply.getApplyTime());
            }
            if (!Objects.isNull(userReceiptApply.getStatus())) {
                receiptCheckEditInfoResponseModel.setStatus(userReceiptApply.getStatus());
            }
            if (!Objects.isNull(userReceiptApply.getPrice())) {
                receiptCheckEditInfoResponseModel.setPrice(userReceiptApply.getPrice());
            }
            String userRealName = this.getUserInfoV1(userReceiptApply.getUserId()).getRealName();
            if (!StringUtils.isEmpty(userRealName) && userRealName.length() != 0) {
                receiptCheckEditInfoResponseModel.setUserRealName(userRealName);
            }
        }
        return receiptCheckEditInfoResponseModel;
    }

    public String editReceiptInfo(ReceiptCheckEditInfoRequestModel receiptCheckEditInfoRequestModel) {
        UserReceiptApply userReceiptApply = new UserReceiptApply();

        userReceiptApply.setId(receiptCheckEditInfoRequestModel.getId());
        if (2 == receiptCheckEditInfoRequestModel.getStatus()) {
            userReceiptApply.setStatus(2);
            userReceiptApply.setCertificateNo(receiptCheckEditInfoRequestModel.getCertificateNo());
            userReceiptApply.setModifyTime(new Date());
        } else if (3 == receiptCheckEditInfoRequestModel.getStatus()) {
            userReceiptApply.setStatus(3);
            userReceiptApply.setModifyTime(new Date());
            userReceiptApply.setRefuseReason(receiptCheckEditInfoRequestModel.getRefuseReason());
        }
        int i = userReceiptApplyMapper.updateByPrimaryKeySelective(userReceiptApply);
        if (1 != i) {
            log.info("发票审核数据更新失败！");
            return "发票审核数据更新失败!";
        }
        return "更新成功";
    }

    public List<MarketUserFinanceDetailModel> getMarketUserFinanceDeailInfo(IdModel idModel) {
        List<MarketUserFinanceDetailModel> dataList = new ArrayList<>();

        UserInfo userInfo = this.getUserInfoV1(idModel.getId());
        CashDetailExample cashDetailExample = new CashDetailExample();
        cashDetailExample.createCriteria().andUserIdEqualTo(idModel.getId());
        List<CashDetail> cashDetails = cashDetailMapper.selectByExample(cashDetailExample);
        if (!Objects.isNull(cashDetails) && cashDetails.size() != 0) {
            cashDetails.forEach(cashDetail -> {
                MarketUserFinanceDetailModel marketUserFinanceDetailModel = new MarketUserFinanceDetailModel();
                marketUserFinanceDetailModel.setUserPhone(userInfo.getPhone());
                marketUserFinanceDetailModel.setUserRealName(userInfo.getRealName());
                marketUserFinanceDetailModel.setAmount(cashDetail.getCash());
                marketUserFinanceDetailModel.setChangeReason("提现");
                if (!Objects.isNull(cashDetail.getModifyTime())) {
                    marketUserFinanceDetailModel.setChangeTime(cashDetail.getModifyTime());
                } else {
                    marketUserFinanceDetailModel.setChangeTime(cashDetail.getCreateTime());
                }
                marketUserFinanceDetailModel.setStatus(CashStatusEnum.getNameByCode(cashDetail.getCheckStatus()));
                dataList.add(marketUserFinanceDetailModel);
            });
        }

        UserCommissionCountExample userCommissionCountExample = new UserCommissionCountExample();
        userCommissionCountExample.createCriteria().andUserIdEqualTo(idModel.getId());
        List<UserCommissionCount> userCommissionCounts = userCommissionCountMapper.selectByExample(userCommissionCountExample);
        if (!Objects.isNull(userCommissionCounts) && userCommissionCounts.size() != 0) {
            userCommissionCounts.forEach(userCommissionCount -> {
                MarketUserFinanceDetailModel marketUserFinanceDetailModel = new MarketUserFinanceDetailModel();
                marketUserFinanceDetailModel.setUserRealName(userInfo.getRealName());
                marketUserFinanceDetailModel.setUserPhone(userInfo.getPhone());
                if (!Objects.isNull(userCommissionCount.getModifyTime())) {
                    marketUserFinanceDetailModel.setChangeTime(userCommissionCount.getModifyTime());
                } else {
                    marketUserFinanceDetailModel.setChangeTime(userCommissionCount.getCreateTime());
                }
                marketUserFinanceDetailModel.setChangeReason(userCommissionCount.getYear() + userCommissionCount.getMonth() + "薪资");
                marketUserFinanceDetailModel.setAmount(userCommissionCount.getCountTotal());
                marketUserFinanceDetailModel.setStatus("已发放");
                dataList.add(marketUserFinanceDetailModel);
            });
        }
        return dataList;
    }


    //------------------------------------------------------------------------------------------------------------------
    //通过用户id获取用户的真实姓名
    private String getRealNameByUserId(Integer manageId) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andIdEqualTo(manageId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
            UserInfo userInfo = userInfos.get(0);
            if (!Objects.isNull(userInfo)) {
                return userInfo.getRealName();
            }
        }
        return "";
    }

    //通过用户id获取该用户的总业绩
    private double getTotalPerformance(Integer userId) {
        UserPerformanceExample userPerformanceExample = new UserPerformanceExample();
        userPerformanceExample.createCriteria().andUserIdEqualTo(userId);
        List<UserPerformance> userPerformances = userPerformanceMapper.selectByExample(userPerformanceExample);
        double totalPerformance = 0.00;
        if (!Objects.isNull(userPerformances) && userPerformances.size() != 0) {
            for (UserPerformance userPerformance : userPerformances) {
                totalPerformance = new BigDecimal(Double.toString(totalPerformance))
                        .add(new BigDecimal(Double.toString(userPerformance.getPerformance())))
                        .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }
        return totalPerformance;
    }

    private String validSring(String str) {
        if (!StringUtils.isEmpty(str) && str.length() != 0) {
            return str;
        }
        return "";
    }

    private Integer validInteger(Integer itg) {
        if (!Objects.isNull(itg)) {
            return itg;
        }
        return -99;
    }

    private UserInfo getUserInfoV1(Integer userId) {
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

    private CustomerInfo getCustomerInfoV1(Integer custId) {
        CustomerInfoExample customerInfoExample = new CustomerInfoExample();
        customerInfoExample.createCriteria().andIdEqualTo(custId);
        List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
        if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
            CustomerInfo customerInfo = customerInfos.get(0);
            if (!Objects.isNull(customerInfo)) {
                return customerInfo;
            }
        }
        return null;
    }

    private String formatDate(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(dt);
        return format;
    }

    private String formatDateV1(String dt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfV1 = new SimpleDateFormat("yyyyMMdd");
        Date parse = sdf.parse(dt);
        String format = sdfV1.format(parse);
        return format;
    }

    private String validPayResult(Integer custId) {
        PayRecordFinalExample payRecordFinalExample = new PayRecordFinalExample();
        payRecordFinalExample.createCriteria().andCustIdEqualTo(custId);
        List<PayRecordFinal> payRecordFinals = payRecordFinalMapper.selectByExample(payRecordFinalExample);
        if (!Objects.isNull(payRecordFinals) && payRecordFinals.size() != 0) {
            PayRecordFinal payRecordFinal = payRecordFinals.get(0);
            if ("success".equals(payRecordFinal.getPayResult()) && "success_pay".equals(payRecordFinal.getReturnMsg())) {
                return "true";
            }
            return "false";
        }
        return "no_record";
    }
}

