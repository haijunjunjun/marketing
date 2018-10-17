package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 11:23
 */
@Data
public class UserBasicInfo implements Serializable {
    private static final long serialVersionUID = -1473643231206242967L;
    private String realName;
    private Integer sex;
    private String userPhone;
    private Date entryTime;
    private String password;
    private double totalPerformance;
    private String area;
    private String city;
    private String roleName;
    private String superior;
    private String marketLevel;
    private String manageLevel;
    private Integer status;
    private Integer jobStatus;
    private String awaterImageUrl;
}
