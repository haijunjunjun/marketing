package com.niule.marketing.control.myMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author haijun
 * @create 2018 - 08 - 17 - 13:37
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
