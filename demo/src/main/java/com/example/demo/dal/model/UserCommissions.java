package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_commissions")
public class UserCommissions {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 销售人员id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 提成
     */
    private Integer commission;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * 获取销售人员id
     *
     * @return user_id - 销售人员id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置销售人员id
     *
     * @param userId 销售人员id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取提成
     *
     * @return commission - 提成
     */
    public Integer getCommission() {
        return commission;
    }

    /**
     * 设置提成
     *
     * @param commission 提成
     */
    public void setCommission(Integer commission) {
        this.commission = commission;
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
     * 获取更新时间
     *
     * @return modify_time - 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更新时间
     *
     * @param modifyTime 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}