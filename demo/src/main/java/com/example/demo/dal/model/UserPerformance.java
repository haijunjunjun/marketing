package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "user_performance")
public class UserPerformance {
    @Id
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "cust_id")
    private String custId;

    /**
     * 业绩提成
     */
    private Integer performance;

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
     * 获取客户id
     *
     * @return cust_id - 客户id
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 设置客户id
     *
     * @param custId 客户id
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 获取业绩提成
     *
     * @return performance - 业绩提成
     */
    public Integer getPerformance() {
        return performance;
    }

    /**
     * 设置业绩提成
     *
     * @param performance 业绩提成
     */
    public void setPerformance(Integer performance) {
        this.performance = performance;
    }
}