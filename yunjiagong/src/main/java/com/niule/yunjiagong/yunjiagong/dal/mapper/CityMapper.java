package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.City;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper extends MyMapper<City> {

    List<City> getCity(@Param("provinceId") Integer provinceId);

    City getCityByName(@Param("name") String name);
}