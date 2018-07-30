package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.dal.model.ActiveInfo;
import com.niule.yunjiagong.yunjiagong.service.ActiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 16:41
 */
@Controller
public class ActiveInfoController {

    @Autowired
    private ActiveInfoService activeInfoService;

    @RequestMapping(value = "/market/active/info", method = RequestMethod.POST)
    public ResponseEntity<List<ActiveInfo>> getActiveInfoList() {
        return ResponseEntity.ok(activeInfoService.getActiveInfo());
    }


}
