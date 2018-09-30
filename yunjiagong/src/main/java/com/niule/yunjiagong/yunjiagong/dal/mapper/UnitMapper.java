package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.Unit;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;

import java.util.List;

public interface UnitMapper extends MyMapper<Unit> {

    List<Unit> getUnitInfo();
}