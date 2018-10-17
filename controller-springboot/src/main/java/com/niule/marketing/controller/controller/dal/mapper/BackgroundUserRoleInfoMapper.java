package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.BackgroundUserRoleInfo;
import com.niule.marketing.controller.controller.dal.model.BackgroundUserRoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackgroundUserRoleInfoMapper {
    int countByExample(BackgroundUserRoleInfoExample example);

    int deleteByExample(BackgroundUserRoleInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BackgroundUserRoleInfo record);

    int insertSelective(BackgroundUserRoleInfo record);

    List<BackgroundUserRoleInfo> selectByExample(BackgroundUserRoleInfoExample example);

    BackgroundUserRoleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BackgroundUserRoleInfo record, @Param("example") BackgroundUserRoleInfoExample example);

    int updateByExample(@Param("record") BackgroundUserRoleInfo record, @Param("example") BackgroundUserRoleInfoExample example);

    int updateByPrimaryKeySelective(BackgroundUserRoleInfo record);

    int updateByPrimaryKey(BackgroundUserRoleInfo record);
}