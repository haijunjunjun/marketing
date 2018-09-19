package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_record_final")
public class PayRecordFinal {
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
     * 合同编号
     */
    @Column(name = "compact_no")
    private String compactNo;

    /**
     * 返回信息
     */
    @Column(name = "return_msg")
    private String returnMsg;

    /**
     * 支付结果
     */
    @Column(name = "pay_result")
    private String payResult;

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
     * 获取合同编号
     *
     * @return compact_no - 合同编号
     */
    public String getCompactNo() {
        return compactNo;
    }

    /**
     * 设置合同编号
     *
     * @param compactNo 合同编号
     */
    public void setCompactNo(String compactNo) {
        this.compactNo = compactNo == null ? null : compactNo.trim();
    }

    /**
     * 获取返回信息
     *
     * @return return_msg - 返回信息
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * 设置返回信息
     *
     * @param returnMsg 返回信息
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }

    /**
     * 获取支付结果
     *
     * @return pay_result - 支付结果
     */
    public String getPayResult() {
        return payResult;
    }

    /**
     * 设置支付结果
     *
     * @param payResult 支付结果
     */
    public void setPayResult(String payResult) {
        this.payResult = payResult == null ? null : payResult.trim();
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