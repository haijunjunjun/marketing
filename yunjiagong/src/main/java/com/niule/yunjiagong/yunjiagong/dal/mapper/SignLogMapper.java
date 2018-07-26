package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.SignLog;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SignLogMapper extends MyMapper<SignLog> {

    int saveSignLog(@Param("userId") Integer userId, @Param("beans") String beans, @Param("source") String source, @Param("createTime") Date createTime);
}