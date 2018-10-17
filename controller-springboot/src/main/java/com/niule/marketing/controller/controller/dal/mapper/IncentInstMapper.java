package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.IncentInst;
import com.niule.marketing.controller.controller.dal.model.IncentInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncentInstMapper {
    int countByExample(IncentInstExample example);

    int deleteByExample(IncentInstExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncentInst record);

    int insertSelective(IncentInst record);

    List<IncentInst> selectByExample(IncentInstExample example);

    IncentInst selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncentInst record, @Param("example") IncentInstExample example);

    int updateByExample(@Param("record") IncentInst record, @Param("example") IncentInstExample example);

    int updateByPrimaryKeySelective(IncentInst record);

    int updateByPrimaryKey(IncentInst record);
}