package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 11:37
 */
@Data
public class FollowRecord implements Serializable {
    private static final long serialVersionUID = 4237290735850613991L;
    private Integer id;
    private String custName;
    private String custPhone;
    private String followStatus;
    private String mark;
    private String userRealName;
    private String userPhone;
    private Date createTime;
}
