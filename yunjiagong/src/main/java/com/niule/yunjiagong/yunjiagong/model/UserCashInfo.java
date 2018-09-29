package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 18:15
 */
@Data
public class UserCashInfo implements Serializable {
    private static final long serialVersionUID = -1862184746640387272L;
    private String accountBankName;
    private String accountBankNo;
}
