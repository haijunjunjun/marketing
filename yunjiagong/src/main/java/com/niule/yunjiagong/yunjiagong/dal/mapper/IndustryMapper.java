package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.Industry;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;

import java.util.List;

public interface IndustryMapper extends MyMapper<Industry> {

    List<Industry> getIndustryInfo();
}