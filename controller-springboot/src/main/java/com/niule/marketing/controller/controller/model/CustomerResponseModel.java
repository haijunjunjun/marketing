package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 17:09
 */
@Data
public class CustomerResponseModel implements Serializable {
    private static final long serialVersionUID = -6066452701651234052L;
    private Integer id;
    private String custName;
    private String custPhone;
    private String companyName;
    private String companyType;
    private String userName;
    private String userPhone;
    private Date createTime;
    private Date modifyTime;
    private Date custRegistTime;
    private Integer isPhone;
    private Integer isVisit;
    private Integer isGoldBeans;
    private Integer isCompact;
    private Integer isCompactCheck;
    private Integer isMoney;
    private Integer isInterestCust;
    private String statusName;
}
