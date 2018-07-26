package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.config.annotation.Operator;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import com.niule.yunjiagong.yunjiagong.service.SignService;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 9:19
 */
@Controller
public class SignController {

    @Autowired
    private SignService signService;

    @RequestMapping(value = "/user/sign", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> doSign(@Valid @NotNull @Operator CurOperator curOperator,
                                              @Valid @NotNull @RequestParam("signDate") String signDate) throws ParseException {
        return ResponseEntity.ok(signService.doSign(curOperator.getUserId(), signDate));
    }

    @RequestMapping(value = "/user/check/sign", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkSign(@Valid @NotNull @Operator CurOperator curOperator,
                                             @Valid @NotNull @RequestParam("signDate") String signDate) throws ParseException {
        return ResponseEntity.ok(signService.checkSign(curOperator.getUserId(), signDate));
    }
}
