package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.BackgroundUserAuthInfo;
import com.niule.marketing.controller.controller.dal.model.BackgroundUserAuthInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackgroundUserAuthInfoMapper {
    int countByExample(BackgroundUserAuthInfoExample example);

    int deleteByExample(BackgroundUserAuthInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BackgroundUserAuthInfo record);

    int insertSelective(BackgroundUserAuthInfo record);

    List<BackgroundUserAuthInfo> selectByExample(BackgroundUserAuthInfoExample example);

    BackgroundUserAuthInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BackgroundUserAuthInfo record, @Param("example") BackgroundUserAuthInfoExample example);

    int updateByExample(@Param("record") BackgroundUserAuthInfo record, @Param("example") BackgroundUserAuthInfoExample example);

    int updateByPrimaryKeySelective(BackgroundUserAuthInfo record);

    int updateByPrimaryKey(BackgroundUserAuthInfo record);
}