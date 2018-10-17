package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 27 - 14:19
 */
@Data
public class UserRoleInfoModel implements Serializable {
    private static final long serialVersionUID = 1503779326733674990L;
    private Integer id;
    private String roleName;
    private String roleDesc;
}
