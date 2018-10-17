package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 17:09
 */
@Data
public class UserActionRequestModel implements Serializable {
    private static final long serialVersionUID = 298354532575869976L;
    private Integer userId;
    private String custName;
    private String isPhone;
    private String isVisit;
    private String isGoldBeans;
    private String isCompact;
    private String isCompactCheck;
    private String isMoney;
    private String isInterestCust;
    private String startTime;
    private String endTime;
    private Integer pageNum;
    private Integer pageSize;
}
