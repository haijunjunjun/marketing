package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.ActivityNotice;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityNoticeMapper extends MyMapper<ActivityNotice> {

    List<ActivityNotice> getActivityNoticeInfo(@Param("standard") Integer standard);
}