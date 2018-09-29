package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.AccountBankMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.AccountBank;
import com.niule.yunjiagong.yunjiagong.model.AccountBankRequestModel;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 16:43
 */
@Service
public class AccountBankService {

    @Autowired
    private AccountBankMapper accountBankMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;

    public String saveAccountBankInfo (AccountBankRequestModel accountBankRequestModel){
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        if (Objects.isNull(userId)){
            return "userId 为空";
        }
        if (this.isSaveAccountBankInfo(userId)){
            AccountBank accountBank = new AccountBank();
            accountBank.setId(this.getAccountBankId(userId));
            if (!StringUtils.isEmpty(accountBankRequestModel.getAccountHolder()) && accountBankRequestModel.getAccountHolder().length() != 0){
                accountBank.setAccountHolder(accountBankRequestModel.getAccountHolder());
            }
            if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankName()) && accountBankRequestModel.getAccountBankName().length() != 0){
                accountBank.setAccountBankName(accountBankRequestModel.getAccountBankName());
            }
            if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankNo()) && accountBankRequestModel.getAccountBankNo().length() != 0){
                accountBank.setAccountBankNo(accountBankRequestModel.getAccountBankNo());
            }
            accountBank.setModifyTime(new Date());
            int i = accountBankMapper.updateByPrimaryKeySelective(accountBank);
            if (1 != i){
                return "银行卡信息更新失败";
            }
            return "success";
        }
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        if (!StringUtils.isEmpty(accountBankRequestModel.getAccountHolder()) && accountBankRequestModel.getAccountHolder().length() != 0){
            accountBank.setAccountHolder(accountBankRequestModel.getAccountHolder());
        }
        if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankName()) && accountBankRequestModel.getAccountBankName().length() != 0){
            accountBank.setAccountBankName(accountBankRequestModel.getAccountBankName());
        }
        if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankNo()) && accountBankRequestModel.getAccountBankNo().length() != 0){
            accountBank.setAccountBankNo(accountBankRequestModel.getAccountBankNo());
        }
        accountBank.setCreateTime(new Date());
        int insert = accountBankMapper.insert(accountBank);
        if (1 != insert){
            return "银行卡信息保存失败";
        }
        return "success";
    }

    public AccountBankRequestModel getUserAccountBankInfo (){
        AccountBankRequestModel accountBankRequestModel = new AccountBankRequestModel();
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        AccountBank accountBankInfo = accountBankMapper.selectOne(accountBank);
        if (!Objects.isNull(accountBankInfo)){
            accountBankRequestModel.setId(accountBankInfo.getId());
            if (!StringUtils.isEmpty(accountBankInfo.getAccountBankName()) && accountBankInfo.getAccountBankName().length() != 0){
                accountBankRequestModel.setAccountBankName(accountBankInfo.getAccountBankName());
            }
            if (!StringUtils.isEmpty(accountBankInfo.getAccountBankNo()) && accountBankInfo.getAccountBankNo().length() != 0){
                accountBankRequestModel.setAccountBankNo(accountBankInfo.getAccountBankNo());
            }
            if (!StringUtils.isEmpty(accountBankInfo.getAccountHolder()) && accountBankInfo.getAccountHolder().length() != 0){
                accountBankRequestModel.setAccountHolder(accountBankInfo.getAccountHolder());
            }
        }
        return accountBankRequestModel;
    }

    private Boolean isSaveAccountBankInfo (Integer userId){
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        int i = accountBankMapper.selectCount(accountBank);
        if (i > 0){
            return true;
        }
        return false;
    }

    private Integer getAccountBankId (Integer userId){
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        AccountBank accountBankInfo = accountBankMapper.selectOne(accountBank);
        if (!Objects.isNull(accountBankInfo)){
            return accountBankInfo.getId();
        }
        return null;
    }
}
