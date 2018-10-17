package com.niule.marketing.controller.controller.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.marketing.controller.controller.dal.mapper.*;
import com.niule.marketing.controller.controller.dal.mapper.define.CustomerResponseMapper;
import com.niule.marketing.controller.controller.dal.model.*;
import com.niule.marketing.controller.controller.dal.model.define.CustomerResponse;
import com.niule.marketing.controller.controller.model.*;
import com.niule.marketing.controller.controller.service.httpService.HttpRemoteService;
import com.niule.marketing.controller.controller.util.CustStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 18:55
 */
@Slf4j
@Service
public class CustomerInfoService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private CustGoldBeansMapper custGoldBeansMapper;
    @Autowired
    private UserActionMapper userActionMapper;
    @Autowired
    private PayRecordMapper payRecordMapper;
    @Autowired
    private CustomerResponseMapper customerResponseMapper;
    @Autowired
    private HttpRemoteService httpRemoteService;
    @Autowired
    private PayRecordFinalMapper payRecordFinalMapper;

    public List<CustomerResponseModel> getCustomerInfo() {
        List<CustomerResponseModel> customerResponseModelList = new ArrayList<>();
        CustomerInfoExample customerInfoExample = new CustomerInfoExample();
        customerInfoExample.setOrderByClause("repo_time desc , modify_time desc");
        List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
        if (!Objects.isNull(customerInfos)) {
            customerInfos.forEach(data -> {
                CustomerResponseModel customerResponseModel = new CustomerResponseModel();
                customerResponseModel.setId(data.getId());
                customerResponseModel.setCompanyName(data.getCompanyName());
                customerResponseModel.setCompanyType(data.getCompanyType());
                customerResponseModel.setCreateTime(data.getRepoTime());
                customerResponseModel.setModifyTime(data.getModifyTime());
                customerResponseModel.setCustName(data.getCustName());
                customerResponseModel.setCustPhone(data.getCustPhone());
                customerResponseModel.setIsPhone(data.getIsPhone());
                customerResponseModel.setIsCompact(data.getIsCompact());
                customerResponseModel.setIsCompactCheck(data.getIsCompactCheck());
                customerResponseModel.setIsGoldBeans(data.getIsGoldBeans());
                customerResponseModel.setIsInterestCust(data.getIsInterestCust());
                customerResponseModel.setIsMoney(data.getIsMoney());
                customerResponseModel.setIsVisit(data.getIsVisit());
                customerResponseModel.setStatusName(CustStatusEnum.getNameByCode(data.getStatus()));

                try {
                    HttpCustRegistInfoModel userRegistInfo = httpRemoteService.getUserRegistInfo(data.getCustPhone());
                    Date date = new Date(userRegistInfo.getData());
                    customerResponseModel.setCustRegistTime(date == null ? null : date);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                UserInfoExample userInfoExample = new UserInfoExample();
                userInfoExample.createCriteria().andIdEqualTo(data.getUserId());
                List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
                customerResponseModel.setUserName(userInfos.get(0).getRealName());
                customerResponseModel.setUserPhone(userInfos.get(0).getPhone());
                customerResponseModelList.add(customerResponseModel);
            });
        }
        return customerResponseModelList;
    }

    public CustomerDetailResponseModel getCustomerDetailInfo(Integer custId) {
        assert (custId != null) : "custId 不能为空!";

        CustomerDetailResponseModel customerDetailResponseModel = new CustomerDetailResponseModel();
        CustomerInfoExample customerInfoExample = new CustomerInfoExample();
//        List<Integer> data = new ArrayList<>();
//        data.add(CustStatusEnum.DOING.getCode());
//        data.add(CustStatusEnum.HASCOMPACT.getCode());
        customerInfoExample.createCriteria().andIdEqualTo(custId);
        List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
        if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
            CustomerInfo customerInfo = customerInfos.get(0);
            customerDetailResponseModel.setCustId(customerInfo.getId());
            customerDetailResponseModel.setCompanyAddr(customerInfo.getCompanyAddr());
            customerDetailResponseModel.setCompanyType(customerInfo.getCompanyType());
            customerDetailResponseModel.setCompanyName(customerInfo.getCompanyName());
            customerDetailResponseModel.setCustName(customerInfo.getCustName());
            customerDetailResponseModel.setCustPhone(customerInfo.getCustPhone());
            customerDetailResponseModel.setIsCompact(customerInfo.getIsCompact());
            customerDetailResponseModel.setIsCompactCheck(customerInfo.getIsCompactCheck());
            customerDetailResponseModel.setIsGoldBeans(customerInfo.getIsGoldBeans());
            customerDetailResponseModel.setIsInterestCust(customerInfo.getIsInterestCust());
            customerDetailResponseModel.setIsMoney(customerInfo.getIsMoney());
            customerDetailResponseModel.setIsPhone(customerInfo.getIsPhone());
            customerDetailResponseModel.setIsVisit(customerInfo.getIsVisit());

            CustGoldBeansExample custGoldBeansExample = new CustGoldBeansExample();
            custGoldBeansExample.createCriteria().andCustIdEqualTo(custId);
            List<CustGoldBeans> custGoldBeans = custGoldBeansMapper.selectByExample(custGoldBeansExample);
            if (!Objects.isNull(custGoldBeans) && custGoldBeans.size() != 0) {
                customerDetailResponseModel.setGoldBeans(custGoldBeans.get(0).getGoldBeansNum());
            }

            customerDetailResponseModel.setMark(customerInfo.getMark());
            customerDetailResponseModel.setModifyTime(customerInfo.getModifyTime());
            try {
                HttpCustRegistInfoModel userRegistInfo = httpRemoteService.getUserRegistInfo(customerInfo.getCustPhone());
                Date date = new Date(userRegistInfo.getData());
                customerDetailResponseModel.setRegistTime(date == null ? null : date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            customerDetailResponseModel.setRepoTime(customerInfo.getRepoTime());
            customerDetailResponseModel.setStatusName(CustStatusEnum.getNameByCode(customerInfo.getStatus()));

            UserInfoExample userInfoExample = new UserInfoExample();
            userInfoExample.createCriteria().andIdEqualTo(customerInfo.getUserId());
            List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
            if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
                customerDetailResponseModel.setUserPhone(userInfos.get(0).getPhone());
                customerDetailResponseModel.setUserRealName(userInfos.get(0).getRealName());
            }
        }
        return customerDetailResponseModel;
    }

    public PageInfo<FollowRecord> getCustFollowRecordInfo(Integer custId, Integer pageNum, Integer pageSize) {
        assert (custId != null) : "custId 不能为空!";

        List<FollowRecord> followRecordList = new ArrayList<>();

        UserActionExample userActionExample = new UserActionExample();
        userActionExample.createCriteria().andCustIdEqualTo(custId);
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        List<UserAction> userActions = userActionMapper.selectByExample(userActionExample);
        PageInfo userActionPageInfo = new PageInfo<>(userActions);
        if (!Objects.isNull(userActions) && userActions.size() != 0) {
            userActions.forEach(u -> {
                FollowRecord followRecord = new FollowRecord();

                UserInfoExample userInfoExample = new UserInfoExample();
                userInfoExample.createCriteria().andIdEqualTo(u.getUserId());
                List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
                if (!Objects.isNull(userInfos) && userInfos.size() != 0) {
                    UserInfo userInfo = userInfos.get(0);
                    followRecord.setUserPhone(userInfo.getPhone());
                    followRecord.setUserRealName(userInfo.getRealName());
                }

                CustomerInfoExample customerInfoExample = new CustomerInfoExample();
                customerInfoExample.createCriteria().andIdEqualTo(u.getCustId());
                List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
                if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
                    CustomerInfo customerInfo = customerInfos.get(0);
                    followRecord.setCustName(customerInfo.getCustName());
                    followRecord.setCustPhone(customerInfo.getCustPhone());
                }

                followRecord.setCreateTime(u.getCreateTime());
                followRecord.setFollowStatus(u.getAction());
                followRecord.setMark(u.getMark());
                followRecord.setId(u.getId());
                followRecordList.add(followRecord);
            });
        }
        userActionPageInfo.setList(followRecordList);
        return userActionPageInfo;
    }

    public PageInfo<CompactDetailModel> getCustCompactModel(Integer custId,Integer pageNum,Integer pageSize) {
        assert (custId != null) : "custId 不能为空!";

        List<CompactDetailModel> compactDetailModelList = new ArrayList<>();

        CustomerInfoExample customerInfoExample = new CustomerInfoExample();
//        List<Integer> data = new ArrayList<>();
//        data.add(CustStatusEnum.DOING.getCode());
//        data.add(CustStatusEnum.HASCOMPACT.getCode());
        customerInfoExample.createCriteria().andIdEqualTo(custId).andIsCompactEqualTo(1);
        PageHelper.startPage(pageNum,pageSize);
        List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
        PageInfo customerInfoPageInfo = new PageInfo<>(customerInfos);
        if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
            customerInfos.forEach(customerInfo -> {
                CompactDetailModel compactDetailModel = new CompactDetailModel();
                compactDetailModel.setId(customerInfo.getId());
                compactDetailModel.setCustName(customerInfo.getCustName());
                compactDetailModel.setCustPhone(customerInfo.getCustPhone());
                compactDetailModel.setCompactImg(customerInfo.getCompactImg());
                compactDetailModel.setCreateTime(customerInfo.getCompactTime());
                compactDetailModelList.add(compactDetailModel);
            });
        }
        customerInfoPageInfo.setList(compactDetailModelList);
        return customerInfoPageInfo;
    }

    public PageInfo<FinanceDetail> getFinanceDetailInfo(Integer custId,Integer pageNum,Integer pageSize) {
        assert (custId != null) : "custId 不能为空!";

        List<FinanceDetail> financeDetailList = new ArrayList<>();

        CustomerInfoExample customerInfoExample = new CustomerInfoExample();
//        List<Integer> data = new ArrayList<>();
//        data.add(CustStatusEnum.DOING.getCode());
//        data.add(CustStatusEnum.HASCOMPACT.getCode());
        customerInfoExample.createCriteria().andIdEqualTo(custId);
        List<CustomerInfo> customerInfos = customerInfoMapper.selectByExample(customerInfoExample);
        if (!Objects.isNull(customerInfos) && customerInfos.size() != 0) {
            CustomerInfo customerInfo = customerInfos.get(0);
            if (Objects.isNull(customerInfo.getPrice())) {
                return null;
            }
            PayRecordFinalExample payRecordFinalExample = new PayRecordFinalExample();
            payRecordFinalExample.createCriteria().andCustIdEqualTo(custId);
            PageHelper.startPage(pageNum,pageSize);
            List<PayRecordFinal> payRecordFinals = payRecordFinalMapper.selectByExample(payRecordFinalExample);
            PageInfo payRecordFinalPageInfo = new PageInfo<>(payRecordFinals);
            if (!Objects.isNull(payRecordFinals) && payRecordFinals.size() != 0){
                payRecordFinals.forEach(payRecordFinal -> {
                    FinanceDetail financeDetail = new FinanceDetail();
                    financeDetail.setCustName(customerInfo.getCustName());
                    financeDetail.setAmount(customerInfo.getPrice());
                    financeDetail.setCustPhone(customerInfo.getCustPhone());
                    financeDetail.setCustId(customerInfo.getId());
                    if ("success".equals(payRecordFinal.getPayResult()) && "success_pay".equals(payRecordFinal.getReturnMsg())){
                        financeDetail.setPayStatus("支付成功");
                    }else {
                        financeDetail.setPayStatus("支付失败");
                    }
                    financeDetail.setOperateTime(payRecordFinal.getCreateTime());
                    financeDetailList.add(financeDetail);
                });
            }
            payRecordFinalPageInfo.setList(financeDetailList);
            return payRecordFinalPageInfo;
        }
        return null;
    }

    public PageInfo<CustomerResponseModel> searchCustomerInfo(CustomerSearchRequestModel customerSearchRequestModel) {
        List<CustomerResponseModel> customerResponseModelList = new ArrayList<>();

        CustomerSearchRequestModel customerSearchRequestModelV1 = new CustomerSearchRequestModel();
        if (customerSearchRequestModel.getCustName() != null && customerSearchRequestModel.getCustName().length() != 0) {
            customerSearchRequestModelV1.setCustName(customerSearchRequestModel.getCustName());
        }
        if (customerSearchRequestModel.getStatus() != null && customerSearchRequestModel.getStatus() != 99) {
            customerSearchRequestModelV1.setStatus(customerSearchRequestModel.getStatus());
        }
        if (customerSearchRequestModel.getCustPhone() != null && customerSearchRequestModel.getCustPhone().length() != 0) {
            customerSearchRequestModelV1.setCustPhone(customerSearchRequestModel.getCustPhone());
        }
        if (customerSearchRequestModel.getUserPhone() != null && customerSearchRequestModel.getUserPhone().length() != 0) {
            customerSearchRequestModelV1.setUserPhone(customerSearchRequestModel.getUserPhone());
        }
        if (customerSearchRequestModel.getUserRealName() != null && customerSearchRequestModel.getUserRealName().length() != 0) {
            customerSearchRequestModelV1.setUserRealName(customerSearchRequestModel.getUserRealName());
        }
        PageHelper.startPage(customerSearchRequestModel.getPageNum() == null ? 1 : customerSearchRequestModel.getPageNum(), customerSearchRequestModel.getPageSize() == null ? 10 : customerSearchRequestModel.getPageSize());
        PageInfo pageInfo = new PageInfo(customerResponseMapper.searchCustInfo(customerSearchRequestModelV1));
        List<CustomerResponse> customerResponses = pageInfo.getList();
        if (!Objects.isNull(customerResponses) && customerResponses.size() != 0) {
            customerResponses.forEach(customerResponse -> {
                CustomerResponseModel customerResponseModel = new CustomerResponseModel();
                customerResponseModel.setStatusName(CustStatusEnum.getNameByCode(customerResponse.getStatus()));
                customerResponseModel.setIsVisit(customerResponse.getIsVisit());
                customerResponseModel.setIsMoney(customerResponse.getIsMoney());
                customerResponseModel.setIsInterestCust(customerResponse.getIsInterestCust());
                customerResponseModel.setIsGoldBeans(customerResponse.getIsGoldBeans());
                customerResponseModel.setIsCompact(customerResponse.getIsCompact());
                customerResponseModel.setIsCompactCheck(customerResponse.getIsCompactCheck());
                customerResponseModel.setIsPhone(customerResponse.getIsPhone());
                customerResponseModel.setUserPhone(customerResponse.getUserPhone());
                customerResponseModel.setUserName(customerResponse.getUserName());
                try {
                    HttpCustRegistInfoModel userRegistInfo = httpRemoteService.getUserRegistInfo(customerResponse.getCustPhone());
                    Date date = new Date(userRegistInfo.getData());
                    customerResponseModel.setCustRegistTime(date == null ? null : date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                customerResponseModel.setCustPhone(customerResponse.getCustPhone());
                customerResponseModel.setCustName(customerResponse.getCustName());
                customerResponseModel.setCreateTime(customerResponse.getCreateTime());
                if (!Objects.isNull(customerResponse.getModifyTime())) {
                    customerResponseModel.setModifyTime(customerResponse.getModifyTime());
                }
                customerResponseModel.setCompanyType(customerResponse.getCompanyType());
                customerResponseModel.setCompanyName(customerResponse.getCompanyName());
                customerResponseModel.setId(customerResponse.getId());
                customerResponseModelList.add(customerResponseModel);
            });
        }
        pageInfo.setList(customerResponseModelList);
        return pageInfo;
    }

    public Boolean deleteCustInfo(Integer custId) {
        assert (custId != null) : "custId 不能为空!";

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        customerInfo.setStatus(CustStatusEnum.DELETE.getCode());
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (1 == i) {
            log.info("更新成功！");
            return true;
        }
        return false;
    }
}
