package com.niule.yunjiagong.yunjiagong.controller;

import com.alibaba.fastjson.JSON;
import com.niule.yunjiagong.yunjiagong.config.annotation.Operator;
import com.niule.yunjiagong.yunjiagong.dal.model.ActiveInfo;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import com.niule.yunjiagong.yunjiagong.model.Share;
import com.niule.yunjiagong.yunjiagong.service.ActiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @RequestMapping(value = "/market/local/url", method = RequestMethod.GET)
    public ResponseEntity<String> getLocalUrl(@Valid @Operator CurOperator curOperator,
                                              @Valid @NotNull @RequestParam("activityId") Integer activityId) {
        return ResponseEntity.ok(activeInfoService.getLocal(curOperator.getUserId(), activityId));
    }

    @RequestMapping(value = "/market/share/url", method = RequestMethod.GET)
    public ResponseEntity<Share> getShareUrl(@Valid @Operator CurOperator curOperator,
                                             @Valid @NotNull @RequestParam("activityId") Integer activityId) {
        return ResponseEntity.ok(activeInfoService.getShareUrl(curOperator.getUserId(), activityId));
    }

    @RequestMapping(value = "/market/share/info", method = RequestMethod.GET)
    public ResponseEntity<String> getShareUrl(@Valid @NotNull @RequestParam("callback") String callback,
                                              @Valid @NotNull @RequestParam("activityId") Integer activityId) {
        return ResponseEntity.ok(callback + "(" + JSON.toJSON(activeInfoService.getShareInfo(activityId)) + ")");
    }
}
