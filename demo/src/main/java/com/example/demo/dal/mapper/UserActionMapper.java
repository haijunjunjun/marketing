package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserAction;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserActionMapper extends MyMapper<UserAction> {

    List<UserAction> getUserActionListInfo (@Param("userId") Integer userId,@Param("custId") Integer custId);
}