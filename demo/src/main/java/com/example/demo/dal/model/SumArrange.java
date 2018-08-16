package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sum_arrange")
public class SumArrange {
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
     * 今日总结
     */
    @Column(name = "today_sum")
    private String todaySum;

    /**
     * 明日总结
     */
    @Column(name = "tomorrow_arrange")
    private String tomorrowArrange;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取今日总结
     *
     * @return today_sum - 今日总结
     */
    public String getTodaySum() {
        return todaySum;
    }

    /**
     * 设置今日总结
     *
     * @param todaySum 今日总结
     */
    public void setTodaySum(String todaySum) {
        this.todaySum = todaySum == null ? null : todaySum.trim();
    }

    /**
     * 获取明日总结
     *
     * @return tomorrow_arrange - 明日总结
     */
    public String getTomorrowArrange() {
        return tomorrowArrange;
    }

    /**
     * 设置明日总结
     *
     * @param tomorrowArrange 明日总结
     */
    public void setTomorrowArrange(String tomorrowArrange) {
        this.tomorrowArrange = tomorrowArrange == null ? null : tomorrowArrange.trim();
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