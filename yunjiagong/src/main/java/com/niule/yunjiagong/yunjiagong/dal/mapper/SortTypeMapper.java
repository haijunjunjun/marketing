package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.SortType;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;

import java.util.List;

public interface SortTypeMapper extends MyMapper<SortType> {

    List<SortType> getSortType();
}