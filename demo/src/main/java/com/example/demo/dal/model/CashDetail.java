package com.example.demo.dal.model;

import java.math.BigDecimal;
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
    private BigDecimal cash;

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
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * 设置提现金额
     *
     * @param cash 提现金额
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }
}