package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.model.ActionModel;
import com.example.demo.model.CurOperator;
import com.example.demo.model.CustDetailModel;
import com.example.demo.model.CustModel;
import com.example.demo.service.CustDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 17:10
 */
@RestController
public class CustDetailInfoController {

    @Autowired
    private CustDetailInfoService custDetailInfoService;

    @RequestMapping(value = "/marketing/cust/detail/info")
    public ResponseEntity<CustDetailModel> getCustDetailInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return ResponseEntity.ok(custDetailInfoService.getCustDetailInfo(custModel.getCustId()));
    }

    @RequestMapping(value = "/marketing/insert/user/action", method = RequestMethod.POST)
    public ResponseEntity<String> insertAction(@Valid @NotNull @Operator CurOperator curOperator,
                                               @Valid @NotNull @RequestBody(required = true) ActionModel actionModel) {
        return ResponseEntity.ok(custDetailInfoService.insertAction(curOperator.getId(), actionModel.getCustId(), actionModel.getActionType(), actionModel.getMark()));
    }
}
