package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 16:57
 */
@Data
public class CustDetailInfo implements Serializable {
    private static final long serialVersionUID = -2754926080829640487L;
    private Integer id;
    private String phone;
    private String custName;
    private String companyName;
    private String type;
    private String companyAddr;
    private String mark;
}
