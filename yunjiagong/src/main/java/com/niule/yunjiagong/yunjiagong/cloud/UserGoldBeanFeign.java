package com.niule.yunjiagong.yunjiagong.cloud;

import com.niule.yunjiagong.yunjiagong.model.cloud.SystemPayRequest;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author haijun
 * @create 2018 - 08 - 30 - 10:57
 */
@FeignClient("CLOUD-ORDERINFO-SERVICE")
public interface UserGoldBeanFeign {

    @RequestMapping(value = "/payController/systemPay",method = RequestMethod.POST)
    DataResponse systemPay(@RequestBody SystemPayRequest request);
}
