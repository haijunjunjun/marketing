package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 15:27
 */
@Data
public class FinanceDetail implements Serializable {
    private static final long serialVersionUID = 412021434017166190L;
    private Integer custId;
    private String custName;
    private String custPhone;
    private double amount;
    private String payStatus;
    private Date operateTime;
}
