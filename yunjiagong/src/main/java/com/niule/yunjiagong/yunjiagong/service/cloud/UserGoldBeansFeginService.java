package com.niule.yunjiagong.yunjiagong.service.cloud;

import com.niule.yunjiagong.yunjiagong.cloud.UserGoldBeanFeign;
import com.niule.yunjiagong.yunjiagong.model.cloud.SystemPayRequest;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haijun
 * @create 2018 - 08 - 30 - 10:53
 */
@Service
public class UserGoldBeansFeginService {

    @Autowired
    private UserGoldBeanFeign userGoldBeanFeign;

    public DataResponse updateUserGoldBeans (SystemPayRequest systemPayRequest){
        return userGoldBeanFeign.systemPay(systemPayRequest);
    }
}
