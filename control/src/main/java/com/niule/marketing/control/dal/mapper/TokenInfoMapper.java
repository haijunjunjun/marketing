package com.niule.marketing.control.dal.mapper;

import com.niule.marketing.control.dal.model.TokenInfo;
import com.niule.marketing.control.dal.model.TokenInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TokenInfoMapper {
    int countByExample(TokenInfoExample example);

    int deleteByExample(TokenInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TokenInfo record);

    int insertSelective(TokenInfo record);

    List<TokenInfo> selectByExample(TokenInfoExample example);

    TokenInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TokenInfo record, @Param("example") TokenInfoExample example);

    int updateByExample(@Param("record") TokenInfo record, @Param("example") TokenInfoExample example);

    int updateByPrimaryKeySelective(TokenInfo record);

    int updateByPrimaryKey(TokenInfo record);
}