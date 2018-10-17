package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 15:24
 */
@Data
public class MarketUserCommissionEditModel implements Serializable {
    private static final long serialVersionUID = 5590793273896568942L;
    private Integer id;
    private Integer userId;
    private String city;
    private String userRealName;
    private String year;
    private String month;
    private double baseSalary;
    private double commission;
    private double personalTax;
    private double socialInsurance;
    private double otherFee;
    private double totalAmount;
    private String phone;
}
