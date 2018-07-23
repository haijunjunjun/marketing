package com.niule.yunjiagong.yunjiagong.dal.mymapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author haijun
 * @create 2018 - 07 - 23 - 9:57
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
