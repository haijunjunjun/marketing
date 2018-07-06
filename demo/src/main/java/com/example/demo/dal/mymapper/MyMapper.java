package com.example.demo.dal.mymapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by haijun on 2018/7/3.
 */
public interface MyMapper<T> extends Mapper<T> , MySqlMapper<T> {
}
