package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 16:12
 */
@Data
public class UserActionResponseModel implements Serializable {
    private static final long serialVersionUID = -3965673562409368322L;
    private Integer id;
    private String userRealName;
    private String custName;
    private String companyName;
    private String companyType;
    private String custPhone;
    private Date createTime;
    private String action;
}
