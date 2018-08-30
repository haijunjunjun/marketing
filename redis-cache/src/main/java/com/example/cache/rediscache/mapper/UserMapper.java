package com.example.cache.rediscache.mapper;

import com.example.cache.rediscache.model.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 10:43
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name")
    })
    UserInfo getUserInfo(Integer id);

    @Select("select * from user limit #{limit},#{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name")
    })
    List<UserInfo> getUserListInfo(Integer limit, Integer offset);

    @Select("select count(*) from user limit #{limit},#{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name")
    })
    Integer getUserListInfoV1(Integer limit, Integer offset);
}
