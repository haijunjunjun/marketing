package com.example.demo.dal.mapper;

import com.example.demo.dal.model.SumArrange;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SumArrangeMapper extends MyMapper<SumArrange> {

    List<SumArrange> getSumArrangeList (@Param("userId") Integer userId);
}