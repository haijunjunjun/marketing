package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaleList implements Serializable {
    private static final long serialVersionUID = -8571912929384207217L;
    /**
     * 用户头像
     */
    private String imageUrl;
    /**
     * 销售类型
     */
    private String saleType;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 月销量
     */
    private Integer monthNum;
    /**
     * 周销量
     */
    private Integer weekNum;
    /**
     * 用户id
     */
    private Integer userId;
}
