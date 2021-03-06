package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.UserCommissions;
import com.niule.marketing.control.dal.model.UserCommissionsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserCommissionsMapper {
    int countByExample(UserCommissionsExample example);

    int deleteByExample(UserCommissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCommissions record);

    int insertSelective(UserCommissions record);

    List<UserCommissions> selectByExample(UserCommissionsExample example);

    UserCommissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCommissions record, @Param("example") UserCommissionsExample example);

    int updateByExample(@Param("record") UserCommissions record, @Param("example") UserCommissionsExample example);

    int updateByPrimaryKeySelective(UserCommissions record);

    int updateByPrimaryKey(UserCommissions record);
}