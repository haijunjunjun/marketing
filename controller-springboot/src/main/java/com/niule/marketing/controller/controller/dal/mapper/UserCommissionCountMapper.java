package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.UserCommissionCount;
import com.niule.marketing.controller.controller.dal.model.UserCommissionCountExample;
import java.util.List;

import com.niule.marketing.controller.controller.model.MarketUserCommissionRequestModel;
import org.apache.ibatis.annotations.Param;

public interface UserCommissionCountMapper {
    int countByExample(UserCommissionCountExample example);

    int deleteByExample(UserCommissionCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCommissionCount record);

    int insertSelective(UserCommissionCount record);

    List<UserCommissionCount> selectByExample(UserCommissionCountExample example);

    UserCommissionCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCommissionCount record, @Param("example") UserCommissionCountExample example);

    int updateByExample(@Param("record") UserCommissionCount record, @Param("example") UserCommissionCountExample example);

    int updateByPrimaryKeySelective(UserCommissionCount record);

    int updateByPrimaryKey(UserCommissionCount record);

    List<UserCommissionCount> fetchUserCommissionInfo (MarketUserCommissionRequestModel marketUserCommissionRequestModel);
}