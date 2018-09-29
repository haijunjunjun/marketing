package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.cloud.UserDetailInfoFegin;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 18:29
 */
@RestController
public class TestController {

    @Autowired
    private UserDetailInfoFegin userDetailInfoFegin;

    @RequestMapping(value = "/test/user/detail",method = RequestMethod.POST)
    public DataResponse getUserDetailInfo (){
        DataResponse userDetailInfo = userDetailInfoFegin.getUserDetailInfo();
        return userDetailInfo;
    }
}
