package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.SumArrange;
import com.niule.marketing.control.dal.model.SumArrangeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SumArrangeMapper {
    int countByExample(SumArrangeExample example);

    int deleteByExample(SumArrangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SumArrange record);

    int insertSelective(SumArrange record);

    List<SumArrange> selectByExample(SumArrangeExample example);

    SumArrange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SumArrange record, @Param("example") SumArrangeExample example);

    int updateByExample(@Param("record") SumArrange record, @Param("example") SumArrangeExample example);

    int updateByPrimaryKeySelective(SumArrange record);

    int updateByPrimaryKey(SumArrange record);
}