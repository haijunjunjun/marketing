package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.AccountBank;
import com.niule.marketing.control.dal.model.AccountBankExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccountBankMapper {
    int countByExample(AccountBankExample example);

    int deleteByExample(AccountBankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountBank record);

    int insertSelective(AccountBank record);

    List<AccountBank> selectByExample(AccountBankExample example);

    AccountBank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountBank record, @Param("example") AccountBankExample example);

    int updateByExample(@Param("record") AccountBank record, @Param("example") AccountBankExample example);

    int updateByPrimaryKeySelective(AccountBank record);

    int updateByPrimaryKey(AccountBank record);
}