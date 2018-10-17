package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 9:58
 */
@Data
public class CustomerDetailResponseModel implements Serializable {
    private static final long serialVersionUID = -1929986812647164004L;
    private Integer custId;
    private String custName;
    private String custPhone;
    private String companyType;
    private Date repoTime;
    private String companyAddr;
    private String companyName;
    private Date modifyTime;
    private Integer goldBeans;
    private String statusName;
    private String userRealName;
    private String userPhone;
    private String city;
    private Date registTime;
    private String mark;
    private Integer isPhone;
    private Integer isVisit;
    private Integer isGoldBeans;
    private Integer isCompact;
    private Integer isCompactCheck;
    private Integer isMoney;
    private Integer isInterestCust;
}
