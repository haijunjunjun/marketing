package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 10:10
 */
@Data
public class BankInfoModel implements Serializable {
    private static final long serialVersionUID = -1796965096844697188L;
    private Integer id;
    private String accountBankName;
    private String accountBankNo;
}
