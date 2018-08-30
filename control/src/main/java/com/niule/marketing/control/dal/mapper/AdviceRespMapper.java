package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.AdviceResp;
import com.niule.marketing.control.dal.model.AdviceRespExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdviceRespMapper {
    int countByExample(AdviceRespExample example);

    int deleteByExample(AdviceRespExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdviceResp record);

    int insertSelective(AdviceResp record);

    List<AdviceResp> selectByExample(AdviceRespExample example);

    AdviceResp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdviceResp record, @Param("example") AdviceRespExample example);

    int updateByExample(@Param("record") AdviceResp record, @Param("example") AdviceRespExample example);

    int updateByPrimaryKeySelective(AdviceResp record);

    int updateByPrimaryKey(AdviceResp record);
}