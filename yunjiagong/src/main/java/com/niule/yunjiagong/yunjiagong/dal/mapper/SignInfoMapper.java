package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.SignInfo;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SignInfoMapper extends MyMapper<SignInfo> {

    int saveSignInfo(@Param("userId") Integer userId, @Param("signDate") Date signDate, @Param("duration") Integer duration);

    int updateSignInfo(@Param("userId") Integer userId, @Param("signDate") Date signDate, @Param("updateTime") Date updateTime, @Param("duration") Integer duration);
}