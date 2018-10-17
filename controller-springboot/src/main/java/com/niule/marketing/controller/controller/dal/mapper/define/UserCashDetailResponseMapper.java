package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.UserCashDetailResponse;
import com.niule.marketing.controller.controller.model.UserCashDetailRequestModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 10:54
 */
public interface UserCashDetailResponseMapper {

    List<UserCashDetailResponse> searchUserCashDetail (UserCashDetailRequestModel userCashDetailRequestModel);

    UserCashDetailResponse userCashCheckEditInfo (@Param("id") Integer id);
}
