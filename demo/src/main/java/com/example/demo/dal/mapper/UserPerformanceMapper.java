package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserPerformance;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPerformanceMapper extends MyMapper<UserPerformance> {

    Double getPerformance(@Param("userId") Integer userId, @Param("dt1") String dt1, @Param("dt2") String dt2);

    List<UserPerformance> getUserPerformanceList(@Param("userId") Integer userId, @Param("dt1") String dt1, @Param("dt2") String dt2);

    List<UserPerformance> getUserPerformanceListV1(@Param("userId") Integer userId, @Param("dt") String dt);
}