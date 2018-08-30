package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.GoldBeansApply;
import com.niule.marketing.control.dal.model.GoldBeansApplyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoldBeansApplyMapper {
    int countByExample(GoldBeansApplyExample example);

    int deleteByExample(GoldBeansApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoldBeansApply record);

    int insertSelective(GoldBeansApply record);

    List<GoldBeansApply> selectByExample(GoldBeansApplyExample example);

    GoldBeansApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoldBeansApply record, @Param("example") GoldBeansApplyExample example);

    int updateByExample(@Param("record") GoldBeansApply record, @Param("example") GoldBeansApplyExample example);

    int updateByPrimaryKeySelective(GoldBeansApply record);

    int updateByPrimaryKey(GoldBeansApply record);
}