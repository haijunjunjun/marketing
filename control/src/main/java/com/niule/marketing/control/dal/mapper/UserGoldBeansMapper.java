package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.UserGoldBeans;
import com.niule.marketing.control.dal.model.UserGoldBeansExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserGoldBeansMapper {
    int countByExample(UserGoldBeansExample example);

    int deleteByExample(UserGoldBeansExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserGoldBeans record);

    int insertSelective(UserGoldBeans record);

    List<UserGoldBeans> selectByExample(UserGoldBeansExample example);

    UserGoldBeans selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserGoldBeans record, @Param("example") UserGoldBeansExample example);

    int updateByExample(@Param("record") UserGoldBeans record, @Param("example") UserGoldBeansExample example);

    int updateByPrimaryKeySelective(UserGoldBeans record);

    int updateByPrimaryKey(UserGoldBeans record);
}