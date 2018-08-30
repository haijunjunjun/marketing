package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.UserInfo;
import com.niule.marketing.control.myMapper.MyMapper;

public interface UserInfoMapper extends MyMapper<UserInfo> {
    void getInfo();
}