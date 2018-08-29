package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.ConfigTemplate;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigTemplateMapper extends MyMapper<ConfigTemplate> {

    List<Integer> getChangeCountBytypeAndUserstatus(@Param("type") Integer type,@Param("userStatus") Integer userStatus);
}