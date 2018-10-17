package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 16:42
 */
@Data
public class UserSearchRequestModel implements Serializable {
    private static final long serialVersionUID = 1057156400528004121L;
    private String userRealName;
    private String userPhone;
    private Integer roleName;
}
