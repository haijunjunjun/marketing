package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.UserResponse;
import com.niule.marketing.controller.controller.model.UserSearchRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 16:57
 */
public interface UserResponseMapper {

    List<UserResponse> searchUserInfo(UserSearchRequestModel userSearchRequestModel);
}
