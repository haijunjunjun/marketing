package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "cust_gold_beans")
public class CustGoldBeans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "cust_id")
    private Integer custId;

    /**
     * 金豆数量
     */
    @Column(name = "gold_beans_num")
    private Integer goldBeansNum;

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
    public Integer getCustId() {
        return custId;
    }

    /**
     * 设置客户id
     *
     * @param custId 客户id
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    /**
     * 获取金豆数量
     *
     * @return gold_beans_num - 金豆数量
     */
    public Integer getGoldBeansNum() {
        return goldBeansNum;
    }

    /**
     * 设置金豆数量
     *
     * @param goldBeansNum 金豆数量
     */
    public void setGoldBeansNum(Integer goldBeansNum) {
        this.goldBeansNum = goldBeansNum;
    }
}