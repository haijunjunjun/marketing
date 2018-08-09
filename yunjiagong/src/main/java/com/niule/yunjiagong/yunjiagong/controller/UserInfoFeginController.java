package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 08 - 08 - 10:35
 */
@RestController
public class UserInfoFeginController {

    @Autowired
    private UserInfoFeginService userInfoFeginService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public DataResponse<UserBaseInfo> getUserBaseInfo() {
        DataResponse<UserBaseInfo> operator = userInfoFeginService.getOperator();
        return operator;
    }
}
