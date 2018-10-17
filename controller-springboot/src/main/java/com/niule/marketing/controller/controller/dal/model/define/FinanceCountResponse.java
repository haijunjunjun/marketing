package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 10:56
 */
@Data
public class FinanceCountResponse implements Serializable {
    private static final long serialVersionUID = 1657514781885943686L;
    private Integer id;
    private String custName;
    private String custPhone;
    private double amount;
    private String userRealName;
    private String returnMsg;
    private String payResult;
    private Date payTime;
}
