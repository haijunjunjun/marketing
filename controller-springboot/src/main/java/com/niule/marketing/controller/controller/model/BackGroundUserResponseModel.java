package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 20 - 16:27
 */
@Data
public class BackGroundUserResponseModel implements Serializable {
    private static final long serialVersionUID = -3001833165247576506L;
    private Integer id;
    private String realName;
    private String userName;
    private String roleName;
    private String phone;
    private Integer sex;
    private Date createTime;
}
