package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.PerformanceConfig;
import com.niule.marketing.control.dal.model.PerformanceConfigExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PerformanceConfigMapper {
    int countByExample(PerformanceConfigExample example);

    int deleteByExample(PerformanceConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PerformanceConfig record);

    int insertSelective(PerformanceConfig record);

    List<PerformanceConfig> selectByExample(PerformanceConfigExample example);

    PerformanceConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PerformanceConfig record, @Param("example") PerformanceConfigExample example);

    int updateByExample(@Param("record") PerformanceConfig record, @Param("example") PerformanceConfigExample example);

    int updateByPrimaryKeySelective(PerformanceConfig record);

    int updateByPrimaryKey(PerformanceConfig record);
}