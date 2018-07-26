package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.config.annotation.Operator;
import com.niule.yunjiagong.yunjiagong.model.ComplaintModel;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import com.niule.yunjiagong.yunjiagong.service.ComplaintService;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 16:18
 */
@Controller
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/user/complaint", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> complaint(@Valid @NotNull @Operator CurOperator curOperator,
                                                 @Valid @NotNull @RequestBody(required = true) ComplaintModel complaintModel) {
        return ResponseEntity.ok(complaintService.doComplaint(curOperator.getUserId(), complaintModel));
    }
}
