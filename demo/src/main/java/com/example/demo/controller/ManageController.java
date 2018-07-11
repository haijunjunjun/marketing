package com.example.demo.controller;

import com.example.demo.model.GoldBeansCheck;
import com.example.demo.model.SaleList;
import com.example.demo.service.ManageService;
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
public class ManageController {

    @Autowired
    private ManageService manageService;

    @RequestMapping(value = "/marketing/sale/list", method = RequestMethod.GET)
    public ResponseEntity<List<SaleList>> getSaleList(@Valid @NotNull @RequestParam("id") Integer manageId) {
        return ResponseEntity.ok(manageService.getSaleListInfo(manageId));
    }

    @RequestMapping(value = "/marketing/gold/beans/check/list", method = RequestMethod.GET)
    public ResponseEntity<List<GoldBeansCheck>> getGoldBeansCheckList(@Valid @NotNull @RequestParam("id") Integer manageId) {
        return ResponseEntity.ok(manageService.getGoldBeansCheckList(manageId));
    }

    @RequestMapping(value = "/marketing/gold/beans/check", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> goldBeansCheck(@Valid @NotNull @RequestParam("id") Integer applyId,
                                                      @Valid @NotNull @RequestParam("status") Integer status,
                                                      @Valid @RequestParam("reason") String refuseReason) {
        return ResponseEntity.ok(manageService.goldBeansCheck(applyId, status, refuseReason));
    }
}
