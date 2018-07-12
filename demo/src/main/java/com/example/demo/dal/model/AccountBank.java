package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "account_bank")
public class AccountBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 银行卡号
     */
    @Column(name = "bank_no")
    private String bankNo;

    /**
     * 开户人
     */
    @Column(name = "account_holder")
    private String accountHolder;

    /**
     * 开户银行
     */
    @Column(name = "account_bank_name")
    private String accountBankName;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
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
     * 获取银行卡号
     *
     * @return bank_no - 银行卡号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankNo 银行卡号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    /**
     * 获取开户人
     *
     * @return account_holder - 开户人
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * 设置开户人
     *
     * @param accountHolder 开户人
     */
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder == null ? null : accountHolder.trim();
    }

    /**
     * 获取开户银行
     *
     * @return account_bank_name - 开户银行
     */
    public String getAccountBankName() {
        return accountBankName;
    }

    /**
     * 设置开户银行
     *
     * @param accountBankName 开户银行
     */
    public void setAccountBankName(String accountBankName) {
        this.accountBankName = accountBankName == null ? null : accountBankName.trim();
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
}