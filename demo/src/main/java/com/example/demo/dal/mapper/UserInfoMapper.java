package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserInfo;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends MyMapper<UserInfo> {

    Integer validNew(@Param("userId") Integer userId, @Param("endDt") String endDt, @Param("now") String now);
}