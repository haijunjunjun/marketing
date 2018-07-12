package com.example.demo.dal.mapper;

import com.example.demo.dal.model.CustGoldBeans;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface CustGoldBeansMapper extends MyMapper<CustGoldBeans> {

    int updateCustGoldBeans(@Param("id") Integer custId, @Param("num") Integer goldBeansNum);
}