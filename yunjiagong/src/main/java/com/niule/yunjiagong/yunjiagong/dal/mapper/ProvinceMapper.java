package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;

import java.util.List;

public interface ProvinceMapper extends MyMapper<Province> {

    List<Province> getProvince();
}