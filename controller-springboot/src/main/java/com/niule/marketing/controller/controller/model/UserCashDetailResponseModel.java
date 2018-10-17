package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 10:50
 */
@Data
public class UserCashDetailResponseModel implements Serializable {
    private static final long serialVersionUID = -2492523453193833552L;
    private Integer id;
    private String userRealName;
    private String userPhone;
    private double cash;
    private String accountHolder;
    private String cashAccountBankName;
    private String cashAccountBankNo;
    private Date cashModifyTime;
    private Date cashCreateTime;
    private Integer status;
}
