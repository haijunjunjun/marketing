package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 目标id
     */
    @Column(name = "target_id")
    private Integer targetId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 投诉内容
     */
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 1:被投诉 2:投诉成功 3:投诉失败 4:失效
     */
    private Integer status;

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
     * 获取目标id
     *
     * @return target_id - 目标id
     */
    public Integer getTargetId() {
        return targetId;
    }

    /**
     * 设置目标id
     *
     * @param targetId 目标id
     */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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
     * 获取投诉内容
     *
     * @return content - 投诉内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置投诉内容
     *
     * @param content 投诉内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取状态 1:被投诉 2:投诉成功 3:投诉失败 4:失效
     *
     * @return status - 状态 1:被投诉 2:投诉成功 3:投诉失败 4:失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1:被投诉 2:投诉成功 3:投诉失败 4:失效
     *
     * @param status 状态 1:被投诉 2:投诉成功 3:投诉失败 4:失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}