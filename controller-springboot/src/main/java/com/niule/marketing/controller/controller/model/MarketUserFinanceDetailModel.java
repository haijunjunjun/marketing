package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 14:44
 */
@Data
public class MarketUserFinanceDetailModel implements Serializable {
    private static final long serialVersionUID = 665022612772086824L;
    private String userRealName;
    private String userPhone;
    private String changeReason;
    private double amount;
    private Date changeTime;
    private String status;
}
