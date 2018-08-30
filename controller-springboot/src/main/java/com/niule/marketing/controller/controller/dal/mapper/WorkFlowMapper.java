package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.WorkFlow;
import com.niule.marketing.controller.controller.dal.model.WorkFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkFlowMapper {
    int countByExample(WorkFlowExample example);

    int deleteByExample(WorkFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkFlow record);

    int insertSelective(WorkFlow record);

    List<WorkFlow> selectByExample(WorkFlowExample example);

    WorkFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkFlow record, @Param("example") WorkFlowExample example);

    int updateByExample(@Param("record") WorkFlow record, @Param("example") WorkFlowExample example);

    int updateByPrimaryKeySelective(WorkFlow record);

    int updateByPrimaryKey(WorkFlow record);
}