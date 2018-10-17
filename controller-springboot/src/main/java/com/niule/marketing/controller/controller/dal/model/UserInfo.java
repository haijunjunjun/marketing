package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String password;

    private String phone;

    private Integer roleId;

    private String realName;

    private Integer sex;

    private Date createTime;

    private Integer status;

    private String openId;

    private Integer manageId;

    private String imageUrl;

    private String level;

    private Integer loginCount;

    private String manageLevel;

    private String area;

    private String city;

    private String cardNo;

    private String awaterImgUrl;

    private String cardPositiveImgUrl;

    private String cardOppositiveImgUrl;

    private Integer jobStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getManageLevel() {
        return manageLevel;
    }

    public void setManageLevel(String manageLevel) {
        this.manageLevel = manageLevel == null ? null : manageLevel.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getAwaterImgUrl() {
        return awaterImgUrl;
    }

    public void setAwaterImgUrl(String awaterImgUrl) {
        this.awaterImgUrl = awaterImgUrl == null ? null : awaterImgUrl.trim();
    }

    public String getCardPositiveImgUrl() {
        return cardPositiveImgUrl;
    }

    public void setCardPositiveImgUrl(String cardPositiveImgUrl) {
        this.cardPositiveImgUrl = cardPositiveImgUrl == null ? null : cardPositiveImgUrl.trim();
    }

    public String getCardOppositiveImgUrl() {
        return cardOppositiveImgUrl;
    }

    public void setCardOppositiveImgUrl(String cardOppositiveImgUrl) {
        this.cardOppositiveImgUrl = cardOppositiveImgUrl == null ? null : cardOppositiveImgUrl.trim();
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }
}