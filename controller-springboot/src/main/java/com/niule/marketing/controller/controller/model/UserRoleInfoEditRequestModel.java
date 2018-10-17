package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 27 - 17:49
 */
@Data
public class UserRoleInfoEditRequestModel implements Serializable {
    private static final long serialVersionUID = -6072995332762973303L;
    private Integer id;
    private String roleName;
    private String roleDesc;
    private Integer status;
    private String authIds;
}
