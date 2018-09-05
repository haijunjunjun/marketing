package com.example.demo.dal.model;

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
    private Integer userId;

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
     * 状态 （1：待跟进 2：已签约 3：已放弃 4：已删除）
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
     * 审核时间
     */
    @Column(name = "check_time")
    private Date checkTime;

    /**
     * 签约时间
     */
    @Column(name = "compact_time")
    private Date compactTime;

    /**
     * 放弃时间
     */
    @Column(name = "abandon_time")
    private Date abandonTime;

    /**
     * 删除时间
     */
    @Column(name = "delete_time")
    private Date deleteTime;

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
     * 合同是否后台审核（1：审核成功 0：审核失败 2:待审核）
     */
    @Column(name = "is_compact_check")
    private Integer isCompactCheck;

    /**
     * 是否已打款（0：未打款 1：已打款）
     */
    @Column(name = "is_money")
    private Integer isMoney;

    /**
     * 是否意向客户(0：有意向 1：无意向)
     */
    @Column(name = "is_interest_cust")
    private Integer isInterestCust;

    /**
     * 合同图片
     */
    @Column(name = "compact_img")
    private String compactImg;

    /**
     * 备注
     */
    private String mark;

    /**
     * 签约价格字段
     */
    private Double price;

    /**
     * 放弃原因
     */
    @Column(name = "abandon_reason")
    private String abandonReason;

    /**
     * 删除原因
     */
    @Column(name = "delete_reason")
    private String deleteReason;

    /**
     * 审核失败原因
     */
    @Column(name = "check_refuse_reason")
    private String checkRefuseReason;

    /**
     * 赠送用户的金豆数（后台自定义）
     */
    @Column(name = "donate_gold_beans")
    private Integer donateGoldBeans;

    /**
     * 关联字段（可用于判断手机号是否为同一个人）
     */
    @Column(name = "relative_id")
    private Integer relativeId;

    /**
     * 最后一次操作时间
     */
    @Column(name = "last_modify_time")
    private Date lastModifyTime;

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
     * 获取状态 （1：待跟进 2：已签约 3：已放弃 4：已删除）
     *
     * @return status - 状态 （1：待跟进 2：已签约 3：已放弃 4：已删除）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 （1：待跟进 2：已签约 3：已放弃 4：已删除）
     *
     * @param status 状态 （1：待跟进 2：已签约 3：已放弃 4：已删除）
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
     * 获取审核时间
     *
     * @return check_time - 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置审核时间
     *
     * @param checkTime 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取签约时间
     *
     * @return compact_time - 签约时间
     */
    public Date getCompactTime() {
        return compactTime;
    }

    /**
     * 设置签约时间
     *
     * @param compactTime 签约时间
     */
    public void setCompactTime(Date compactTime) {
        this.compactTime = compactTime;
    }

    /**
     * 获取放弃时间
     *
     * @return abandon_time - 放弃时间
     */
    public Date getAbandonTime() {
        return abandonTime;
    }

    /**
     * 设置放弃时间
     *
     * @param abandonTime 放弃时间
     */
    public void setAbandonTime(Date abandonTime) {
        this.abandonTime = abandonTime;
    }

    /**
     * 获取删除时间
     *
     * @return delete_time - 删除时间
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * 设置删除时间
     *
     * @param deleteTime 删除时间
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
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
     * 获取合同是否后台审核（1：审核成功 0：审核失败 2:待审核）
     *
     * @return is_compact_check - 合同是否后台审核（1：审核成功 0：审核失败 2:待审核）
     */
    public Integer getIsCompactCheck() {
        return isCompactCheck;
    }

    /**
     * 设置合同是否后台审核（1：审核成功 0：审核失败 2:待审核）
     *
     * @param isCompactCheck 合同是否后台审核（1：审核成功 0：审核失败 2:待审核）
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
     * 获取是否意向客户(0：有意向 1：无意向)
     *
     * @return is_interest_cust - 是否意向客户(0：有意向 1：无意向)
     */
    public Integer getIsInterestCust() {
        return isInterestCust;
    }

    /**
     * 设置是否意向客户(0：有意向 1：无意向)
     *
     * @param isInterestCust 是否意向客户(0：有意向 1：无意向)
     */
    public void setIsInterestCust(Integer isInterestCust) {
        this.isInterestCust = isInterestCust;
    }

    /**
     * 获取合同图片
     *
     * @return compact_img - 合同图片
     */
    public String getCompactImg() {
        return compactImg;
    }

    /**
     * 设置合同图片
     *
     * @param compactImg 合同图片
     */
    public void setCompactImg(String compactImg) {
        this.compactImg = compactImg == null ? null : compactImg.trim();
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
    public Double getPrice() {
        return price;
    }

    /**
     * 设置签约价格字段
     *
     * @param price 签约价格字段
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取放弃原因
     *
     * @return abandon_reason - 放弃原因
     */
    public String getAbandonReason() {
        return abandonReason;
    }

    /**
     * 设置放弃原因
     *
     * @param abandonReason 放弃原因
     */
    public void setAbandonReason(String abandonReason) {
        this.abandonReason = abandonReason == null ? null : abandonReason.trim();
    }

    /**
     * 获取删除原因
     *
     * @return delete_reason - 删除原因
     */
    public String getDeleteReason() {
        return deleteReason;
    }

    /**
     * 设置删除原因
     *
     * @param deleteReason 删除原因
     */
    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason == null ? null : deleteReason.trim();
    }

    /**
     * 获取审核失败原因
     *
     * @return check_refuse_reason - 审核失败原因
     */
    public String getCheckRefuseReason() {
        return checkRefuseReason;
    }

    /**
     * 设置审核失败原因
     *
     * @param checkRefuseReason 审核失败原因
     */
    public void setCheckRefuseReason(String checkRefuseReason) {
        this.checkRefuseReason = checkRefuseReason == null ? null : checkRefuseReason.trim();
    }

    /**
     * 获取赠送用户的金豆数（后台自定义）
     *
     * @return donate_gold_beans - 赠送用户的金豆数（后台自定义）
     */
    public Integer getDonateGoldBeans() {
        return donateGoldBeans;
    }

    /**
     * 设置赠送用户的金豆数（后台自定义）
     *
     * @param donateGoldBeans 赠送用户的金豆数（后台自定义）
     */
    public void setDonateGoldBeans(Integer donateGoldBeans) {
        this.donateGoldBeans = donateGoldBeans;
    }

    /**
     * 获取关联字段（可用于判断手机号是否为同一个人）
     *
     * @return relative_id - 关联字段（可用于判断手机号是否为同一个人）
     */
    public Integer getRelativeId() {
        return relativeId;
    }

    /**
     * 设置关联字段（可用于判断手机号是否为同一个人）
     *
     * @param relativeId 关联字段（可用于判断手机号是否为同一个人）
     */
    public void setRelativeId(Integer relativeId) {
        this.relativeId = relativeId;
    }

    /**
     * 获取最后一次操作时间
     *
     * @return last_modify_time - 最后一次操作时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置最后一次操作时间
     *
     * @param lastModifyTime 最后一次操作时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}