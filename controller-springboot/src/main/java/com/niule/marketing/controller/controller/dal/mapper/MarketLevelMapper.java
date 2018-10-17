package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.MarketLevel;
import com.niule.marketing.controller.controller.dal.model.MarketLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketLevelMapper {
    int countByExample(MarketLevelExample example);

    int deleteByExample(MarketLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MarketLevel record);

    int insertSelective(MarketLevel record);

    List<MarketLevel> selectByExample(MarketLevelExample example);

    MarketLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MarketLevel record, @Param("example") MarketLevelExample example);

    int updateByExample(@Param("record") MarketLevel record, @Param("example") MarketLevelExample example);

    int updateByPrimaryKeySelective(MarketLevel record);

    int updateByPrimaryKey(MarketLevel record);
}