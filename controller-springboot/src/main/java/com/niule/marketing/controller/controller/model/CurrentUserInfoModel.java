package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 27 - 15:20
 */
@Data
public class CurrentUserInfoModel implements Serializable {
    private static final long serialVersionUID = -1797598372883686197L;
    private Integer userId;
    private String userName;
    private String roleName;
}
