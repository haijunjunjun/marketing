package com.example.demo.dal.mapper;

import com.example.demo.dal.model.UserAccount;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserAccountMapper extends MyMapper<UserAccount> {

    int updateUserAccount(@Param("id") Integer userId, @Param("cash") double cash);

    int updateBankNo(@Param("id") Integer userId, @Param("bankNo") String accountBankNo);
}