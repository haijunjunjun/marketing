package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "stick_price_setting")
public class StickPriceSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sign;

    private Long value;

    private String remark;

    /**
     * 该级别折扣
     */
    @Column(name = "discountValue")
    private Long discountvalue;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * @return value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取该级别折扣
     *
     * @return discountValue - 该级别折扣
     */
    public Long getDiscountvalue() {
        return discountvalue;
    }

    /**
     * 设置该级别折扣
     *
     * @param discountvalue 该级别折扣
     */
    public void setDiscountvalue(Long discountvalue) {
        this.discountvalue = discountvalue;
    }
}