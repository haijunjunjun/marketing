package com.example.demo.dal.mapper;

import com.example.demo.dal.model.GoldBeansApply;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoldBeansApplyMapper extends MyMapper<GoldBeansApply> {

    List<GoldBeansApply> getGoldBeansApplyInfo(@Param("userId") Integer userId);
}