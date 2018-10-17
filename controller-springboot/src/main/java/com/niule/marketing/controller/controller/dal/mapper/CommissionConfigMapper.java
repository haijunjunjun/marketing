package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.CommissionConfig;
import com.niule.marketing.controller.controller.dal.model.CommissionConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommissionConfigMapper {
    int countByExample(CommissionConfigExample example);

    int deleteByExample(CommissionConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommissionConfig record);

    int insertSelective(CommissionConfig record);

    List<CommissionConfig> selectByExample(CommissionConfigExample example);

    CommissionConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommissionConfig record, @Param("example") CommissionConfigExample example);

    int updateByExample(@Param("record") CommissionConfig record, @Param("example") CommissionConfigExample example);

    int updateByPrimaryKeySelective(CommissionConfig record);

    int updateByPrimaryKey(CommissionConfig record);
}