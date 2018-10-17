package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cash_apply")
public class CashApply {
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
     * 银行卡信息主键id
     */
    @Column(name = "account_bank_id")
    private Integer accountBankId;

    /**
     * 提现金额
     */
    @Column(name = "cash_money")
    private Double cashMoney;

    /**
     * 提现状态（1：待审核  2：审核成功  3：审核失败）
     */
    @Column(name = "cash_status")
    private Integer cashStatus;

    /**
     * 审核失败原因
     */
    private String reason;

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
     * 备注
     */
    private String mark;

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
     * 获取银行卡信息主键id
     *
     * @return account_bank_id - 银行卡信息主键id
     */
    public Integer getAccountBankId() {
        return accountBankId;
    }

    /**
     * 设置银行卡信息主键id
     *
     * @param accountBankId 银行卡信息主键id
     */
    public void setAccountBankId(Integer accountBankId) {
        this.accountBankId = accountBankId;
    }

    /**
     * 获取提现金额
     *
     * @return cash_money - 提现金额
     */
    public Double getCashMoney() {
        return cashMoney;
    }

    /**
     * 设置提现金额
     *
     * @param cashMoney 提现金额
     */
    public void setCashMoney(Double cashMoney) {
        this.cashMoney = cashMoney;
    }

    /**
     * 获取提现状态（1：待审核  2：审核成功  3：审核失败）
     *
     * @return cash_status - 提现状态（1：待审核  2：审核成功  3：审核失败）
     */
    public Integer getCashStatus() {
        return cashStatus;
    }

    /**
     * 设置提现状态（1：待审核  2：审核成功  3：审核失败）
     *
     * @param cashStatus 提现状态（1：待审核  2：审核成功  3：审核失败）
     */
    public void setCashStatus(Integer cashStatus) {
        this.cashStatus = cashStatus;
    }

    /**
     * 获取审核失败原因
     *
     * @return reason - 审核失败原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置审核失败原因
     *
     * @param reason 审核失败原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}