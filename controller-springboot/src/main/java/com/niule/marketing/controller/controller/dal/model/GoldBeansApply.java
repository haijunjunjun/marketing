package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class GoldBeansApply {
    private Integer id;

    private Integer userId;

    private Integer goldBeansApplyNum;

    private Date applyTime;

    private Integer status;

    private Integer type;

    private Date checkTime;

    private String refuseReason;

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

    public Integer getGoldBeansApplyNum() {
        return goldBeansApplyNum;
    }

    public void setGoldBeansApplyNum(Integer goldBeansApplyNum) {
        this.goldBeansApplyNum = goldBeansApplyNum;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }
}