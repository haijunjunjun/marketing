package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "gold_beans_apply")
public class GoldBeansApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 金豆申请数量
     */
    @Column(name = "gold_beans_apply_num")
    private Integer goldBeansApplyNum;

    /**
     * 申请时间
     */
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 金豆申请状态（1：待审核 2：已成功 3：已拒绝）
     */
    private Integer status;

    /**
     * 金豆申请类型（1：申请金豆 2：赠送）
     */
    private Integer type;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Date checkTime;

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
     * 获取金豆申请数量
     *
     * @return gold_beans_apply_num - 金豆申请数量
     */
    public Integer getGoldBeansApplyNum() {
        return goldBeansApplyNum;
    }

    /**
     * 设置金豆申请数量
     *
     * @param goldBeansApplyNum 金豆申请数量
     */
    public void setGoldBeansApplyNum(Integer goldBeansApplyNum) {
        this.goldBeansApplyNum = goldBeansApplyNum;
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取金豆申请状态（1：待审核 2：已成功 3：已拒绝）
     *
     * @return status - 金豆申请状态（1：待审核 2：已成功 3：已拒绝）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置金豆申请状态（1：待审核 2：已成功 3：已拒绝）
     *
     * @param status 金豆申请状态（1：待审核 2：已成功 3：已拒绝）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取金豆申请类型（1：申请金豆 2：赠送）
     *
     * @return type - 金豆申请类型（1：申请金豆 2：赠送）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置金豆申请类型（1：申请金豆 2：赠送）
     *
     * @param type 金豆申请类型（1：申请金豆 2：赠送）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取审核时间
     *
     * @return check_time - 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置审核时间
     *
     * @param checkTime 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}