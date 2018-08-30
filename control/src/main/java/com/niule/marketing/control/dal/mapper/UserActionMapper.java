package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.UserAction;
import com.niule.marketing.control.dal.model.UserActionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserActionMapper {
    int countByExample(UserActionExample example);

    int deleteByExample(UserActionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAction record);

    int insertSelective(UserAction record);

    List<UserAction> selectByExample(UserActionExample example);

    UserAction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAction record, @Param("example") UserActionExample example);

    int updateByExample(@Param("record") UserAction record, @Param("example") UserActionExample example);

    int updateByPrimaryKeySelective(UserAction record);

    int updateByPrimaryKey(UserAction record);
}