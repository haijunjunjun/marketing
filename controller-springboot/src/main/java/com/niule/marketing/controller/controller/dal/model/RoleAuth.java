package com.niule.marketing.controller.controller.dal.model;

public class RoleAuth {
    private Integer id;

    private Integer roleId;

    private String authInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo == null ? null : authInfo.trim();
    }
}