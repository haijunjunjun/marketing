package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class CustomerInfo {
    private Integer id;

    private Integer userId;

    private String companyName;

    private String companyType;

    private String companyTypeDesc;

    private Integer status;

    private String custName;

    private String custPhone;

    private String companyAddr;

    private Date repoTime;

    private Date checkTime;

    private Date compactTime;

    private Date abandonTime;

    private Date deleteTime;

    private Date modifyTime;

    private Integer isPhone;

    private Integer isVisit;

    private Integer isGoldBeans;

    private Integer isCompact;

    private Integer isCompactCheck;

    private Integer isMoney;

    private Integer isInterestCust;

    private String compactImg;

    private String compactNo;

    private String mark;

    private Double price;

    private String abandonReason;

    private String deleteReason;

    private String checkRefuseReason;

    private Integer donateGoldBeans;

    private Integer relativeId;

    private Date lastModifyTime;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getCompanyTypeDesc() {
        return companyTypeDesc;
    }

    public void setCompanyTypeDesc(String companyTypeDesc) {
        this.companyTypeDesc = companyTypeDesc == null ? null : companyTypeDesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public Date getRepoTime() {
        return repoTime;
    }

    public void setRepoTime(Date repoTime) {
        this.repoTime = repoTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getCompactTime() {
        return compactTime;
    }

    public void setCompactTime(Date compactTime) {
        this.compactTime = compactTime;
    }

    public Date getAbandonTime() {
        return abandonTime;
    }

    public void setAbandonTime(Date abandonTime) {
        this.abandonTime = abandonTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsPhone() {
        return isPhone;
    }

    public void setIsPhone(Integer isPhone) {
        this.isPhone = isPhone;
    }

    public Integer getIsVisit() {
        return isVisit;
    }

    public void setIsVisit(Integer isVisit) {
        this.isVisit = isVisit;
    }

    public Integer getIsGoldBeans() {
        return isGoldBeans;
    }

    public void setIsGoldBeans(Integer isGoldBeans) {
        this.isGoldBeans = isGoldBeans;
    }

    public Integer getIsCompact() {
        return isCompact;
    }

    public void setIsCompact(Integer isCompact) {
        this.isCompact = isCompact;
    }

    public Integer getIsCompactCheck() {
        return isCompactCheck;
    }

    public void setIsCompactCheck(Integer isCompactCheck) {
        this.isCompactCheck = isCompactCheck;
    }

    public Integer getIsMoney() {
        return isMoney;
    }

    public void setIsMoney(Integer isMoney) {
        this.isMoney = isMoney;
    }

    public Integer getIsInterestCust() {
        return isInterestCust;
    }

    public void setIsInterestCust(Integer isInterestCust) {
        this.isInterestCust = isInterestCust;
    }

    public String getCompactImg() {
        return compactImg;
    }

    public void setCompactImg(String compactImg) {
        this.compactImg = compactImg == null ? null : compactImg.trim();
    }

    public String getCompactNo() {
        return compactNo;
    }

    public void setCompactNo(String compactNo) {
        this.compactNo = compactNo == null ? null : compactNo.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAbandonReason() {
        return abandonReason;
    }

    public void setAbandonReason(String abandonReason) {
        this.abandonReason = abandonReason == null ? null : abandonReason.trim();
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason == null ? null : deleteReason.trim();
    }

    public String getCheckRefuseReason() {
        return checkRefuseReason;
    }

    public void setCheckRefuseReason(String checkRefuseReason) {
        this.checkRefuseReason = checkRefuseReason == null ? null : checkRefuseReason.trim();
    }

    public Integer getDonateGoldBeans() {
        return donateGoldBeans;
    }

    public void setDonateGoldBeans(Integer donateGoldBeans) {
        this.donateGoldBeans = donateGoldBeans;
    }

    public Integer getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Integer relativeId) {
        this.relativeId = relativeId;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}