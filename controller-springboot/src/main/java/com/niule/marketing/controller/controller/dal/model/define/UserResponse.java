package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 16:57
 */
@Data
public class UserResponse implements Serializable {
    private static final long serialVersionUID = -4676438317500504755L;
    private Integer userId;
    private String realName;
    private String phone;
    private Integer sex;
    private Integer role;
    private String marketLevel;
    private String manageLevel;
    private String area;
    private String city;
    private double performance;
    private Date entryTime;
    private Integer status;
}
