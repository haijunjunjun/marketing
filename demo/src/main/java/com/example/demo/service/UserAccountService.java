package com.example.demo.service;

import com.example.demo.dal.mapper.AccountBankMapper;
import com.example.demo.dal.mapper.CashDetailMapper;
import com.example.demo.dal.model.AccountBank;
import com.example.demo.dal.model.CashDetail;
import com.example.demo.model.BankInfoModel;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserAccountService {

    private CashDetailMapper cashDetailMapper;
    private AccountBankMapper accountBankMapper;

    @Autowired
    public UserAccountService(CashDetailMapper cashDetailMapper,
                              AccountBankMapper accountBankMapper) {
        this.cashDetailMapper = cashDetailMapper;
        this.accountBankMapper = accountBankMapper;
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

    // TODO: 2018/7/9 余额取现
    public void cash(Integer userId, BigDecimal money) {

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
}
