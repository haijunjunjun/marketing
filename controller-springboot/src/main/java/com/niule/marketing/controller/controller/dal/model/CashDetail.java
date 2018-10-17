package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class CashDetail {
    private Integer id;

    private Integer userId;

    private Double cash;

    private Integer checkStatus;

    private Date createTime;

    private Date modifyTime;

    private String refuseReason;

    private String moneyCertificate;

    private String refuseMoneyReason;

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

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    public String getMoneyCertificate() {
        return moneyCertificate;
    }

    public void setMoneyCertificate(String moneyCertificate) {
        this.moneyCertificate = moneyCertificate == null ? null : moneyCertificate.trim();
    }

    public String getRefuseMoneyReason() {
        return refuseMoneyReason;
    }

    public void setRefuseMoneyReason(String refuseMoneyReason) {
        this.refuseMoneyReason = refuseMoneyReason == null ? null : refuseMoneyReason.trim();
    }
}