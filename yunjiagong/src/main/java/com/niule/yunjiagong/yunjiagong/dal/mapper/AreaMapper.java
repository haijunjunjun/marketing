package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.Area;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper extends MyMapper<Area> {

    List<Area> getArea(@Param("cityId") Integer cityId);

    Integer getAreaByCityIds(@Param("cityIds") List<Integer> cityIds, @Param("name") String name);

    Integer getAreaByCityId(@Param("cityId") Integer cityId, @Param("name") String name);
}