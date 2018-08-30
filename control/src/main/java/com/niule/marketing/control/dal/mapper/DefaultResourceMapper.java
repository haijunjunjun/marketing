package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.DefaultResource;
import com.niule.marketing.control.dal.model.DefaultResourceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DefaultResourceMapper {
    int countByExample(DefaultResourceExample example);

    int deleteByExample(DefaultResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DefaultResource record);

    int insertSelective(DefaultResource record);

    List<DefaultResource> selectByExample(DefaultResourceExample example);

    DefaultResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DefaultResource record, @Param("example") DefaultResourceExample example);

    int updateByExample(@Param("record") DefaultResource record, @Param("example") DefaultResourceExample example);

    int updateByPrimaryKeySelective(DefaultResource record);

    int updateByPrimaryKey(DefaultResource record);
}