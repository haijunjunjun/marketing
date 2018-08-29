package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "config_template")
public class ConfigTemplate {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户认证状态(1：注册用户 2：个人认证 3：企业认证 )
     */
    @Column(name = "user_status")
    private Integer userStatus;

    /**
     * 类型(0发活审核加信誉度1 发活审核加金豆 2活信息发布上限 3 审核用户加金豆 4活信息分享朋友圈  5活信息查看电话 6用户审核加信誉度 7用户被投诉减信誉度  8发承接审核加信誉度  9活信息订阅设置 10推送条数上限设置 11提现最低金额设置 12 承接信息分享朋友圈 13 查看承接信息上限 14提现费率设置)
     */
    private Integer type;

    /**
     * 变动数量
     */
    @Column(name = "change_count")
    private Integer changeCount;

    /**
     * 具体操作
     */
    private String action;

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
     * 获取用户认证状态(1：注册用户 2：个人认证 3：企业认证 )
     *
     * @return user_status - 用户认证状态(1：注册用户 2：个人认证 3：企业认证 )
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户认证状态(1：注册用户 2：个人认证 3：企业认证 )
     *
     * @param userStatus 用户认证状态(1：注册用户 2：个人认证 3：企业认证 )
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取类型(0发活审核加信誉度1 发活审核加金豆 2活信息发布上限 3 审核用户加金豆 4活信息分享朋友圈  5活信息查看电话 6用户审核加信誉度 7用户被投诉减信誉度  8发承接审核加信誉度  9活信息订阅设置 10推送条数上限设置 11提现最低金额设置 12 承接信息分享朋友圈 13 查看承接信息上限 14提现费率设置)
     *
     * @return type - 类型(0发活审核加信誉度1 发活审核加金豆 2活信息发布上限 3 审核用户加金豆 4活信息分享朋友圈  5活信息查看电话 6用户审核加信誉度 7用户被投诉减信誉度  8发承接审核加信誉度  9活信息订阅设置 10推送条数上限设置 11提现最低金额设置 12 承接信息分享朋友圈 13 查看承接信息上限 14提现费率设置)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型(0发活审核加信誉度1 发活审核加金豆 2活信息发布上限 3 审核用户加金豆 4活信息分享朋友圈  5活信息查看电话 6用户审核加信誉度 7用户被投诉减信誉度  8发承接审核加信誉度  9活信息订阅设置 10推送条数上限设置 11提现最低金额设置 12 承接信息分享朋友圈 13 查看承接信息上限 14提现费率设置)
     *
     * @param type 类型(0发活审核加信誉度1 发活审核加金豆 2活信息发布上限 3 审核用户加金豆 4活信息分享朋友圈  5活信息查看电话 6用户审核加信誉度 7用户被投诉减信誉度  8发承接审核加信誉度  9活信息订阅设置 10推送条数上限设置 11提现最低金额设置 12 承接信息分享朋友圈 13 查看承接信息上限 14提现费率设置)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取变动数量
     *
     * @return change_count - 变动数量
     */
    public Integer getChangeCount() {
        return changeCount;
    }

    /**
     * 设置变动数量
     *
     * @param changeCount 变动数量
     */
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * 获取具体操作
     *
     * @return action - 具体操作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置具体操作
     *
     * @param action 具体操作
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }
}