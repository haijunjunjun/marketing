package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 15:22
 */
@Data
public class MarketUserCommissionResponseModel implements Serializable {
    private static final long serialVersionUID = 7576759951559777012L;
    private Integer id;
    private String userRealName;
    private String userPhone;
    private String city;
    private String yearMonth;
    private double amount;
    private Date createTime;
}
