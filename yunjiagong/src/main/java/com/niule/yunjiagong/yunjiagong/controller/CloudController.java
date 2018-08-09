package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.cloud.UserInfoFegin;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 15:32
 */
@RestController
public class CloudController {

    @Autowired
    private UserInfoFegin userInfoFegin;

    @RequestMapping(value = "/user/info", method = RequestMethod.POST)
    public DataResponse<UserBaseInfo> getLoginStatus() {
        DataResponse loginStatus = userInfoFegin.getLoginStatus();
        return loginStatus;
    }

    @RequestMapping(value = "/user/reputation", method = RequestMethod.POST)
    public DataResponse<UserBaseInfo> getReputationStatus() {
        return userInfoFegin.getReputationStatus();
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> getResult() {
        return ResponseEntity.ok(userInfoFegin.getResult());
    }
}
