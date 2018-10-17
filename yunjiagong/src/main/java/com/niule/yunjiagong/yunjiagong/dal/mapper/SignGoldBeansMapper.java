package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.SignGoldBeans;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SignGoldBeansMapper extends MyMapper<SignGoldBeans> {

    int updateSignThreeGoldBeans (@Param("userId") Integer userId,@Param("threeGoldBeans") Integer threeGoldBeans);

    int updateSignSevenGoldBeans (@Param("userId") Integer userId,@Param("sevenGoldBeans") Integer sevenGoldBeans);

    int updateSignGoldBeansInfo (@Param("userId") Integer userId,@Param("threeGoldBeans") Integer threeGoldBeans,@Param("sevenGoldBeans") Integer sevenGoldBeans);
}