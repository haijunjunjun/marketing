package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 12:06
 */
@Data
public class CustBaseInfo implements Serializable {
    private static final long serialVersionUID = 6907621960788931555L;
    private String custPhone;
    private String custName;
    private String companyName;
    private String companyType;
    private String companyTypeDesc;
    private String address;
    private String mark;
}
