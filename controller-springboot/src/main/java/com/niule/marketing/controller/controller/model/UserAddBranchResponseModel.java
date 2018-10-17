package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 15:04
 */
@Data
public class UserAddBranchResponseModel implements Serializable {
    private static final long serialVersionUID = -4859484862718893924L;
    private Integer userId;
    private String userRealName;
    private String roleName;
}
