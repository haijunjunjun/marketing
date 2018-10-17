package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class UserCommissionCount {
    private Integer id;

    private Integer userId;

    private String realName;

    private String city;

    private String year;

    private String month;

    private Double baseSalary;

    private Double commission;

    private Double personalTax;

    private Double socialInsurance;

    private Double otherFee;

    private Double countTotal;

    private Date createTime;

    private Date modifyTime;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getPersonalTax() {
        return personalTax;
    }

    public void setPersonalTax(Double personalTax) {
        this.personalTax = personalTax;
    }

    public Double getSocialInsurance() {
        return socialInsurance;
    }

    public void setSocialInsurance(Double socialInsurance) {
        this.socialInsurance = socialInsurance;
    }

    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    public Double getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Double countTotal) {
        this.countTotal = countTotal;
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
}