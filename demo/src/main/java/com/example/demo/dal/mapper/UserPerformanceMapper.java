package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserPerformance;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserPerformanceMapper extends MyMapper<UserPerformance> {

    Integer getPerformance(@Param("userId") Integer userId, @Param("dt1") String dt1, @Param("dt2") String dt2);
}