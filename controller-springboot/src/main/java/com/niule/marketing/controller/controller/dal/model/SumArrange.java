package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class SumArrange {
    private Integer id;

    private Integer userId;

    private String todaySum;

    private String tomorrowArrange;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTodaySum() {
        return todaySum;
    }

    public void setTodaySum(String todaySum) {
        this.todaySum = todaySum == null ? null : todaySum.trim();
    }

    public String getTomorrowArrange() {
        return tomorrowArrange;
    }

    public void setTomorrowArrange(String tomorrowArrange) {
        this.tomorrowArrange = tomorrowArrange == null ? null : tomorrowArrange.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}