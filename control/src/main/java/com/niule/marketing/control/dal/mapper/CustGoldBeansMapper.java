package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.CustGoldBeans;
import com.niule.marketing.control.dal.model.CustGoldBeansExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CustGoldBeansMapper {
    int countByExample(CustGoldBeansExample example);

    int deleteByExample(CustGoldBeansExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustGoldBeans record);

    int insertSelective(CustGoldBeans record);

    List<CustGoldBeans> selectByExample(CustGoldBeansExample example);

    CustGoldBeans selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustGoldBeans record, @Param("example") CustGoldBeansExample example);

    int updateByExample(@Param("record") CustGoldBeans record, @Param("example") CustGoldBeansExample example);

    int updateByPrimaryKeySelective(CustGoldBeans record);

    int updateByPrimaryKey(CustGoldBeans record);
}