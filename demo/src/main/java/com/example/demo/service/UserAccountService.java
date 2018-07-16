package com.example.demo.service;

import com.example.demo.dal.mapper.AccountBankMapper;
import com.example.demo.dal.mapper.CashDetailMapper;
import com.example.demo.dal.mapper.UserAccountMapper;
import com.example.demo.dal.model.AccountBank;
import com.example.demo.dal.model.CashDetail;
import com.example.demo.dal.model.UserAccount;
import com.example.demo.model.BankInfoModel;
import com.example.demo.model.BindCardModel;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserAccountService {

    private CashDetailMapper cashDetailMapper;
    private AccountBankMapper accountBankMapper;
    private UserAccountMapper userAccountMapper;

    @Autowired
    public UserAccountService(CashDetailMapper cashDetailMapper,
                              AccountBankMapper accountBankMapper,
                              UserAccountMapper userAccountMapper) {
        this.cashDetailMapper = cashDetailMapper;
        this.accountBankMapper = accountBankMapper;
        this.userAccountMapper = userAccountMapper;
    }

    public MessageInfo<List<CashDetail>> getMyCashDetail(Integer userId) {
        MessageInfo<List<CashDetail>> listMessageInfo = new MessageInfo<>();
        if (StringUtils.isEmpty(userId.toString()) || userId <= 0) {
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

    public String cashApply(Integer userId, Integer money) {
        if (StringUtils.isEmpty(userId.toString()) || userId <= 0) {
            log.info("用户id 参数异常!");
            throw new BizRuntimeException("用户id参数异常!");
        }
        if (StringUtils.isEmpty(money.toString()) || money <= 0) {
            log.info("申请的金额必须大于0");
            return "申请的金额必须大于0";
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        UserAccount userAccountInfo = userAccountMapper.selectOne(userAccount);
        if (Objects.isNull(userAccountInfo)) {
            log.info("数据查询异常!");
            throw new BizRuntimeException("数据查询异常!");
        }
        if (money > userAccountInfo.getBalance()) {
            log.info("取现金额不能大于可用余额!");
            return "取现金额不能大于可用余额!";
        }
        CashDetail cashDetail = new CashDetail();
        cashDetail.setUserId(userId);
        cashDetail.setCash(money);
        cashDetail.setCheckStatus(0);
        cashDetail.setCreateTime(new Date());
        int i = cashDetailMapper.insert(cashDetail);
        if (1 != i) {
            log.info("数据信息更新异常!");
            throw new BizRuntimeException("数据更新异常!");
        }
        return "您的提现申请已经成功，请等待后台审核，审核完成会显示在余额列表里边!";
    }

    // 提现审核
    public String cashCheck(Integer cashDetailId, Integer status, String refuseReason) {
        if (StringUtils.isEmpty(cashDetailId.toString()) || cashDetailId <= 0) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常!");
        }
        CashDetail cashDetail = new CashDetail();
        cashDetail.setId(cashDetailId);
        if (status == 1) {
            cashDetail.setCheckStatus(status);
            cashDetail.setModifyTime(new Date());

            //更新用户账户余额
            CashDetail cashDetailV1 = new CashDetail();
            cashDetail.setId(cashDetailId);
            CashDetail cashDetailInfo = cashDetailMapper.selectOne(cashDetailV1);
            if (Objects.isNull(cashDetailInfo)) {
                log.info("数据信息查询异常!");
                throw new BizRuntimeException("数据信息查询异常!");
            }
            int info = userAccountMapper.updateUserAccount(cashDetailInfo.getUserId(), -cashDetailInfo.getCash());
            if (1 != info) {
                log.info("数据信息更新异常!");
                throw new BizRuntimeException("数据信息更新异常!");
            }
        } else {
            cashDetail.setCheckStatus(status);
            cashDetail.setModifyTime(new Date());
            cashDetail.setRefuseReason(refuseReason);
        }
        int i = cashDetailMapper.updateByPrimaryKeySelective(cashDetail);
        if (1 != i) {
            log.info("数据信息更新异常！");
            throw new BizRuntimeException("数据信息更新异常！");
        }
        return "success";
    }

    public BankInfoModel getBankInfo(Integer userId) {
        BankInfoModel bankInfoModel = new BankInfoModel();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("参数信息有误!");
            throw new BizRuntimeException("参数信息有误!");
        }
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        AccountBank accountBankInfo = accountBankMapper.selectOne(accountBank);
        if (Objects.isNull(accountBankInfo)) {
            log.info("用户银行信息查询异常!");
            throw new BizRuntimeException("用户银行信息查询异常！");
        }
        bankInfoModel.setAccountHolder(accountBankInfo.getAccountHolder());
        bankInfoModel.setAccountBankName(accountBankInfo.getAccountBankName());
        bankInfoModel.setAccountBankNo(accountBankInfo.getBankNo());
        return bankInfoModel;
    }

    public MessageInfo bindCard(Integer userId, BindCardModel bindCardModel) {
        MessageInfo messageInfo = new MessageInfo();
        if (Objects.isNull(bindCardModel)) {
            log.info("请输入绑卡信息!");
            messageInfo.setContent("请输入绑卡信息!");
            return messageInfo;
        }
        if (StringUtils.isEmpty(bindCardModel.getAccountBankNo())) {
            log.info("卡号不能为空!");
            messageInfo.setContent("卡号不能为空!");
            return messageInfo;
        }
        if (StringUtils.isEmpty(bindCardModel.getAccountHolder())) {
            log.info("持卡人不能为空!");
            messageInfo.setContent("持卡人不能为空!");
            return messageInfo;
        }
        if (StringUtils.isEmpty(bindCardModel.getAccountBankName())) {
            log.info("开户银行不能为空!");
            messageInfo.setContent("开户银行不能为空!");
            return messageInfo;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        UserAccount userAccountInfo = userAccountMapper.selectOne(userAccount);
        UserAccount userAccountV1 = new UserAccount();
        return null;
    }
}
