package com.example.demo.dal.mapper;

import com.example.demo.dal.model.AccountBank;
import com.example.demo.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface AccountBankMapper extends MyMapper<AccountBank> {

    int updateBankInfo(@Param("id") Integer userId, @Param("bankNo") String accountBankNo, @Param("accountHolder") String accountHolder, @Param("bankName") String accountBankName);
}