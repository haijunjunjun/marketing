package com.niule.yunjiagong.yunjiagong.controller;

import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.config.annotation.Operator;
import com.niule.yunjiagong.yunjiagong.dal.model.Subscribe;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import com.niule.yunjiagong.yunjiagong.service.SubscribeService;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 9:18
 */
@Description("订阅信息的增删查")
@Controller
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @RequestMapping(value = "/market/get/subscribe", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Subscribe>> getSubscribe(@Valid @NotNull @Operator CurOperator curOperator,
                                                            @Valid @RequestParam("pageNum") Integer pageNum,
                                                            @Valid @RequestParam("pageSize") Integer pageSize) {
        return ResponseEntity.ok(subscribeService.getSubscribe(curOperator.getUserId(), pageNum, pageSize));
    }

    @RequestMapping(value = "/market/add/subscribe", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> addSubscribe(@Valid @NotNull @Operator CurOperator curOperator,
                                                    @Valid @NotNull @RequestParam("mobile") String mobile,
                                                    @Valid @NotNull @RequestParam("subscribeName") String subscribeName) {
        return ResponseEntity.ok(subscribeService.addSubscribe(curOperator.getUserId(), mobile, subscribeName));
    }

    @RequestMapping(value = "/market/delete/subscribe", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteSubscribe(@Valid @NotNull @Operator CurOperator curOperator,
                                                   @Valid @NotNull @RequestParam("subscribeId") Integer subscribeId) {
        return ResponseEntity.ok(subscribeService.deleteSubscribe(subscribeId, curOperator.getUserId()));
    }
}
