package com.niule.marketing.control.dal.model;

import java.util.Date;

public class UserGoldBeans {
    private Integer id;

    private Integer userId;

    private Integer goldBeansNum;

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