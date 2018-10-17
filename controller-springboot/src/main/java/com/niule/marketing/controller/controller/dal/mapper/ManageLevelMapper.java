package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.ManageLevel;
import com.niule.marketing.controller.controller.dal.model.ManageLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManageLevelMapper {
    int countByExample(ManageLevelExample example);

    int deleteByExample(ManageLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManageLevel record);

    int insertSelective(ManageLevel record);

    List<ManageLevel> selectByExample(ManageLevelExample example);

    ManageLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManageLevel record, @Param("example") ManageLevelExample example);

    int updateByExample(@Param("record") ManageLevel record, @Param("example") ManageLevelExample example);

    int updateByPrimaryKeySelective(ManageLevel record);

    int updateByPrimaryKey(ManageLevel record);
}