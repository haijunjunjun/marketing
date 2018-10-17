package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 15:40
 */
@Data
public class UserDetailResponseModel implements Serializable {
    private static final long serialVersionUID = -2655039599302341476L;

    private UserBasicInfo userBasicInfo;
    private UserPersonalInfo userPersonalInfo;
    private UserAccountInfo userAccountInfo;
}
