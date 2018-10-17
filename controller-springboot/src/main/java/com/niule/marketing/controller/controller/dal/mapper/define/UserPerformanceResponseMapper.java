package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.UserPerformanceResponse;
import com.niule.marketing.controller.controller.model.DateRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 11:42
 */
public interface UserPerformanceResponseMapper {

    List<UserPerformanceResponse> searchUserActionInfo(DateRequestModel dateRequestModel);
}
