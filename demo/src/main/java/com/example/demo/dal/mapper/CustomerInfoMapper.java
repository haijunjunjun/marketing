package com.example.demo.dal.mapper;

import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerInfoMapper extends MyMapper<CustomerInfo> {

    Integer getMonthNum(@Param("userId") Integer userId, @Param("dtNum") String dtNum);

    Integer getWeekNum(@Param("userId") Integer userId, @Param("dt1") String begin, @Param("dt2") String end);

    Integer getHasComunication(@Param("userId") Integer userId);

    Integer getHasInterest(@Param("userId") Integer userId);

    Integer getHasCompact(@Param("userId") Integer userId);

    List<CustomerInfo> getCustomerInfoList(@Param("userId") Integer userId, @Param("status") Integer status);

}