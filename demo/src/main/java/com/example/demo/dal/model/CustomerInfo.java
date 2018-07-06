package com.example.demo.dal.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "customer_info")
public class CustomerInfo {
    /**
     * 客户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 状态 （1：待跟进 2：已签约 3：已放弃）
     */
    private Integer status;

    /**
     * 客户名称
     */
    @Column(name = "cust_name")
    private String custName;

    /**
     * 客户手机号（联系方式）
     */
    @Column(name = "cust_phone")
    private String custPhone;

    /**
     * 公司地址
     */
    @Column(name = "company_addr")
    private String companyAddr;

    /**
     * 报备时间
     */
    @Column(name = "repo_time")
    private Date repoTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 是否已电话联系 （0：未联系 1： 已联系）
     */
    @Column(name = "is_phone")
    private Integer isPhone;

    /**
     * 是否已拜访（0：未拜访 1：已拜访）
     */
    @Column(name = "is_visit")
    private Integer isVisit;

    /**
     * 是否赠送金豆（0：未赠送 1：已赠送）
     */
    @Column(name = "is_gold_beans")
    private Integer isGoldBeans;

    /**
     * 是否已签合同（0：未签 1：已签）
     */
    @Column(name = "is_compact")
    private Integer isCompact;

    /**
     * 合同是否后台审核（1：审核 0：未审核）
     */
    @Column(name = "is_compact_check")
    private Integer isCompactCheck;

    /**
     * 是否已打款（0：未打款 1：已打款）
     */
    @Column(name = "is_money")
    private Integer isMoney;

    /**
     * 备注
     */
    private String mark;

    /**
     * 签约价格字段
     */
    private BigDecimal price;

    /**
     * 合同图片
     */
    @Column(name = "compact_img")
    private byte[] compactImg;

    /**
     * 获取客户id
     *
     * @return id - 客户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置客户id
     *
     * @param id 客户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取公司类型
     *
     * @return company_type - 公司类型
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置公司类型
     *
     * @param companyType 公司类型
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * 获取状态 （1：待跟进 2：已签约 3：已放弃）
     *
     * @return status - 状态 （1：待跟进 2：已签约 3：已放弃）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 （1：待跟进 2：已签约 3：已放弃）
     *
     * @param status 状态 （1：待跟进 2：已签约 3：已放弃）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取客户名称
     *
     * @return cust_name - 客户名称
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 设置客户名称
     *
     * @param custName 客户名称
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * 获取客户手机号（联系方式）
     *
     * @return cust_phone - 客户手机号（联系方式）
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 设置客户手机号（联系方式）
     *
     * @param custPhone 客户手机号（联系方式）
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    /**
     * 获取公司地址
     *
     * @return company_addr - 公司地址
     */
    public String getCompanyAddr() {
        return companyAddr;
    }

    /**
     * 设置公司地址
     *
     * @param companyAddr 公司地址
     */
    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    /**
     * 获取报备时间
     *
     * @return repo_time - 报备时间
     */
    public Date getRepoTime() {
        return repoTime;
    }

    /**
     * 设置报备时间
     *
     * @param repoTime 报备时间
     */
    public void setRepoTime(Date repoTime) {
        this.repoTime = repoTime;
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

    /**
     * 获取是否已电话联系 （0：未联系 1： 已联系）
     *
     * @return is_phone - 是否已电话联系 （0：未联系 1： 已联系）
     */
    public Integer getIsPhone() {
        return isPhone;
    }

    /**
     * 设置是否已电话联系 （0：未联系 1： 已联系）
     *
     * @param isPhone 是否已电话联系 （0：未联系 1： 已联系）
     */
    public void setIsPhone(Integer isPhone) {
        this.isPhone = isPhone;
    }

    /**
     * 获取是否已拜访（0：未拜访 1：已拜访）
     *
     * @return is_visit - 是否已拜访（0：未拜访 1：已拜访）
     */
    public Integer getIsVisit() {
        return isVisit;
    }

    /**
     * 设置是否已拜访（0：未拜访 1：已拜访）
     *
     * @param isVisit 是否已拜访（0：未拜访 1：已拜访）
     */
    public void setIsVisit(Integer isVisit) {
        this.isVisit = isVisit;
    }

    /**
     * 获取是否赠送金豆（0：未赠送 1：已赠送）
     *
     * @return is_gold_beans - 是否赠送金豆（0：未赠送 1：已赠送）
     */
    public Integer getIsGoldBeans() {
        return isGoldBeans;
    }

    /**
     * 设置是否赠送金豆（0：未赠送 1：已赠送）
     *
     * @param isGoldBeans 是否赠送金豆（0：未赠送 1：已赠送）
     */
    public void setIsGoldBeans(Integer isGoldBeans) {
        this.isGoldBeans = isGoldBeans;
    }

    /**
     * 获取是否已签合同（0：未签 1：已签）
     *
     * @return is_compact - 是否已签合同（0：未签 1：已签）
     */
    public Integer getIsCompact() {
        return isCompact;
    }

    /**
     * 设置是否已签合同（0：未签 1：已签）
     *
     * @param isCompact 是否已签合同（0：未签 1：已签）
     */
    public void setIsCompact(Integer isCompact) {
        this.isCompact = isCompact;
    }

    /**
     * 获取合同是否后台审核（1：审核 0：未审核）
     *
     * @return is_compact_check - 合同是否后台审核（1：审核 0：未审核）
     */
    public Integer getIsCompactCheck() {
        return isCompactCheck;
    }

    /**
     * 设置合同是否后台审核（1：审核 0：未审核）
     *
     * @param isCompactCheck 合同是否后台审核（1：审核 0：未审核）
     */
    public void setIsCompactCheck(Integer isCompactCheck) {
        this.isCompactCheck = isCompactCheck;
    }

    /**
     * 获取是否已打款（0：未打款 1：已打款）
     *
     * @return is_money - 是否已打款（0：未打款 1：已打款）
     */
    public Integer getIsMoney() {
        return isMoney;
    }

    /**
     * 设置是否已打款（0：未打款 1：已打款）
     *
     * @param isMoney 是否已打款（0：未打款 1：已打款）
     */
    public void setIsMoney(Integer isMoney) {
        this.isMoney = isMoney;
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    /**
     * 获取签约价格字段
     *
     * @return price - 签约价格字段
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置签约价格字段
     *
     * @param price 签约价格字段
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取合同图片
     *
     * @return compact_img - 合同图片
     */
    public byte[] getCompactImg() {
        return compactImg;
    }

    /**
     * 设置合同图片
     *
     * @param compactImg 合同图片
     */
    public void setCompactImg(byte[] compactImg) {
        this.compactImg = compactImg;
    }
}