package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cash_detail")
public class CashDetail {
    /**
     * 主键id
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
     * 提现金额
     */
    private Double cash;

    /**
     * 后台审核状态 0：待审核 1：审核通过
     */
    @Column(name = "check_status")
    private Integer checkStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 审核失败原因
     */
    @Column(name = "refuse_reason")
    private String refuseReason;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取提现金额
     *
     * @return cash - 提现金额
     */
    public Double getCash() {
        return cash;
    }

    /**
     * 设置提现金额
     *
     * @param cash 提现金额
     */
    public void setCash(Double cash) {
        this.cash = cash;
    }

    /**
     * 获取后台审核状态 0：待审核 1：审核通过
     *
     * @return check_status - 后台审核状态 0：待审核 1：审核通过
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置后台审核状态 0：待审核 1：审核通过
     *
     * @param checkStatus 后台审核状态 0：待审核 1：审核通过
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取审核失败原因
     *
     * @return refuse_reason - 审核失败原因
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 设置审核失败原因
     *
     * @param refuseReason 审核失败原因
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }
}