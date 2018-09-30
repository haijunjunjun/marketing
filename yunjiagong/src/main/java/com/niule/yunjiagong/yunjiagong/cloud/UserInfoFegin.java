package com.niule.yunjiagong.yunjiagong.cloud;

import com.niule.yunjiagong.yunjiagong.model.cloud.UserIdModel;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 15:12
 */
@FeignClient(value = "CLOUD-USERINFO-SERVICE")
//@FeignClient(value = "eureka-server")
public interface UserInfoFegin {

    @RequestMapping(value = "/userInfoController/getUserInfo", method = RequestMethod.POST)
    DataResponse getLoginStatus();

    @RequestMapping(value = "/userInfoController/getUserInfoWithReputation", method = RequestMethod.POST)
    DataResponse getReputationStatus();

    @RequestMapping(value = "/cloud", method = RequestMethod.POST)
    String getResult();

    @RequestMapping(value = "/userInfoController/getPerDetailsInfo",method = RequestMethod.POST)
    DataResponse getUserDetailInfo();
}
