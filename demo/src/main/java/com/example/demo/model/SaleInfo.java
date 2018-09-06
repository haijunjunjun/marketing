package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaleInfo implements Serializable {
    private static final long serialVersionUID = 6076361821624916294L;
    private String imageUrl;
    private String saleType;
    private String realName;
    private String phone;
    private Integer userId;
}
