package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.PerformanceConfigV1;
import com.niule.marketing.control.dal.model.PerformanceConfigV1Example;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PerformanceConfigV1Mapper {
    int countByExample(PerformanceConfigV1Example example);

    int deleteByExample(PerformanceConfigV1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(PerformanceConfigV1 record);

    int insertSelective(PerformanceConfigV1 record);

    List<PerformanceConfigV1> selectByExample(PerformanceConfigV1Example example);

    PerformanceConfigV1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PerformanceConfigV1 record, @Param("example") PerformanceConfigV1Example example);

    int updateByExample(@Param("record") PerformanceConfigV1 record, @Param("example") PerformanceConfigV1Example example);

    int updateByPrimaryKeySelective(PerformanceConfigV1 record);

    int updateByPrimaryKey(PerformanceConfigV1 record);
}