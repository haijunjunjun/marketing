package com.example.demo.controller;

import com.example.demo.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @RequestMapping(value = "/marketing/advice/resp", method = RequestMethod.POST)
    public ResponseEntity<String> commitAdvice(@Valid @NotNull @RequestParam("id") Integer userId,
                                               @Valid @NotNull @RequestBody(required = true) String advice) {
        return ResponseEntity.ok(adviceService.adviceResp(userId, advice));
    }
}
