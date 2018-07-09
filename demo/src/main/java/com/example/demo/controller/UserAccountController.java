package com.example.demo.controller;

import com.example.demo.dal.model.CashDetail;
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
    public ResponseEntity<MessageInfo<List<CashDetail>>> getMyCashDetailListInfo(@Valid @NotNull @RequestParam("id") Integer userId) {
        return ResponseEntity.ok(userAccountService.getMyCashDetail(userId));
    }
}