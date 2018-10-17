package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.ManageMarketRelate;
import com.niule.marketing.controller.controller.dal.model.ManageMarketRelateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManageMarketRelateMapper {
    int countByExample(ManageMarketRelateExample example);

    int deleteByExample(ManageMarketRelateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManageMarketRelate record);

    int insertSelective(ManageMarketRelate record);

    List<ManageMarketRelate> selectByExample(ManageMarketRelateExample example);

    ManageMarketRelate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManageMarketRelate record, @Param("example") ManageMarketRelateExample example);

    int updateByExample(@Param("record") ManageMarketRelate record, @Param("example") ManageMarketRelateExample example);

    int updateByPrimaryKeySelective(ManageMarketRelate record);

    int updateByPrimaryKey(ManageMarketRelate record);
}