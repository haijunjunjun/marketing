package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper extends MyMapper<Address> {

    List<Address> getAddressList(@Param("userId") Integer userId, @Param("userType") Integer userType);

    Integer updateDefaultAddress(@Param("id") Integer id);
}