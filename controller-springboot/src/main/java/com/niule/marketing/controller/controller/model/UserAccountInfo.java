package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 11:24
 */
@Data
public class UserAccountInfo implements Serializable {
    private static final long serialVersionUID = -2330015727773154370L;
    private double balance;
    private String accountHolder;
    private Integer goldBeansNum;
    private String bankNo;
    private String accountBank;
}
