package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.dal.model.CashDetail;
import com.example.demo.model.BankInfoModel;
import com.example.demo.model.BindCardModel;
import com.example.demo.model.CurOperator;
import com.example.demo.service.UserAccountService;
import com.example.demo.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/marketing/my/cash/detail/list", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<List<CashDetail>>> getMyCashDetailListInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(userAccountService.getMyCashDetail(curOperator.getId()));
    }

    @RequestMapping(value = "/marketing/my/cash/apply", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> cashApply(@Valid @NotNull @Operator CurOperator curOperator,
                                                 @Valid @NotNull @RequestParam("money") double money) {
        return ResponseEntity.ok(userAccountService.cashApply(curOperator.getId(), money));
    }

    @RequestMapping(value = "/marketing/my/check")
    public ResponseEntity<String> cashCheck(@Valid @NotNull @RequestParam("cdid") Integer cashDetailId,
                                            @Valid @NotNull @RequestParam("status") Integer status,
                                            @Valid @NotNull @RequestParam("reason") String refuseReason) {
        return ResponseEntity.ok(userAccountService.cashCheck(cashDetailId, status, refuseReason));
    }

    @Description("获取银行卡信息")
    @RequestMapping(value = "/marketing/my/bank/info", method = RequestMethod.POST)
    public ResponseEntity<BankInfoModel> getBankInfo(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(userAccountService.getBankInfo(curOperator.getId()));
    }

    @Description("绑定银行卡")
    @RequestMapping(value = "/marketing/my/bank/bind", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> bindCard(@Valid @NotNull @Operator CurOperator curOperator,
                                                @Valid @RequestBody(required = true) BindCardModel bindCardModel) {
        return ResponseEntity.ok(userAccountService.bindCard(curOperator.getId(), bindCardModel));
    }

    @Description("获取可用余额")
    @RequestMapping(value = "/marketing/available/money", method = RequestMethod.GET)
    public ResponseEntity<Double> getAvailableMoney(@Valid @NotNull @Operator CurOperator curOperator) {
        return ResponseEntity.ok(userAccountService.getAvailavleMoney(curOperator.getId()));
    }
}
