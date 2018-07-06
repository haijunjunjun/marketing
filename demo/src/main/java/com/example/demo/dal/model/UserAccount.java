package com.example.demo.dal.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "user_account")
public class UserAccount {
    /**
     * 账户id
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
     * 余额
     */
    private BigDecimal balance;

    /**
     * 银行卡号
     */
    @Column(name = "account_bank_no")
    private String accountBankNo;

    /**
     * 获取账户id
     *
     * @return id - 账户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置账户id
     *
     * @param id 账户id
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
     * 获取余额
     *
     * @return balance - 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取银行卡号
     *
     * @return account_bank_no - 银行卡号
     */
    public String getAccountBankNo() {
        return accountBankNo;
    }

    /**
     * 设置银行卡号
     *
     * @param accountBankNo 银行卡号
     */
    public void setAccountBankNo(String accountBankNo) {
        this.accountBankNo = accountBankNo == null ? null : accountBankNo.trim();
    }
}