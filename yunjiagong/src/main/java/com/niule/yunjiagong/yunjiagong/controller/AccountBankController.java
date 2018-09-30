package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.AccountBankRequestModel;
import com.niule.yunjiagong.yunjiagong.model.CashModel;
import com.niule.yunjiagong.yunjiagong.service.AccountBankService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 16:43
 */
@RestController
public class AccountBankController {
    @Autowired
    private AccountBankService accountBankService;

    @Description("保存银行卡信息")
    @RequestMapping(value = "/user/account/bank/save", method = RequestMethod.POST)
    public DataResponse saveUserAccountBankInfo(@Valid @NotNull @RequestBody(required = true) AccountBankRequestModel accountBankRequestModel) {
        return DataResponse.success(accountBankService.saveAccountBankInfo(accountBankRequestModel));
    }

    @Description("银行卡信息查看")
    @RequestMapping(value = "/user/account/bank/view", method = RequestMethod.POST)
    public DataResponse viewUserAccountBankInfo() {
        return DataResponse.success(accountBankService.getUserAccountBankInfo());
    }

    @Description("用户提现申请所需银行卡信息")
    @RequestMapping(value = "/user/account/cash/bank/info", method = RequestMethod.POST)
    public DataResponse userAccountCashBankInfo() {
        return DataResponse.success(accountBankService.getCashBankInfo());
    }

    @Description("用户提现申请")
    @RequestMapping(value = "/user/account/cash", method = RequestMethod.POST)
    public DataResponse userAccountCash(@Valid @NotNull @RequestBody(required = true) CashModel cashModel) {
        return DataResponse.success(accountBankService.cash(cashModel));
    }
}
