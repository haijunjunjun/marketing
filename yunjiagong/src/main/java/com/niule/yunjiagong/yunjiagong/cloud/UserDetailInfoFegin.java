package com.niule.yunjiagong.yunjiagong.cloud;

import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 18:25
 */
@FeignClient(value = "CLOUD-USERINFO-SERVICE")
public interface UserDetailInfoFegin {

    @RequestMapping(value = "/userInfoController/getPerDetailsInfo",method = RequestMethod.POST)
    DataResponse getUserDetailInfo();
}
