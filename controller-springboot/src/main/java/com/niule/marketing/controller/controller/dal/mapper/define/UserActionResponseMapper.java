package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.UserActionResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 17:25
 */
public interface UserActionResponseMapper {

    List<UserActionResponse> searchUserActionInfo(@Param("userId") Integer userId, @Param("custName") String custName, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("actions") List<String> actions);
}
