package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "pay_record")
public class PayRecord {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 交易类型
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 交易说明
     */
    private String body;

    /**
     * 订单总金额
     */
    @Column(name = "total_fee")
    private String totalFee;

    /**
     * APP和网页支付提交用户端ip
     */
    @Column(name = "spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 返回url
     */
    @Column(name = "code_url")
    private String codeUrl;

    /**
     * 返回扫码支付id
     */
    @Column(name = "prepay_id")
    private String prepayId;

    /**
     * 返回代码
     */
    @Column(name = "return_code")
    private String returnCode;

    /**
     * 结果代码
     */
    @Column(name = "result_code")
    private String resultCode;

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
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取交易类型
     *
     * @return trade_type - 交易类型
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 设置交易类型
     *
     * @param tradeType 交易类型
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 获取交易说明
     *
     * @return body - 交易说明
     */
    public String getBody() {
        return body;
    }

    /**
     * 设置交易说明
     *
     * @param body 交易说明
     */
    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    /**
     * 获取订单总金额
     *
     * @return total_fee - 订单总金额
     */
    public String getTotalFee() {
        return totalFee;
    }

    /**
     * 设置订单总金额
     *
     * @param totalFee 订单总金额
     */
    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee == null ? null : totalFee.trim();
    }

    /**
     * 获取APP和网页支付提交用户端ip
     *
     * @return spbill_create_ip - APP和网页支付提交用户端ip
     */
    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    /**
     * 设置APP和网页支付提交用户端ip
     *
     * @param spbillCreateIp APP和网页支付提交用户端ip
     */
    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp == null ? null : spbillCreateIp.trim();
    }

    /**
     * 获取返回url
     *
     * @return code_url - 返回url
     */
    public String getCodeUrl() {
        return codeUrl;
    }

    /**
     * 设置返回url
     *
     * @param codeUrl 返回url
     */
    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl == null ? null : codeUrl.trim();
    }

    /**
     * 获取返回扫码支付id
     *
     * @return prepay_id - 返回扫码支付id
     */
    public String getPrepayId() {
        return prepayId;
    }

    /**
     * 设置返回扫码支付id
     *
     * @param prepayId 返回扫码支付id
     */
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    /**
     * 获取返回代码
     *
     * @return return_code - 返回代码
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * 设置返回代码
     *
     * @param returnCode 返回代码
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * 获取结果代码
     *
     * @return result_code - 结果代码
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 设置结果代码
     *
     * @param resultCode 结果代码
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
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
}