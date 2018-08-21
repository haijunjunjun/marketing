package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserGoldBeans;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserGoldBeansMapper extends MyMapper<UserGoldBeans> {

    void updateGoldBeansNum(@Param("num") Integer goldBeansNum, @Param("id") Integer userId, @Param("now")Date dates);
}