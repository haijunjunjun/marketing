package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "alipay_record")
public class AlipayRecord {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "cust_id")
    private Integer custId;

    /**
     * 订单号
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 支付宝交易号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 总金额
     */
    @Column(name = "total_amount")
    private String totalAmount;

    /**
     * 支付说明
     */
    private String subject;

    /**
     * 预支付结果返回码
     */
    @Column(name = "pre_pay_code")
    private String prePayCode;

    /**
     * 预支付信息
     */
    @Column(name = "pre_pay_message")
    private String prePayMessage;

    /**
     * 支付状态
     */
    @Column(name = "pay_status")
    private String payStatus;

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
     * 获取订单号
     *
     * @return out_trade_no - 订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置订单号
     *
     * @param outTradeNo 订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * 获取支付宝交易号
     *
     * @return trade_no - 支付宝交易号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置支付宝交易号
     *
     * @param tradeNo 支付宝交易号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取总金额
     *
     * @return total_amount - 总金额
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置总金额
     *
     * @param totalAmount 总金额
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount == null ? null : totalAmount.trim();
    }

    /**
     * 获取支付说明
     *
     * @return subject - 支付说明
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置支付说明
     *
     * @param subject 支付说明
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 获取预支付结果返回码
     *
     * @return pre_pay_code - 预支付结果返回码
     */
    public String getPrePayCode() {
        return prePayCode;
    }

    /**
     * 设置预支付结果返回码
     *
     * @param prePayCode 预支付结果返回码
     */
    public void setPrePayCode(String prePayCode) {
        this.prePayCode = prePayCode == null ? null : prePayCode.trim();
    }

    /**
     * 获取预支付信息
     *
     * @return pre_pay_message - 预支付信息
     */
    public String getPrePayMessage() {
        return prePayMessage;
    }

    /**
     * 设置预支付信息
     *
     * @param prePayMessage 预支付信息
     */
    public void setPrePayMessage(String prePayMessage) {
        this.prePayMessage = prePayMessage == null ? null : prePayMessage.trim();
    }

    /**
     * 获取支付状态
     *
     * @return pay_status - 支付状态
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态
     *
     * @param payStatus 支付状态
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
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
}