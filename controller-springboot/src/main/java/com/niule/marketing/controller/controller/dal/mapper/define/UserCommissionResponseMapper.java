package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.UserCommissionResponse;
import com.niule.marketing.controller.controller.model.UserCommissionRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 14:31
 */
public interface UserCommissionResponseMapper {

    List<UserCommissionResponse> searchUserCommission(UserCommissionRequestModel userCommissionRequestModel);
}
