package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 16:48
 */
@Data
public class AccountBankRequestModel implements Serializable {
    private static final long serialVersionUID = 2078422549364365656L;
    private Integer id;
    /**
     * 开户人
     */
    private String accountHolder;

    /**
     * 银行卡号
     */
    private String accountBankNo;

    /**
     * 开户银行
     */
    private String accountBankName;
}
