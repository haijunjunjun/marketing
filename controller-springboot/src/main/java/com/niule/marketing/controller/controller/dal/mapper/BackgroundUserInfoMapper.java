package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.BackgroundUserInfo;
import com.niule.marketing.controller.controller.dal.model.BackgroundUserInfoExample;
import java.util.List;

import com.niule.marketing.controller.controller.model.BackUserInfoSearchModel;
import org.apache.ibatis.annotations.Param;

public interface BackgroundUserInfoMapper {
    int countByExample(BackgroundUserInfoExample example);

    int deleteByExample(BackgroundUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BackgroundUserInfo record);

    int insertSelective(BackgroundUserInfo record);

    List<BackgroundUserInfo> selectByExample(BackgroundUserInfoExample example);

    BackgroundUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BackgroundUserInfo record, @Param("example") BackgroundUserInfoExample example);

    int updateByExample(@Param("record") BackgroundUserInfo record, @Param("example") BackgroundUserInfoExample example);

    int updateByPrimaryKeySelective(BackgroundUserInfo record);

    int updateByPrimaryKey(BackgroundUserInfo record);

    List<BackgroundUserInfo> searchBackUserInfo (BackUserInfoSearchModel backUserInfoSearchModel);
}