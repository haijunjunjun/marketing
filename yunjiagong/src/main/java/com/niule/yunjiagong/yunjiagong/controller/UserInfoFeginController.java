package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.cloud.SystemPayRequest;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserDetailInfo;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserIdModel;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserGoldBeansFeginService;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 08 - 08 - 10:35
 */
@RestController
public class UserInfoFeginController {

    @Autowired
    private UserInfoFeginService userInfoFeginService;
    @Autowired
    private UserGoldBeansFeginService userGoldBeansFeginService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public DataResponse<UserBaseInfo> getUserBaseInfo() {
        DataResponse<UserBaseInfo> operator = userInfoFeginService.getOperator();
        return operator;
    }

    @RequestMapping(value = "/user/gold", method = RequestMethod.POST)
    public DataResponse updateGold() {
        return userGoldBeansFeginService.updateUserGoldBeans(new SystemPayRequest());
    }

    @RequestMapping(value = "/user/detail/info", method = RequestMethod.POST)
    public DataResponse<UserDetailInfo> getUserDetailInfo() {
        return userInfoFeginService.getUserDetailInfo();
    }

}
