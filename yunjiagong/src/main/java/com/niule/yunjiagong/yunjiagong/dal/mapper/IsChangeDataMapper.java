package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.IsChangeData;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface IsChangeDataMapper extends MyMapper<IsChangeData> {

    Integer updateChangeData(@Param("name") String name);
}