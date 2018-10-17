package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 11:38
 */
@Data
public class UserPerformanceResponseModel implements Serializable {
    private static final long serialVersionUID = -1384304502603807078L;
    private Integer id;
    private String realName;
    private String custName;
    private String companyName;
    private String companyType;
    private String custPhone;
    private Date createTime;
    private double performance;
    private String statusName;
}
