package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sign_log")
public class SignLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 资源
     */
    private String source;

    /**
     * 动作
     */
    private String action;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 获取资源
     *
     * @return source - 资源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置资源
     *
     * @param source 资源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取动作
     *
     * @return action - 动作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置动作
     *
     * @param action 动作
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
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
}