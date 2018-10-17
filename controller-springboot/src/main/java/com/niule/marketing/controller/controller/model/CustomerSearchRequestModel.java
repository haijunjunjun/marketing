package com.niule.marketing.controller.controller.model;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 10:54
 */
public class CustomerSearchRequestModel implements Serializable {
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private static final long serialVersionUID = 2230304964517001584L;
    private String custName;
    private String custPhone;
    private Integer status;
    private String userRealName;
    private String userPhone;
    private Integer pageNum;
    private Integer pageSize;
}
