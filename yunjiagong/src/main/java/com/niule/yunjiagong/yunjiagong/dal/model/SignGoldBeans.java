package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sign_gold_beans")
public class SignGoldBeans {
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
     * 签到三天送金豆数
     */
    @Column(name = "three_gold_beans")
    private Integer threeGoldBeans;

    /**
     * 签到七天金豆数
     */
    @Column(name = "seven_gold_beans")
    private Integer sevenGoldBeans;

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
     * 获取签到三天送金豆数
     *
     * @return three_gold_beans - 签到三天送金豆数
     */
    public Integer getThreeGoldBeans() {
        return threeGoldBeans;
    }

    /**
     * 设置签到三天送金豆数
     *
     * @param threeGoldBeans 签到三天送金豆数
     */
    public void setThreeGoldBeans(Integer threeGoldBeans) {
        this.threeGoldBeans = threeGoldBeans;
    }

    /**
     * 获取签到七天金豆数
     *
     * @return seven_gold_beans - 签到七天金豆数
     */
    public Integer getSevenGoldBeans() {
        return sevenGoldBeans;
    }

    /**
     * 设置签到七天金豆数
     *
     * @param sevenGoldBeans 签到七天金豆数
     */
    public void setSevenGoldBeans(Integer sevenGoldBeans) {
        this.sevenGoldBeans = sevenGoldBeans;
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