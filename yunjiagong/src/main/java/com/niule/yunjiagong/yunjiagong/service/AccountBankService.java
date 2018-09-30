package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.constants.Enum.CashStatusEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AccountBankMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.CashApplyMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.AccountBank;
import com.niule.yunjiagong.yunjiagong.dal.model.CashApply;
import com.niule.yunjiagong.yunjiagong.model.AccountBankRequestModel;
import com.niule.yunjiagong.yunjiagong.model.BankInfoModel;
import com.niule.yunjiagong.yunjiagong.model.CashModel;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserDetailInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.BankNoUtil;
import com.niule.yunjiagong.yunjiagong.util.MessageInfoV1;
import com.niule.yunjiagong.yunjiagong.util.MessageInfoV2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Autowired
    private CashApplyMapper cashApplyMapper;

    public MessageInfoV1<Integer> saveAccountBankInfo(AccountBankRequestModel accountBankRequestModel) {
        MessageInfoV1<Integer> messageInfoV1 = new MessageInfoV1<>();
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        if (Objects.isNull(userId)) {
            messageInfoV1.setContent("userId 为空");
            return messageInfoV1;
        }
        if (this.isSaveAccountBankInfo(userId)) {
            AccountBank accountBank = new AccountBank();
            accountBank.setId(accountBankRequestModel.getId());
            if (!StringUtils.isEmpty(accountBankRequestModel.getAccountHolder()) && accountBankRequestModel.getAccountHolder().length() != 0) {
                accountBank.setAccountHolder(accountBankRequestModel.getAccountHolder());
            }
            if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankName()) && accountBankRequestModel.getAccountBankName().length() != 0) {
                accountBank.setAccountBankName(accountBankRequestModel.getAccountBankName());
            }
            if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankNo()) && accountBankRequestModel.getAccountBankNo().length() != 0) {
                accountBank.setAccountBankNo(accountBankRequestModel.getAccountBankNo());
            }
            accountBank.setModifyTime(new Date());
            int i = accountBankMapper.updateByPrimaryKeySelective(accountBank);
            if (1 != i) {
                messageInfoV1.setContent("银行卡信息更新失败");
                return messageInfoV1;
            }
            messageInfoV1.setData(accountBank.getId());
            messageInfoV1.setContent("银行卡信息编辑成功");
            return messageInfoV1;
        }
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        if (!StringUtils.isEmpty(accountBankRequestModel.getAccountHolder()) && accountBankRequestModel.getAccountHolder().length() != 0) {
            accountBank.setAccountHolder(accountBankRequestModel.getAccountHolder());
        }
        if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankName()) && accountBankRequestModel.getAccountBankName().length() != 0) {
            accountBank.setAccountBankName(accountBankRequestModel.getAccountBankName());
        }
        if (!StringUtils.isEmpty(accountBankRequestModel.getAccountBankNo()) && accountBankRequestModel.getAccountBankNo().length() != 0) {
            accountBank.setAccountBankNo(accountBankRequestModel.getAccountBankNo());
        }
        accountBank.setCreateTime(new Date());
        int insert = accountBankMapper.insert(accountBank);
        if (1 != insert) {
            messageInfoV1.setContent("银行卡信息保存失败");
            return messageInfoV1;
        }
        messageInfoV1.setData(accountBank.getId());
        messageInfoV1.setContent("银行卡信息编辑成功");
        return messageInfoV1;
    }

    public AccountBankRequestModel getUserAccountBankInfo() {
        AccountBankRequestModel accountBankRequestModel = new AccountBankRequestModel();
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        AccountBank accountBankInfo = accountBankMapper.selectOne(accountBank);
        if (!Objects.isNull(accountBankInfo)) {
            accountBankRequestModel.setId(accountBankInfo.getId());
            if (!StringUtils.isEmpty(accountBankInfo.getAccountBankName()) && accountBankInfo.getAccountBankName().length() != 0) {
                accountBankRequestModel.setAccountBankName(accountBankInfo.getAccountBankName());
            }
            if (!StringUtils.isEmpty(accountBankInfo.getAccountBankNo()) && accountBankInfo.getAccountBankNo().length() != 0) {
                accountBankRequestModel.setAccountBankNo(accountBankInfo.getAccountBankNo());
            }
            if (!StringUtils.isEmpty(accountBankInfo.getAccountHolder()) && accountBankInfo.getAccountHolder().length() != 0) {
                accountBankRequestModel.setAccountHolder(accountBankInfo.getAccountHolder());
            }
        }
        return accountBankRequestModel;
    }

    public BankInfoModel getCashBankInfo (){
        BankInfoModel bankInfoModel = new BankInfoModel();
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        AccountBank accountBankInfo = accountBankMapper.selectOne(accountBank);
        if (!Objects.isNull(accountBankInfo)){
            if (!StringUtils.isEmpty(accountBankInfo.getAccountBankName()) && accountBankInfo.getAccountBankName().length() != 0){
                bankInfoModel.setAccountBankName(accountBankInfo.getAccountBankName());
            }
            if (!StringUtils.isEmpty(accountBankInfo.getAccountBankNo()) && accountBankInfo.getAccountBankNo().length() != 0){
                bankInfoModel.setAccountBankNo(BankNoUtil.hideCardNo(accountBankInfo.getAccountBankNo()));
            }
        }
        return bankInfoModel;
    }

    public MessageInfoV2<String> cash (CashModel cashModel){
        MessageInfoV2<String> messageInfoV2 = new MessageInfoV2<>();
        if (StringUtils.isEmpty(cashModel.getMoney())
                || String.valueOf(cashModel.getMoney()).length() == 0){
            messageInfoV2.setResult("提现金额不能为空");
            return messageInfoV2;
        }
        if (new BigDecimal(cashModel.getMoney()).compareTo(BigDecimal.ZERO) == 0
                || new BigDecimal(cashModel.getMoney()).compareTo(BigDecimal.ZERO) == -1){
            messageInfoV2.setResult("提现金额必须大于0");
            return messageInfoV2;
        }
        UserDetailInfo userDetailInfo = userInfoFeginService.getUserDetailInfo().getData();
        double balanceMoney = userDetailInfo.getBalanceMoney().doubleValue();
//        double balanceMoney = 0.02;
        if (Objects.isNull(balanceMoney)){
            messageInfoV2.setResult("系统信息异常");
            return messageInfoV2;
        }
        if (new BigDecimal(cashModel.getMoney()).compareTo(new BigDecimal(Double.toString(balanceMoney))) == 1){
            messageInfoV2.setResult("提现金额不能大于余额");
            return messageInfoV2;
        }
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        if (Objects.isNull(userId)){
            messageInfoV2.setResult("系统信息异常");
            return messageInfoV2;
        }

        // TODO: 2018/9/30 申请时先更新用户账户余额

        CashApply cashApply = new CashApply();
        cashApply.setUserId(userId);
        cashApply.setCashMoney(Double.parseDouble(cashModel.getMoney()));
        cashApply.setCashStatus(CashStatusEnum.WAIT.getCode());
        cashApply.setCreateTime(new Date());
        int insert = cashApplyMapper.insert(cashApply);
        if (1 != insert){
            messageInfoV2.setResult("申请记录插入失败");
            return messageInfoV2;
        }
        messageInfoV2.setResult("您的申请已经提交，请等待审核");
        return messageInfoV2;
    }

//------------------------------------------------------------------------------------------------------------------------------
    private Boolean isSaveAccountBankInfo(Integer userId) {
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        int i = accountBankMapper.selectCount(accountBank);
        if (i > 0) {
            return true;
        }
        return false;
    }

    private Integer getAccountBankId(Integer userId) {
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        AccountBank accountBankInfo = accountBankMapper.selectOne(accountBank);
        if (!Objects.isNull(accountBankInfo)) {
            return accountBankInfo.getId();
        }
        return null;
    }
}
