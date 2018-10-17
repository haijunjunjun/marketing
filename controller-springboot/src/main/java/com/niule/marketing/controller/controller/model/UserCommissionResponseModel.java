package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 14:03
 */
@Data
public class UserCommissionResponseModel implements Serializable {
    private static final long serialVersionUID = -8753940111398822854L;
    private Integer id;
    private String userRealName;
    private String userPhone;
    private String city;
    private double commission;
    private Date createTime;
    private String yearMonth;
}
