package com.example.demo.controller;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.model.CashDetail;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.model.BankInfoModel;
import com.example.demo.service.UserAccountService;
import com.example.demo.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/marketing/my/cash/detail/list", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<List<CashDetail>>> getMyCashDetailListInfo(@Valid @NotNull @CurrentUser UserInfo userInfo) {
        return ResponseEntity.ok(userAccountService.getMyCashDetail(userInfo.getId()));
    }

    @RequestMapping(value = "/marketing/my/cash/apply", method = RequestMethod.POST)
    public ResponseEntity<String> cashApply(@Valid @NotNull @CurrentUser UserInfo userInfo,
                                            @Valid @NotNull @RequestParam("money") Integer money) {
        return ResponseEntity.ok(userAccountService.cashApply(userInfo.getId(), money));
    }

    @RequestMapping(value = "/marketing/my/check")
    public ResponseEntity<String> cashCheck(@Valid @NotNull @RequestParam("cdid") Integer cashDetailId,
                                            @Valid @NotNull @RequestParam("status") Integer status,
                                            @Valid @NotNull @RequestParam("reason") String refuseReason) {
        return ResponseEntity.ok(userAccountService.cashCheck(cashDetailId, status, refuseReason));
    }

    @RequestMapping(value = "/marketing/my/bank/info", method = RequestMethod.POST)
    public ResponseEntity<BankInfoModel> getBankInfo(@Valid @NotNull @CurrentUser UserInfo userInfo) {
        return ResponseEntity.ok(userAccountService.getBankInfo(userInfo.getId()));
    }
}
