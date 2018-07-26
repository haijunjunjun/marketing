package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sign_info")
public class SignInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 签到日期
     */
    @Column(name = "sign_date")
    private Date signDate;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 签到次数
     */
    private Integer duration;

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
     * 获取签到日期
     *
     * @return sign_date - 签到日期
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * 设置签到日期
     *
     * @param signDate 签到日期
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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
     * 获取签到次数
     *
     * @return duration - 签到次数
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置签到次数
     *
     * @param duration 签到次数
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}