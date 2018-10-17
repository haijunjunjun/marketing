package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 10:53
 */
@Data
public class FinanceCountResponseModel implements Serializable {
    private static final long serialVersionUID = 624771916494224687L;
    private Integer id;
    private String custName;
    private String custPhone;
    private double amount;
    private String userRealName;
    private String feeItem;
    private String payType;
    private String payStatus;
    private Date payTime;
}
