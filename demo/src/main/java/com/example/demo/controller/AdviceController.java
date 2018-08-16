package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.model.AdviceModel;
import com.example.demo.model.CurOperator;
import com.example.demo.service.AdviceService;
import com.example.demo.util.MessageInfoV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @RequestMapping(value = "/marketing/advice/resp", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> commitAdvice(@Valid @NotNull @Operator CurOperator curOperator,
                                                      @Valid @NotNull @RequestBody(required = true) AdviceModel adviceModel) {
        return ResponseEntity.ok(adviceService.adviceResp(curOperator.getId(), adviceModel.getAdvice()));
    }
}
