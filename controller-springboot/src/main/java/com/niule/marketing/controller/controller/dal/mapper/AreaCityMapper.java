package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.AreaCity;
import com.niule.marketing.controller.controller.dal.model.AreaCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaCityMapper {
    int countByExample(AreaCityExample example);

    int deleteByExample(AreaCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AreaCity record);

    int insertSelective(AreaCity record);

    List<AreaCity> selectByExample(AreaCityExample example);

    AreaCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AreaCity record, @Param("example") AreaCityExample example);

    int updateByExample(@Param("record") AreaCity record, @Param("example") AreaCityExample example);

    int updateByPrimaryKeySelective(AreaCity record);

    int updateByPrimaryKey(AreaCity record);
}