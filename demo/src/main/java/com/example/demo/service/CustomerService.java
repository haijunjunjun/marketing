package com.example.demo.service;

import com.example.demo.constant.ActionStatus;
import com.example.demo.constant.CustomerStatus;
import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.*;
import com.example.demo.model.*;
import com.example.demo.model.http.HttpCustGoldBeansDetailModel;
import com.example.demo.model.http.HttpDataModel;
import com.example.demo.model.http.HttpDonateUserGoldBeansResponseModel;
import com.example.demo.service.httpService.DanateUserGoldBeans;
import com.example.demo.service.httpService.HttpCustGoldBeansAction;
import com.example.demo.service.httpService.ValidUserRegistService;
import com.example.demo.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CustomerService {

    private CustomerInfoMapper customerInfoMapper;
    private CustGoldBeansMapper custGoldBeansMapper;
    private UserGoldBeansMapper userGoldBeansMapper;
    private ConfigMapper configMapper;
    private UserActionMapper userActionMapper;
    private ValidUserRegistService validUserRegistService;
    private DanateUserGoldBeans danateUserGoldBeans;
    private UserReceiptApplyMapper userReceiptApplyMapper;
    private UserInfoMapper userInfoMapper;
    private HttpCustGoldBeansAction httpCustGoldBeansAction;

    @Autowired
    public CustomerService(CustomerInfoMapper customerInfoMapper,
                           CustGoldBeansMapper custGoldBeansMapper,
                           UserGoldBeansMapper userGoldBeansMapper,
                           ConfigMapper configMapper,
                           UserActionMapper userActionMapper,
                           ValidUserRegistService validUserRegistService,
                           DanateUserGoldBeans danateUserGoldBeans,
                           UserReceiptApplyMapper userReceiptApplyMapper,
                           UserInfoMapper userInfoMapper,
                           HttpCustGoldBeansAction httpCustGoldBeansAction) {
        this.customerInfoMapper = customerInfoMapper;
        this.custGoldBeansMapper = custGoldBeansMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
        this.configMapper = configMapper;
        this.userActionMapper = userActionMapper;
        this.validUserRegistService = validUserRegistService;
        this.danateUserGoldBeans = danateUserGoldBeans;
        this.userReceiptApplyMapper = userReceiptApplyMapper;
        this.userInfoMapper = userInfoMapper;
        this.httpCustGoldBeansAction = httpCustGoldBeansAction;
    }

    public MessageInfo<PageInfo<CustRespModel>> getCustomerInfo(Integer userId, Integer status, Integer pageNum, Integer pageSize) {
        MessageInfo<PageInfo<CustRespModel>> customerInfoMessageInfo = new MessageInfo<>();
        if (Objects.isNull(userId) || Objects.isNull(status)) {
            log.info("参数信息有误！");
            customerInfoMessageInfo.setContent("参数信息有误！");
            return customerInfoMessageInfo;
        }
//        CustomerInfo customerInfo = new CustomerInfo();
//        customerInfo.setUserId(userId);
//        customerInfo.setStatus(status);
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerInfo> customerInfoList = customerInfoMapper.getCustomerInfoList(userId, status);
        if (Objects.isNull(customerInfoList)) {
            log.info("客户信息异常，请检查数据库信息！");
            customerInfoMessageInfo.setContent("客户信息异常，请检查数据库信息！");
            return customerInfoMessageInfo;
        }
        PageInfo<CustomerInfo> customerInfoPageInfo = new PageInfo<>(customerInfoList);

        PageInfo<CustRespModel> custRespModelPageInfo = new PageInfo<>();
        List<CustRespModel> custRespModelList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (CustomerInfo c : customerInfoList) {
            CustRespModel custRespModel = new CustRespModel();
            BeanUtils.copyProperties(c, custRespModel);
            custRespModel.setRepoTimeV1(sdf.format(c.getRepoTime() == null ? c.getModifyTime() : c.getRepoTime()));
            custRespModel.setModifyTimeV1(sdf.format(c.getModifyTime()));
            custRespModel.setCheckTimeV1(sdf.format(c.getCheckTime() == null ? c.getModifyTime() : c.getCheckTime()));
            custRespModel.setCompactTimeV1(sdf.format(c.getCompactTime() == null ? c.getModifyTime() : c.getCompactTime()));
            custRespModel.setAbandonTimeV1(sdf.format(c.getAbandonTime() == null ? c.getModifyTime() : c.getAbandonTime()));
            custRespModel.setDeleteTimeV1(sdf.format(c.getDeleteTime() == null ? c.getModifyTime() : c.getDeleteTime()));

            UserReceiptApply userReceiptApply = new UserReceiptApply();
            userReceiptApply.setUserId(userId);
            userReceiptApply.setCustId(c.getId());
            UserReceiptApply userReceiptApplyV1 = userReceiptApplyMapper.selectOne(userReceiptApply);
            if (!Objects.isNull(userReceiptApplyV1) && !Objects.isNull(userReceiptApplyV1.getStatus())) {
                custRespModel.setReceiptStatus(userReceiptApplyV1.getStatus());
            } else {
                custRespModel.setReceiptStatus(4);
            }
            custRespModelList.add(custRespModel);
        }
        BeanUtils.copyProperties(customerInfoPageInfo, custRespModelPageInfo);
        custRespModelPageInfo.setList(custRespModelList);

        customerInfoMessageInfo.setData(custRespModelPageInfo);
        customerInfoMessageInfo.setContent("success");
        return customerInfoMessageInfo;
    }

    public MessageInfo editCustomerInfo(CustomerInfo customerInfo) {
        MessageInfo messageInfo = new MessageInfo();
        if (Objects.isNull(customerInfo)) {
            log.info("系统异常!");
        }

        customerInfo.setUserId(customerInfoMapper.selectByPrimaryKey(customerInfo.getId()).getUserId());
        //添加用户操作动作
        CustomerInfo customerInfoV2 = new CustomerInfo();
        customerInfoV2.setId(customerInfo.getId());
        CustomerInfo customerInfoData = customerInfoMapper.selectOne(customerInfoV2);
        addUserAction(customerInfoData, customerInfo);

        customerInfo.setModifyTime(new Date());
        customerInfo.setLastModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (i != 1) {
            log.info("数据库更新失败！");
        }
//        if (1 == customerInfo.getIsCompact()) {
//            CustomerInfo customerInfoV1 = new CustomerInfo();
//            customerInfoV1.setId(customerInfo.getId());
//            customerInfoV1.setStatus(CustomerStatus.FINISH.getStatus());
//            customerInfoMapper.updateByPrimaryKeySelective(customerInfoV1);
//        }
        messageInfo.setContent("更新成功!");
        return messageInfo;
    }

    private void addUserAction(CustomerInfo customerInfoOrigin, CustomerInfo customerInfoUpdate) {
        String mark = "";
        if (customerInfoOrigin.getIsVisit() != customerInfoUpdate.getIsVisit()) {
            if (!StringUtils.isEmpty(customerInfoUpdate.getMark()) && customerInfoUpdate.getMark().length() != 0) {
                mark = customerInfoUpdate.getMark();
            }
            saveUserAction(customerInfoUpdate.getId(), customerInfoUpdate.getUserId(), ActionStatus.VISIT.getName().trim(), mark);
        }
        if (customerInfoOrigin.getIsPhone() != customerInfoUpdate.getIsPhone()) {
            if (!StringUtils.isEmpty(customerInfoUpdate.getMark()) && customerInfoUpdate.getMark().length() != 0) {
                mark = customerInfoUpdate.getMark();
            }
            saveUserAction(customerInfoUpdate.getId(), customerInfoUpdate.getUserId(), ActionStatus.PHONE.getName().trim(), mark);
        }
        if (customerInfoOrigin.getIsMoney() != customerInfoUpdate.getIsMoney()) {
            if (!StringUtils.isEmpty(customerInfoUpdate.getMark()) && customerInfoUpdate.getMark().length() != 0) {
                mark = customerInfoUpdate.getMark();
            }
            saveUserAction(customerInfoUpdate.getId(), customerInfoUpdate.getUserId(), ActionStatus.MONEY.getName().trim(), mark);
        }
        if (customerInfoOrigin.getIsInterestCust() != customerInfoUpdate.getIsInterestCust()) {
            if (!StringUtils.isEmpty(customerInfoUpdate.getMark()) && customerInfoUpdate.getMark().length() != 0) {
                mark = customerInfoUpdate.getMark();
            }
            saveUserAction(customerInfoUpdate.getId(), customerInfoUpdate.getUserId(), ActionStatus.INTEREST.getName().trim(), mark);
        }
        if (customerInfoOrigin.getIsGoldBeans() != customerInfoUpdate.getIsGoldBeans()) {
            if (!StringUtils.isEmpty(customerInfoUpdate.getMark()) && customerInfoUpdate.getMark().length() != 0) {
                mark = customerInfoUpdate.getMark();
            }
            saveUserAction(customerInfoUpdate.getId(), customerInfoUpdate.getUserId(), ActionStatus.BEANS.getName().trim(), mark);
        }
        if (customerInfoOrigin.getIsCompact() != customerInfoUpdate.getIsCompact()) {
            if (!StringUtils.isEmpty(customerInfoUpdate.getMark()) && customerInfoUpdate.getMark().length() != 0) {
                mark = customerInfoUpdate.getMark();
            }
            saveUserAction(customerInfoUpdate.getId(), customerInfoUpdate.getUserId(), ActionStatus.COMPACT.getName().trim(), mark);
        }
    }

    //保存用户操作动作
    private Integer saveUserAction(Integer custId, Integer userId, String str, String mark) {
        UserAction userAction = new UserAction();
        userAction.setCustId(custId);
        userAction.setUserId(userId);
        if (ActionStatus.VISIT.getName().trim().equals(str)) {
            userAction.setAction(ActionStatus.VISIT.getDesc());
            userAction.setMark(mark);
        }
        if (ActionStatus.COMPACT.getName().trim().equals(str)) {
            userAction.setAction(ActionStatus.COMPACT.getDesc());
            userAction.setMark(mark);
        }
        if (ActionStatus.BEANS.getName().trim().equals(str)) {
            userAction.setAction(ActionStatus.BEANS.getDesc());
            userAction.setMark(mark);
        }
        if (ActionStatus.INTEREST.getName().trim().equals(str)) {
            userAction.setAction(ActionStatus.INTEREST.getDesc());
            userAction.setMark(mark);
        }
        if (ActionStatus.MONEY.getName().trim().equals(str)) {
            userAction.setAction(ActionStatus.MONEY.getDesc());
            userAction.setMark(mark);
        }
        if (ActionStatus.PHONE.getName().trim().equals(str)) {
            userAction.setAction(ActionStatus.PHONE.getDesc());
            userAction.setMark(mark);
        }
        userAction.setCreateTime(new Date());
        return userActionMapper.insert(userAction);
    }

    public MessageInfo removeCustomerInfo(Integer cusId, Integer status, String reason) {
        MessageInfo messageInfo = new MessageInfo();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(cusId);
        if (status == CustomerStatus.ABANDON.getStatus()) {
            customerInfo.setStatus(CustomerStatus.ABANDON.getStatus());
            customerInfo.setAbandonReason(reason);
            customerInfo.setAbandonTime(new Date());
        } else {
            customerInfo.setStatus(CustomerStatus.DELETE.getStatus());
            customerInfo.setDeleteReason(reason);
            customerInfo.setDeleteTime(new Date());
        }
        customerInfo.setModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (i != 1) {
            if (status == CustomerStatus.ABANDON.getStatus()) {
                log.info("放弃失败！");
                messageInfo.setContent("放弃失败！");
                return messageInfo;
            }
            if (status == CustomerStatus.DELETE.getStatus()) {
                log.info("删除失败！");
                messageInfo.setContent("删除失败！");
                return messageInfo;
            }
        }
        if (status == CustomerStatus.ABANDON.getStatus()) {
            log.info("放弃成功！");
            messageInfo.setContent("放弃成功！");
            return messageInfo;
        }
        if (status == CustomerStatus.DELETE.getStatus()) {
            log.info("删除成功！");
            messageInfo.setContent("删除成功！");
            return messageInfo;
        }
        return null;
    }


    public MessageInfo donateGoldBeans(Integer userId, Integer custId, Integer goldBeansNum) throws Exception {
        MessageInfo messageInfo = new MessageInfo();

        //判断该客户是否是云加工注册客户
        CustomerInfo customerInfos = new CustomerInfo();
        customerInfos.setId(custId);
        CustomerInfo customerInfoV1 = customerInfoMapper.selectOne(customerInfos);
        HttpDataModel httpDataModel1 = validUserRegistService.validUserRegist(customerInfoV1.getCustPhone());
        if (Objects.isNull(httpDataModel1) || Objects.isNull(httpDataModel1.getData()) || httpDataModel1.getData().length() == 0 || "null".equals(httpDataModel1.getData())) {
            messageInfo.setContent("该用户目前还没有注册为云加工用户！赠送金豆失败!");
            return messageInfo;
        }

        UserGoldBeans userGoldBeans = new UserGoldBeans();
        userGoldBeans.setUserId(userId);
        UserGoldBeans userGoldBeansV1 = userGoldBeansMapper.selectOne(userGoldBeans);
        if (Objects.isNull(userGoldBeansV1)) {
            log.info("数据库信息异常!");
            throw new BizRuntimeException("数据库信息异常!");
        }
        if (StringUtils.isEmpty(custId.toString()) || custId <= 0) {
            log.info("参数异常!");
            messageInfo.setContent("参数异常!");
            return messageInfo;
        }
        if (userGoldBeansV1.getGoldBeansNum() <= 0) {
            log.info("您的金豆数为0，目前不能赠送");
            messageInfo.setContent("您的金豆数为0，目前不能赠送");
            return messageInfo;
        }
        int i = custGoldBeansMapper.updateCustGoldBeans(custId, goldBeansNum);
        if (i != 1) {
            log.info("更新失败!");
            messageInfo.setContent("更新失败!");
            return messageInfo;
        }
        HttpDonateUserGoldBeansResponseModel httpDonateUserGoldBeansResponseModel = danateUserGoldBeans.donateUserGoldBeans(customerInfoV1.getCustPhone(), goldBeansNum);

        userGoldBeansMapper.updateGoldBeansNum(-goldBeansNum, userId, new Date());
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        customerInfo.setIsGoldBeans(1);
        customerInfo.setLastModifyTime(new Date());
        int isGoldBeansUpdate = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (1 != isGoldBeansUpdate) {
            log.info("客户信息更新异常!");
            throw new BizRuntimeException("客户信息更新异常!");
        }
        UserAction userAction = new UserAction();
        userAction.setUserId(userId);
        userAction.setCreateTime(new Date());
        userAction.setAction("已赠送金豆");
        userAction.setCustId(custId);
        userAction.setMark("");
        userActionMapper.insert(userAction);

        messageInfo.setContent("赠送成功！");
        return messageInfo;
    }

    public MessageInfoV2 saveCustomerInfo(Integer userId, CustomerInfo customerInfo) {
        MessageInfoV2 messageInfo = new MessageInfoV2();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("userId 参数信息异常!");
            throw new BizRuntimeException("userId 参数信息异常!");
        }
        if (Objects.isNull(customerInfo)) {
            log.info("报备信息异常!");
            messageInfo.setFailContent("报备信息异常!");
            return messageInfo;
        }

        //判断该客户是否可以再次进行报备
        CustomerInfo customerInfoV1 = new CustomerInfo();
        customerInfoV1.setCustPhone(customerInfo.getCustPhone());
        List<CustomerInfo> customerInfoList = customerInfoMapper.select(customerInfoV1);
        for (CustomerInfo customerInfo1 : customerInfoList) {
            if (customerInfo1.getStatus() == 1) {
                messageInfo.setFailContent("报备失败!该客户目前处于待跟进状态中!");
                return messageInfo;
            } else if (customerInfo1.getStatus() == 2) {
                messageInfo.setFailContent("报备失败!该客户目前已经签约!!");
                return messageInfo;
            }
        }


        customerInfo.setUserId(userId);
        if (customerInfo.getIsCompact() == 0) {
            customerInfo.setStatus(1);
        } else {
            customerInfo.setStatus(1);
            customerInfo.setIsCompactCheck(2);
        }
        customerInfo.setRepoTime(new Date());
        customerInfo.setModifyTime(new Date());
        int i = customerInfoMapper.insert(customerInfo);
        if (i != 1) {
            log.info("报备失败！");
            messageInfo.setFailContent("报备失败!");
            return messageInfo;
        }
        CustGoldBeans custGoldBeans = new CustGoldBeans();
        custGoldBeans.setCustId(customerInfo.getId());
        custGoldBeans.setGoldBeansNum(0);
        custGoldBeans.setCreateTime(new Date());
        int insert = custGoldBeansMapper.insert(custGoldBeans);
        if (1 != insert) {
            log.info("客户金豆初始化失败");
        }
        String mark = "";
        if (1 == customerInfo.getIsPhone()) {
            if (!StringUtils.isEmpty(customerInfo.getMark()) && customerInfo.getMark().length() != 0) {
                mark = customerInfo.getMark();
            }
            saveUserAction(customerInfo.getId(), userId, "phone", mark);
        }
        if (1 == customerInfo.getIsVisit()) {
            if (!StringUtils.isEmpty(customerInfo.getMark()) && customerInfo.getMark().length() != 0) {
                mark = customerInfo.getMark();
            }
            saveUserAction(customerInfo.getId(), userId, "visit", mark);
        }
        if (1 == customerInfo.getIsCompact()) {
            if (!StringUtils.isEmpty(customerInfo.getMark()) && customerInfo.getMark().length() != 0) {
                mark = customerInfo.getMark();
            }
            saveUserAction(customerInfo.getId(), userId, "compact", mark);
        }
        if (1 == customerInfo.getIsInterestCust()) {
            if (!StringUtils.isEmpty(customerInfo.getMark()) && customerInfo.getMark().length() != 0) {
                mark = customerInfo.getMark();
            }
            saveUserAction(customerInfo.getId(), userId, "interest", mark);
        }
        if (1 == customerInfo.getIsGoldBeans()) {
            if (!StringUtils.isEmpty(customerInfo.getMark()) && customerInfo.getMark().length() != 0) {
                mark = customerInfo.getMark();
            }
            saveUserAction(customerInfo.getId(), userId, "beans", mark);
        }
        if (1 == customerInfo.getIsMoney()) {
            if (!StringUtils.isEmpty(customerInfo.getMark()) && customerInfo.getMark().length() != 0) {
                mark = customerInfo.getMark();
            }
            saveUserAction(customerInfo.getId(), userId, "money", mark);
        }

        log.info("报备成功");
        messageInfo.setSuccessContent("报备成功!");
        return messageInfo;
    }

    public MessageInfoV1 updateCustomerPrice(Integer id, double price) {
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(id);
        customerInfo.setPrice(price);
        customerInfo.setLastModifyTime(new Date());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (1 != i) {
            log.info("签约价更新失败");
            messageInfoV1.setContent("签约价更新失败");
            return messageInfoV1;
        }
        messageInfoV1.setContent("签约价更新成功");
        return messageInfoV1;
    }

    public MessageInfo<CustInfoModel> getCustInfo(Integer custId) {
        MessageInfo<CustInfoModel> messageInfo = new MessageInfo<>();
        if (Objects.isNull(custId)) {
            log.info("参数信息异常!");
        }
        CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(custId);
        if (Objects.isNull(customerInfo)) {
            log.info("数据库信息异常！");
        }
        CustInfoModel custInfoModel = new CustInfoModel();
        BeanUtils.copyProperties(customerInfo, custInfoModel);
        messageInfo.setData(custInfoModel);
        messageInfo.setContent("success");
        return messageInfo;
    }

    public MessageInfo<Integer> getCustGoldBeans() {
        MessageInfo<Integer> messageInfo = new MessageInfo<>();
        Config config = new Config();
        config.setConfigName(CustomerUtil.DONATE_CUST_GOLD_BEANS.getName());
        Config configInfo = configMapper.selectOne(config);
        if (Objects.isNull(configInfo)) {
            log.info("配置信息异常！");
            messageInfo.setContent("配置信息异常!");
            return messageInfo;
        }
        messageInfo.setData(configInfo.getConfigValue());
        messageInfo.setContent("success");
        return messageInfo;
    }

    public MessageInfo<String> custReceiptApply(Integer userId, UserCustReceiptApplyModel userCustReceiptApplyModel) {
        MessageInfo<String> messageInfo = new MessageInfo<>();
        UserReceiptApply userReceiptApply = new UserReceiptApply();
        userReceiptApply.setUserId(userId);
        userReceiptApply.setCustId(userCustReceiptApplyModel.getCustId());
        if (!StringUtils.isEmpty(userCustReceiptApplyModel.getCompanyName()) && userCustReceiptApplyModel.getCompanyName().length() != 0) {
            userReceiptApply.setCompanyName(userCustReceiptApplyModel.getCompanyName());
        }
        if (!StringUtils.isEmpty(userCustReceiptApplyModel.getCustReceiptAddress()) && userCustReceiptApplyModel.getCustReceiptAddress().length() != 0) {
            userReceiptApply.setCustReceiptAddress(userCustReceiptApplyModel.getCustReceiptAddress());
        }
        if (!StringUtils.isEmpty(userCustReceiptApplyModel.getCustReceiptName()) && userCustReceiptApplyModel.getCustReceiptName().length() != 0) {
            userReceiptApply.setApplyUserName(userCustReceiptApplyModel.getCustReceiptName());
        }
        if (!StringUtils.isEmpty(userCustReceiptApplyModel.getCustReceiptPhone()) && userCustReceiptApplyModel.getCustReceiptPhone().length() != 0) {
            userReceiptApply.setApplyUserPhone(userCustReceiptApplyModel.getCustReceiptPhone());
        }
        if (!StringUtils.isEmpty(userCustReceiptApplyModel.getDutyParagraph()) && userCustReceiptApplyModel.getDutyParagraph().length() != 0) {
            userReceiptApply.setDutyParagraph(userCustReceiptApplyModel.getDutyParagraph());
        }
        if (!StringUtils.isEmpty(userCustReceiptApplyModel.getReceiptTitle()) && userCustReceiptApplyModel.getReceiptTitle().length() != 0) {
            userReceiptApply.setReceiptTitle(userCustReceiptApplyModel.getReceiptTitle());
        }
        userReceiptApply.setCreateTime(new Date());
        userReceiptApply.setApplyTime(new Date());
        userReceiptApply.setStatus(1);
        int insert = userReceiptApplyMapper.insert(userReceiptApply);
        if (1 != insert) {
            log.info("发票申请失败");
            messageInfo.setContent("发票申请失败");
            return messageInfo;
        }
        messageInfo.setContent("发票申请成功");
        return messageInfo;
    }

    public CustBaseInfo getCustBaseInfo(CustModel custModel) {
        CustBaseInfo custBaseInfo = new CustBaseInfo();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custModel.getCustId());
        CustomerInfo customerInfoV1 = customerInfoMapper.selectOne(customerInfo);
        if (!StringUtils.isEmpty(customerInfoV1.getCompanyAddr()) && customerInfoV1.getCompanyAddr().length() != 0) {
            custBaseInfo.setAddress(customerInfoV1.getCompanyAddr());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getCompanyName()) && customerInfoV1.getCompanyName().length() != 0) {
            custBaseInfo.setCompanyName(customerInfoV1.getCompanyName());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getCompanyType()) && customerInfoV1.getCompanyType().length() != 0) {
            custBaseInfo.setCompanyType(customerInfoV1.getCompanyType());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getCompanyTypeDesc()) && customerInfoV1.getCompanyTypeDesc().length() != 0) {
            custBaseInfo.setCompanyTypeDesc(customerInfoV1.getCompanyTypeDesc());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getCustName()) && customerInfoV1.getCustName().length() != 0) {
            custBaseInfo.setCustName(customerInfoV1.getCustName());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getCustPhone()) && customerInfoV1.getCustPhone().length() != 0) {
            custBaseInfo.setCustPhone(customerInfoV1.getCustPhone());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getMark()) && customerInfoV1.getMark().length() != 0) {
            custBaseInfo.setMark(customerInfoV1.getMark());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getLongitude()) && customerInfoV1.getLongitude().length() != 0) {
            custBaseInfo.setLongitude(customerInfoV1.getLongitude());
        }
        if (!StringUtils.isEmpty(customerInfoV1.getLatitude()) && customerInfoV1.getLatitude().length() != 0) {
            custBaseInfo.setLatitude(customerInfoV1.getLatitude());
        }
        return custBaseInfo;
    }

    public MessageInfo<String> custBaseAction(Integer userId, Integer custId, String actionCode, String operateTime, String mark) throws Exception {
        MessageInfo<String> messageInfo = new MessageInfo<>();
        UserAction userAction = new UserAction();
        userAction.setUserId(userId);
        userAction.setCustId(custId);
        if (!StringUtils.isEmpty(operateTime) && operateTime.length() != 0) {
            userAction.setCreateTime(DateUtil.dateStrV8(operateTime));
//            userAction.setModifyTime(DateUtil.dateStrV8(operateTime));
        } else {
            userAction.setCreateTime(new Date());
//            userAction.setModifyTime(new Date());
        }
        if (!StringUtils.isEmpty(mark) && mark.length() != 0) {
            userAction.setMark(mark);
        }
        userAction.setAction(CustBaseAction.getNameByCode(actionCode));
        int insert = userActionMapper.insert(userAction);
        if (1 != insert) {
            messageInfo.setContent("记录失败");
            return messageInfo;
        }
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        if (actionCode.equals(CustBaseAction.CONTACT.getCode())) {
            customerInfo.setIsPhone(1);
        }
        if (actionCode.equals(CustBaseAction.VISIT.getCode())) {
            customerInfo.setIsVisit(1);
        }
        if (actionCode.equals(CustBaseAction.INTEREST.getCode())) {
            customerInfo.setIsInterestCust(1);
        }
        customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        messageInfo.setContent("记录成功");
        return messageInfo;
    }

    public List<CustBaseOperateModel> custBaseOperate(Integer userId, Integer custId) {
        List<CustBaseOperateModel> dataList = new ArrayList<>();
        List<UserAction> userActionList = userActionMapper.getUserActionListInfo(userId, custId);
        if (!Objects.isNull(userActionList) && userActionList.size() != 0) {
            userActionList.forEach(userActionInfo -> {
                CustBaseOperateModel custBaseOperateModel = new CustBaseOperateModel();
                custBaseOperateModel.setId(userActionInfo.getId());
                if (!StringUtils.isEmpty(userActionInfo.getAction()) && userActionInfo.getAction().length() != 0) {
                    if (ActionStatus.INTEREST.getDesc().trim().equals(userActionInfo.getAction().trim())) {
                        custBaseOperateModel.setActionName(CustBaseAction.HASINTEREST.getName().trim());
                    } else {
                        custBaseOperateModel.setActionName(userActionInfo.getAction());
                    }
                    if (ActionStatus.PHONE.getDesc().equals(userActionInfo.getAction().trim())
                            || ActionStatus.VISIT.getDesc().equals(userActionInfo.getAction().trim())
                            || ActionStatus.INTEREST.getDesc().equals(userActionInfo.getAction().trim())) {
                        custBaseOperateModel.setIsEdit("1");
                    } else {
                        custBaseOperateModel.setIsEdit("0");
                    }
                }
                String s = DateUtil.dateStrV4(new Date());
                if (!Objects.isNull(userActionInfo.getModifyTime())) {
                    String s1 = DateUtil.dateStrV4(userActionInfo.getModifyTime());
                    if (s.equals(s1)) {
                        custBaseOperateModel.setOperateTime(DateUtil.dateStrV5(userActionInfo.getModifyTime()));
                    } else {
                        custBaseOperateModel.setOperateTime(DateUtil.dateStrV6(userActionInfo.getModifyTime()));
                    }
                } else {
                    String s2 = DateUtil.dateStrV4(userActionInfo.getCreateTime());
                    if (s.equals(s2)) {
                        custBaseOperateModel.setOperateTime(DateUtil.dateStrV5(userActionInfo.getCreateTime()));
                    } else {
                        custBaseOperateModel.setOperateTime(DateUtil.dateStrV6(userActionInfo.getCreateTime()));
                    }
                }
                UserInfo userInfo = new UserInfo();
                userInfo.setId(userId);
                UserInfo userInfos = userInfoMapper.selectOne(userInfo);
                if (!Objects.isNull(userInfos) && !StringUtils.isEmpty(userInfos.getRealName()) && userInfos.getRealName().length() != 0) {
                    custBaseOperateModel.setUserName(userInfos.getRealName());
                }
                dataList.add(custBaseOperateModel);
            });
        }
        return dataList;
    }

    public CustBaseOperateEditInfoModel getCustBaseOperateEditInfo(Integer id) {
        CustBaseOperateEditInfoModel custBaseOperateEditInfoModel = new CustBaseOperateEditInfoModel();
        UserAction userAction = new UserAction();
        userAction.setId(id);
        UserAction userActionInfo = userActionMapper.selectOne(userAction);
        if (!Objects.isNull(userActionInfo)) {
            if (!Objects.isNull(userActionInfo.getModifyTime())) {
                custBaseOperateEditInfoModel.setOperateTime(DateUtil.dateStrV6(userActionInfo.getModifyTime()));
            } else {
                custBaseOperateEditInfoModel.setOperateTime(DateUtil.dateStrV6(userActionInfo.getCreateTime()));
            }
            if (!StringUtils.isEmpty(userActionInfo.getAction()) && userActionInfo.getAction().length() != 0) {
                custBaseOperateEditInfoModel.setMark(userActionInfo.getMark());
            }
            custBaseOperateEditInfoModel.setId(userActionInfo.getId());
        }
        return custBaseOperateEditInfoModel;
    }

    public MessageInfo<String> custBaseOperateEdit(CustBaseOperateEditInfoModel custBaseOperateEditInfoModel) throws ParseException {
        MessageInfo<String> messageInfo = new MessageInfo<>();

        UserAction userActionInfoV1 = this.getUserActionInfo(custBaseOperateEditInfoModel.getId());
        if (!Objects.isNull(userActionInfoV1)) {
            if (CustBaseAction.INTEREST.getName().equals(userActionInfoV1.getAction().trim())) {
                UserAction userAction = new UserAction();
                userAction.setId(custBaseOperateEditInfoModel.getId());
                userAction.setAction(CustBaseAction.NOINTEREST.getName().trim());
                userAction.setModifyTime(new Date());
                userAction.setMark("用户自己修改");
                int i = userActionMapper.updateByPrimaryKeySelective(userAction);
                if (1 != i) {
                    messageInfo.setContent("更新失败");
                    return messageInfo;
                }
                CustomerInfo customerInfo = new CustomerInfo();
                customerInfo.setId(userActionInfoV1.getCustId());
                customerInfo.setIsInterestCust(0);
                customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
                messageInfo.setContent("更新成功");
                return messageInfo;
            }
        }
        UserAction userAction = new UserAction();
        userAction.setId(custBaseOperateEditInfoModel.getId());
        if (!StringUtils.isEmpty(custBaseOperateEditInfoModel.getOperateTime()) && custBaseOperateEditInfoModel.getOperateTime().length() != 0) {
            Date realOperateTime = DateUtil.dateStrV8(custBaseOperateEditInfoModel.getOperateTime());
            userAction.setModifyTime(realOperateTime);
        }
        if (!StringUtils.isEmpty(custBaseOperateEditInfoModel.getMark()) && custBaseOperateEditInfoModel.getMark().length() != 0) {
            userAction.setMark(custBaseOperateEditInfoModel.getMark());
        }
        int i = userActionMapper.updateByPrimaryKeySelective(userAction);
        if (1 != i) {
            messageInfo.setContent("更新失败");
            return messageInfo;
        }
        messageInfo.setContent("更新成功");
        return messageInfo;
    }

    public MessageInfo<String> custBaseOperateDelete(IdModel idModel) {
        MessageInfo<String> messageInfo = new MessageInfo<>();

        UserAction userAction = new UserAction();
        userAction.setId(idModel.getId());
        UserAction userActionInfo = userActionMapper.selectOne(userAction);

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(userActionInfo.getCustId());
        if (CustBaseAction.CONTACT.getName().trim().equals(userActionInfo.getAction().trim())) {
            customerInfo.setIsPhone(0);
        }
        if (CustBaseAction.VISIT.getName().trim().equals(userActionInfo.getAction().trim())) {
            customerInfo.setIsVisit(0);
        }
        if (CustBaseAction.INTEREST.getName().trim().equals(userActionInfo.getAction().trim())) {
            customerInfo.setIsInterestCust(0);
        }
        customerInfoMapper.updateByPrimaryKeySelective(customerInfo);

        int i = userActionMapper.deleteByPrimaryKey(idModel.getId());
        if (1 != i) {
            messageInfo.setContent("记录删除失败");
            return messageInfo;
        }


        messageInfo.setContent("记录删除成功");
        return messageInfo;
    }

    public MessageInfoV3<HttpCustGoldBeansDetailModel> getCustGoldBeansDetail(Integer custId) throws Exception {
        MessageInfoV3<HttpCustGoldBeansDetailModel> userGoldBeansDetail = new MessageInfoV3<>();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        CustomerInfo customerInfos = customerInfoMapper.selectOne(customerInfo);
        if (!Objects.isNull(customerInfos) && !StringUtils.isEmpty(customerInfos.getCustPhone()) && customerInfos.getCustPhone().length() != 0) {
            HttpDataModel httpDataModel1 = validUserRegistService.validUserRegist(customerInfos.getCustPhone());
            if (Objects.isNull(httpDataModel1) || Objects.isNull(httpDataModel1.getData()) || httpDataModel1.getData().length() == 0 || "null".equals(httpDataModel1.getData())) {
                userGoldBeansDetail.setCode("40001");
                userGoldBeansDetail.setContent("该用户还没有注册为云加工用户");
                return userGoldBeansDetail;
            }
            String custPhone = customerInfos.getCustPhone();
            userGoldBeansDetail = httpCustGoldBeansAction.getUserGoldBeansDetail(custPhone);
            return userGoldBeansDetail;
        }
        return null;
    }

//----------------------------------------------------------------------------------------------------------------------------------

    private UserAction getUserActionInfo(Integer id) {
        return userActionMapper.selectByPrimaryKey(id);
    }
}
