package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_receipt_apply")
public class UserReceiptApply {
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
     * 客户id
     */
    @Column(name = "cust_id")
    private Integer custId;

    /**
     * 申请人姓名
     */
    @Column(name = "apply_user_name")
    private String applyUserName;

    /**
     * 申请人手机号
     */
    @Column(name = "apply_user_phone")
    private String applyUserPhone;

    /**
     * 公司名字
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 税号
     */
    @Column(name = "duty_paragraph")
    private String dutyParagraph;

    /**
     * 发票抬头
     */
    @Column(name = "receipt_title")
    private String receiptTitle;

    /**
     * 申请时间
     */
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 状态 (99:所有  1 ：审核中 2：已通过 3：未通过)
     */
    private Integer status;

    /**
     * 通过凭证
     */
    @Column(name = "certificate_no")
    private String certificateNo;

    /**
     * 拒绝原因
     */
    @Column(name = "refuse_reason")
    private String refuseReason;

    /**
     * 发票申请金额
     */
    private Double price;

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
     * 发票邮寄地址
     */
    @Column(name = "cust_receipt_address")
    private String custReceiptAddress;

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
     * 获取客户id
     *
     * @return cust_id - 客户id
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     * 设置客户id
     *
     * @param custId 客户id
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    /**
     * 获取申请人姓名
     *
     * @return apply_user_name - 申请人姓名
     */
    public String getApplyUserName() {
        return applyUserName;
    }

    /**
     * 设置申请人姓名
     *
     * @param applyUserName 申请人姓名
     */
    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName == null ? null : applyUserName.trim();
    }

    /**
     * 获取申请人手机号
     *
     * @return apply_user_phone - 申请人手机号
     */
    public String getApplyUserPhone() {
        return applyUserPhone;
    }

    /**
     * 设置申请人手机号
     *
     * @param applyUserPhone 申请人手机号
     */
    public void setApplyUserPhone(String applyUserPhone) {
        this.applyUserPhone = applyUserPhone == null ? null : applyUserPhone.trim();
    }

    /**
     * 获取公司名字
     *
     * @return company_name - 公司名字
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名字
     *
     * @param companyName 公司名字
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取税号
     *
     * @return duty_paragraph - 税号
     */
    public String getDutyParagraph() {
        return dutyParagraph;
    }

    /**
     * 设置税号
     *
     * @param dutyParagraph 税号
     */
    public void setDutyParagraph(String dutyParagraph) {
        this.dutyParagraph = dutyParagraph == null ? null : dutyParagraph.trim();
    }

    /**
     * 获取发票抬头
     *
     * @return receipt_title - 发票抬头
     */
    public String getReceiptTitle() {
        return receiptTitle;
    }

    /**
     * 设置发票抬头
     *
     * @param receiptTitle 发票抬头
     */
    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle == null ? null : receiptTitle.trim();
    }

    /**
     * 获取申请时间
     *
     * @return apply_time - 申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请时间
     *
     * @param applyTime 申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取状态 (99:所有  1 ：审核中 2：已通过 3：未通过)
     *
     * @return status - 状态 (99:所有  1 ：审核中 2：已通过 3：未通过)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 (99:所有  1 ：审核中 2：已通过 3：未通过)
     *
     * @param status 状态 (99:所有  1 ：审核中 2：已通过 3：未通过)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取通过凭证
     *
     * @return certificate_no - 通过凭证
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * 设置通过凭证
     *
     * @param certificateNo 通过凭证
     */
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    /**
     * 获取拒绝原因
     *
     * @return refuse_reason - 拒绝原因
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 设置拒绝原因
     *
     * @param refuseReason 拒绝原因
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    /**
     * 获取发票申请金额
     *
     * @return price - 发票申请金额
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置发票申请金额
     *
     * @param price 发票申请金额
     */
    public void setPrice(Double price) {
        this.price = price;
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

    /**
     * 获取发票邮寄地址
     *
     * @return cust_receipt_address - 发票邮寄地址
     */
    public String getCustReceiptAddress() {
        return custReceiptAddress;
    }

    /**
     * 设置发票邮寄地址
     *
     * @param custReceiptAddress 发票邮寄地址
     */
    public void setCustReceiptAddress(String custReceiptAddress) {
        this.custReceiptAddress = custReceiptAddress == null ? null : custReceiptAddress.trim();
    }
}