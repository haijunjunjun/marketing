package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 08 - 17 - 14:16
 */
@Data
public class CustRespModel implements Serializable {
    private static final long serialVersionUID = -7694981825456972495L;
    /**
     * 客户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 状态 （1：待跟进 2：已签约 3：已放弃 4：已删除）
     */
    private Integer status;

    /**
     * 发票申请状态 (0:未申请  1 ：审核中 2：已通过 3：未通过)
     */
    private Integer receiptStatus;

    /**
     * 客户名称
     */
    @Column(name = "cust_name")
    private String custName;

    /**
     * 客户手机号（联系方式）
     */
    @Column(name = "cust_phone")
    private String custPhone;

    /**
     * 公司地址
     */
    @Column(name = "company_addr")
    private String companyAddr;

    /**
     * 报备时间
     */
    @Column(name = "repo_time")
    private Date repoTime;
    private String repoTimeV1;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Date checkTime;
    private String checkTimeV1;

    /**
     * 签约时间
     */
    @Column(name = "compact_time")
    private Date compactTime;
    private String compactTimeV1;

    /**
     * 放弃时间
     */
    @Column(name = "abandon_time")
    private Date abandonTime;
    private String abandonTimeV1;

    /**
     * 删除时间
     */
    @Column(name = "delete_time")
    private Date deleteTime;
    private String deleteTimeV1;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;
    private String modifyTimeV1;

    /**
     * 是否已电话联系 （0：未联系 1： 已联系）
     */
    @Column(name = "is_phone")
    private Integer isPhone;

    /**
     * 是否已拜访（0：未拜访 1：已拜访）
     */
    @Column(name = "is_visit")
    private Integer isVisit;

    /**
     * 是否赠送金豆（0：未赠送 1：已赠送）
     */
    @Column(name = "is_gold_beans")
    private Integer isGoldBeans;

    /**
     * 是否已签合同（0：未签 1：已签）
     */
    @Column(name = "is_compact")
    private Integer isCompact;

    /**
     * 合同是否后台审核（1：审核成功 0：审核失败）
     */
    @Column(name = "is_compact_check")
    private Integer isCompactCheck;

    /**
     * 是否已打款（0：未打款 1：已打款）
     */
    @Column(name = "is_money")
    private Integer isMoney;

    /**
     * 是否意向客户(0：有意向 1：无意向)
     */
    @Column(name = "is_interest_cust")
    private Integer isInterestCust;

    /**
     * 合同图片
     */
    @Column(name = "compact_img")
    private String compactImg;

    /**
     * 备注
     */
    private String mark;

    /**
     * 签约价格字段
     */
    private Double price;

    /**
     * 放弃原因
     */
    @Column(name = "abandon_reason")
    private String abandonReason;

    /**
     * 删除原因
     */
    @Column(name = "delete_reason")
    private String deleteReason;

    /**
     * 审核失败原因
     */
    @Column(name = "check_refuse_reason")
    private String checkRefuseReason;

    /**
     * 赠送用户的金豆数（后台自定义）
     */
    @Column(name = "donate_gold_beans")
    private Integer donateGoldBeans;

    /**
     * 关联字段（可用于判断手机号是否为同一个人）
     */
    @Column(name = "relative_id")
    private Integer relativeId;

}
