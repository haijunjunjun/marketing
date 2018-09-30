package com.niule.yunjiagong.yunjiagong.service.cloud;

import com.alibaba.fastjson.JSON;
import com.niule.yunjiagong.yunjiagong.cloud.UserInfoFegin;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserDetailInfo;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserIdModel;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haijun
 * @create 2018 - 08 - 08 - 9:49
 */
@Service
public class UserInfoFeginService {

    @Autowired
    private UserInfoFegin userInfoFegin;

    public DataResponse<UserBaseInfo> getOperator() {
        DataResponse<UserBaseInfo> dataResponse = userInfoFegin.getLoginStatus();
        if (dataResponse.getRetCode() != 0) {
            return dataResponse;
        }
        UserBaseInfo userBaseInfo = JSON.parseObject(JSON.toJSONString(dataResponse.getData()), UserBaseInfo.class);
        dataResponse.setData(userBaseInfo);
        return dataResponse;
    }

    public DataResponse<UserDetailInfo> getUserDetailInfo (){
        DataResponse<UserDetailInfo> dataResponse = userInfoFegin.getUserDetailInfo();
        if (dataResponse.getRetCode() != 0) {
            return dataResponse;
        }
        UserDetailInfo userDetailInfo = JSON.parseObject(JSON.toJSONString(dataResponse.getData()), UserDetailInfo.class);
        dataResponse.setData(userDetailInfo);
        return dataResponse;
    }
}
