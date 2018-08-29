package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.BannerEdit;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface BannerEditMapper extends MyMapper<BannerEdit> {

    Integer countBannerEdit(@Param("userId") Integer userId);

    Integer updateBannerEdit(@Param("userId") Integer userId, @Param("editInfo") String editInfo);
}