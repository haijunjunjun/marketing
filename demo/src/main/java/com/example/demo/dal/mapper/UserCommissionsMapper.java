package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserCommissions;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCommissionsMapper extends MyMapper<UserCommissions> {

    List<UserCommissions> getUserCommissions(@Param("userId") Integer userId);
}