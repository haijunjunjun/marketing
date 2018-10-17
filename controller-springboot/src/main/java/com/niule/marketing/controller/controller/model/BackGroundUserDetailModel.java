package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 20 - 17:40
 */
@Data
public class BackGroundUserDetailModel implements Serializable {
    private static final long serialVersionUID = -2520672024790893906L;
    private String realName;
    private String userName;
    private transient String password;
    private String phone;
    private Integer sex;
    private Integer status;
    private Integer id;
}
