package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 16:47
 */
@Data
public class UserResponseModel implements Serializable {
    private static final long serialVersionUID = -2065404739298633803L;
    private Integer userId;
    private String realName;
    private String phone;
    private Integer sex;
    private String role;
    private String marketLevel;
    private String manageLevel;
    private String area;
    private String city;
    private double totalPerformance;
    private Date entryTime;
    private String statusName;
}
