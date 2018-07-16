package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class MyList implements Serializable {
    private static final long serialVersionUID = -9211899726650129028L;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 头像路径
     */
    private String imagesUrl;
    /**
     * 等级
     */
    private String level;
    /**
     * 余额
     */
    private double balance;
    /**
     * 业绩
     */
    private Integer performance;
    /**
     * 金豆数量
     */
    private Integer goldBeansNum;
}
