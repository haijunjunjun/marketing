package com.example.demo.dal.mapper;

import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper extends MyMapper<CustomerInfo> {

    Integer getMonthNum(@Param("userId") Integer userId, @Param("dtNum") String dtNum);

    Integer getWeekNum(@Param("userId") Integer userId, @Param("dt1") String dt1, @Param("dt2") String dt2);
}