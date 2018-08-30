package com.niule.marketing.control.dal.model;

import java.util.Date;

public class CustGoldBeans {
    private Integer id;

    private Integer custId;

    private Integer goldBeansNum;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getGoldBeansNum() {
        return goldBeansNum;
    }

    public void setGoldBeansNum(Integer goldBeansNum) {
        this.goldBeansNum = goldBeansNum;
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