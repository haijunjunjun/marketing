package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 16:24
 */
@Data
public class CustomerPerDayModel implements Serializable {
    private static final long serialVersionUID = -3869690147183547873L;
    private String userRealName;
    private String companyName;
    private String companyType;
    private String custName;
    private String custPhone;
    private String custAddr;
    private Date repoTime;
    private String mark;
}
