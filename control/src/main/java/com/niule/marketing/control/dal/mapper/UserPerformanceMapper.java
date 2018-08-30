package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.UserPerformance;
import com.niule.marketing.control.dal.model.UserPerformanceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserPerformanceMapper {
    int countByExample(UserPerformanceExample example);

    int deleteByExample(UserPerformanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPerformance record);

    int insertSelective(UserPerformance record);

    List<UserPerformance> selectByExample(UserPerformanceExample example);

    UserPerformance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPerformance record, @Param("example") UserPerformanceExample example);

    int updateByExample(@Param("record") UserPerformance record, @Param("example") UserPerformanceExample example);

    int updateByPrimaryKeySelective(UserPerformance record);

    int updateByPrimaryKey(UserPerformance record);
}