package com.niule.marketing.controller.controller.dal.model;

import java.util.Date;

public class BackgroundUserAuthInfo {
    private Integer id;

    private String pageInterface;

    private String backRoleIds;

    private String pageDesc;

    private String createName;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageInterface() {
        return pageInterface;
    }

    public void setPageInterface(String pageInterface) {
        this.pageInterface = pageInterface == null ? null : pageInterface.trim();
    }

    public String getBackRoleIds() {
        return backRoleIds;
    }

    public void setBackRoleIds(String backRoleIds) {
        this.backRoleIds = backRoleIds == null ? null : backRoleIds.trim();
    }

    public String getPageDesc() {
        return pageDesc;
    }

    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc == null ? null : pageDesc.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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