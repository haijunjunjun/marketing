package com.example.demo.dal.mapper;

import com.example.demo.dal.model.CashDetail;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CashDetailMapper extends MyMapper<CashDetail> {

    List<CashDetail> getCashDetailListInfo(@Param("userId")Integer userId);
}