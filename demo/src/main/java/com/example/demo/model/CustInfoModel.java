package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 11:29
 */
@Data
public class CustInfoModel implements Serializable {
    private static final long serialVersionUID = 609444256557847384L;
    /**
     * 客户id
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司类型
     */
    private String companyType;

    /**
     * 状态 （1：待跟进 2：已签约 3：已放弃）
     */
    private Integer status;

    /**
     * 客户名称
     */
    private String custName;

    /**
     * 客户手机号（联系方式）
     */
    private String custPhone;

    /**
     * 公司地址
     */
    private String companyAddr;

    /**
     * 是否已电话联系 （0：未联系 1： 已联系）
     */
    private Integer isPhone;

    /**
     * 是否已拜访（0：未拜访 1：已拜访）
     */
    private Integer isVisit;

    /**
     * 是否赠送金豆（0：未赠送 1：已赠送）
     */
    private Integer isGoldBeans;

    /**
     * 是否已签合同（0：未签 1：已签）
     */
    private Integer isCompact;

    /**
     * 合同是否后台审核（1：审核 0：未审核）
     */
    private Integer isCompactCheck;

    /**
     * 是否已打款（0：未打款 1：已打款）
     */
    private Integer isMoney;

    /**
     * 是否意向客户(0：有意向 1：无意向)
     */
    private Integer isInterestCust;

    /**
     * 备注
     */
    private String mark;

}
