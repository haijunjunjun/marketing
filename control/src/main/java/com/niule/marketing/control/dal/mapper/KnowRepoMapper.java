package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.KnowRepo;
import com.niule.marketing.control.dal.model.KnowRepoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface KnowRepoMapper {
    int countByExample(KnowRepoExample example);

    int deleteByExample(KnowRepoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KnowRepo record);

    int insertSelective(KnowRepo record);

    List<KnowRepo> selectByExample(KnowRepoExample example);

    KnowRepo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KnowRepo record, @Param("example") KnowRepoExample example);

    int updateByExample(@Param("record") KnowRepo record, @Param("example") KnowRepoExample example);

    int updateByPrimaryKeySelective(KnowRepo record);

    int updateByPrimaryKey(KnowRepo record);
}