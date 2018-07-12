package com.example.demo.dal.model;

import java.util.Date;
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