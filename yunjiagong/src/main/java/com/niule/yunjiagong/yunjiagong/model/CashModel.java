package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 11:04
 */
@Data
public class CashModel implements Serializable {
    private static final long serialVersionUID = -4956617722994692581L;
    private Integer accountBankId;
    private String money;
}
